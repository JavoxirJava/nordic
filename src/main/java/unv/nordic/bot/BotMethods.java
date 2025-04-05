package unv.nordic.bot;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import unv.nordic.entity.User;
import unv.nordic.payload.DirectionResponse;
import unv.nordic.payload.EducationDirection;
import unv.nordic.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BotMethods {

    private final BotSettings botSettings;
    private final ButtonSettings buttonSettings;
    private final UserService userService;

    Map<Long, String> choose = new HashMap<>(); // careator panelda kerakli bulimni tanlash
    Map<Long, User> user = new HashMap<>();
    Map<Long, String> lang = new HashMap<>();
    Map<Long, String> fullName = new HashMap<>();
    Set<Long> ADMINS = Set.of(Template.CREATOR_ID);
    Set<String> directionMasterUzNames = new HashSet<>();
    Set<String> directionBachelorUzNames = new HashSet<>();
    Set<String> directionMasterRuNames = new HashSet<>();
    Set<String> directionBachelorRuNames = new HashSet<>();
    DirectionResponse directionMasterUz = new DirectionResponse();
    DirectionResponse directionBachelorUz = new DirectionResponse();
    DirectionResponse directionMasterRu = new DirectionResponse();
    DirectionResponse directionBachelorRu = new DirectionResponse();
    String UZ = "UZ", RU = "RU";

    public BotMethods(@Lazy BotSettings botSettings, ButtonSettings buttonSettings, UserService userService) {
        this.botSettings = botSettings;
        this.buttonSettings = buttonSettings;
        this.userService = userService;
    }

    public void message(Message message) {
        Long chatId = message.getChatId();
        Long userId = message.getFrom().getId();
        SendMessage sm = new SendMessage(chatId.toString(), "");
        if (message.hasText()) {
            String text = message.getText();
            if (ADMINS.contains(userId)) creatorPanel(sm, text, chatId);
            else userPanel(sm, text, chatId);
        } else if (message.hasContact())
            if (choose.containsKey(userId) && choose.get(userId).equals("phone"))
                registerUser(userId, sm, message.getContact().getPhoneNumber());
    }

    public void callbackData(CallbackQuery callbackQuery) {
        Long userId = callbackQuery.getMessage().getChatId();
        String data = callbackQuery.getData();
        SendMessage sm = new SendMessage(userId.toString(), data);
    }

    public void creatorPanel(SendMessage sm, String text, Long userId) {
        switch (text) {
            case "/start": {
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Template.ADMIN_PANEL));
                sendMSG(sm, "Kerakli bulimni tanlang!");
                break;
            }
            case "Add Group": {
                sendMSG(sm, "Guruh username sini kiriting: ");
                choose.put(userId, "username");
                break;
            }
            default:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.DEFAULT_UZ : Text.DEFAULT_RU);
                break;
        }
    }

    public void userPanel(SendMessage sm, String text, Long userId) {
        if ("/start".equals(text)) start(sm, userId);
        else if (choose.containsKey(userId)) {
            switch (choose.get(userId)) {
                /// register
                case "lang":
                    if (Button.UZ.equals(text)) {
                        sendMSG(sm, Text.FISH_UZ);
                        lang.put(userId, UZ);
                    } else {
                        sendMSG(sm, Text.FISH_RU);
                        lang.put(userId, RU);
                    }
                    choose.put(userId, "fish");
                    break;
                case "fish":
                    if (text.split(" ").length == 1 && lang.containsKey(userId))
                        sendMSG(sm, lang.get(userId).equals(UZ) ? Text.FAILED_FISH_UZ : Text.FAILED_FISH_RU);
                    else {
                        sm.setReplyMarkup(buttonSettings.phoneNumberOrLocation(true));
                        sendMSG(sm, lang.get(userId).equals(UZ) ? Text.PHONE_UZ : Text.PHONE_RU);
                        fullName.put(userId, text);
                        choose.put(userId, "phone");
                    }
                    break;
                case "phone":
                    String phoneRegex = "^\\+998\\d{9}$";
                    if (lang.containsKey(userId)) {
                        if (!text.matches(phoneRegex))
                            sendMSG(sm, lang.get(userId).equals(UZ) ? Text.FAILED_PHONE_UZ : Text.FAILED_PHONE_RU);
                        else registerUser(userId, sm, text);
                    }
                    break;
                /// buttons
                case "direction":
                    directionCases(sm, userId, text);
                    break;
                case "bachelors":
                    bachelorsDirectionCases(sm, userId, text);
                    getDirections(lang.get(userId), false);
                    break;
                case "ourSuccesses":
                    ourSuccessesCases(sm, userId, text);
                    break;
                case "masters":
                    masterDirectionCases(sm, userId, text);
                    break;
                default:
                    sendMSG(sm, lang.get(userId).equals(UZ) ? Text.DEFAULT_UZ : Text.DEFAULT_RU);
                    break;
            }
        } else menuCases(sm, userId, text);
    }

    ///  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=  UserService  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=
    public void start(SendMessage sm, Long userId) {
        if (user.containsKey(userId) && lang.containsKey(userId)) {
            if (lang.get(userId).equals(UZ)) {
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_UZ));
                sendMSG(sm, Text.MENU_UZ);
            } else {
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_RU));
                sendMSG(sm, Text.MENU_RU);
            }
            choose.remove(userId);
        } else {
            sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.chooseLang));
            sendMSG(sm, Text.chooseLang);
            choose.put(userId, "lang");
        }
    }

    public void addUser(Long userId, String phoneNumber) {
        userService.saveUser(User.builder()
                .id(userId)
                .fullName(fullName.get(userId))
                .phoneNumber(phoneNumber)
                .language(lang.get(userId))
                .build());
    }

    private void registerUser(Long userId, SendMessage sm, String phoneNumber) {
        if (userService.userIsRegisterNumber(phoneNumber)) {
            sendMSG(sm, lang.get(userId).equals(UZ) ? Text.REGISTERED_PHONE_UZ : Text.REGISTERED_PHONE_RU);
            return;
        }
        addUser(userId, phoneNumber);
        if (lang.get(userId).equals(UZ)) {
            sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_UZ));
            sendMSG(sm, Text.REGISTER_UZ);
        } else {
            sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_RU));
            sendMSG(sm, Text.REGISTER_RU);
        }
        choose.remove(userId);
    }

    public void getUsersInfo() {
        this.userService.getAllUsers().forEach(u -> {
            System.out.println("UserID: " + u.getId());
            user.put(u.getId(), u);
            lang.put(u.getId(), u.getLanguage());
        });
    }

    ///  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=  Messages  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
    public void sendMSG(SendMessage sendMessage, String text) {
        try {
            sendMessage.setText(text);
            botSettings.execute(sendMessage);
        } catch (TelegramApiException e) {
            System.err.println("not execute");
        }
    }

    public void sendPhoto(SendPhoto sendPhoto) {
        try {
            botSettings.execute(sendPhoto);
        } catch (TelegramApiException e) {
            System.err.println("not execute");
            System.err.println(e.getMessage());
        }
    }

    public void editCallbackQuery(CallbackQuery callbackQuery, InlineKeyboardMarkup newInlineKeyboard) {
        try {
            botSettings.execute(new EditMessageReplyMarkup(
                    callbackQuery.getMessage().getChatId().toString(),
                    callbackQuery.getMessage().getMessageId(),
                    null,
                    newInlineKeyboard
            ));
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendAnswer(String callbackQueryId, String text) {
        AnswerCallbackQuery acq = new AnswerCallbackQuery();
        acq.setText(text);
        acq.setShowAlert(true);
        acq.setCallbackQueryId(callbackQueryId);
        try {
            botSettings.executeAsync(acq);
        } catch (TelegramApiException e) {
            System.err.println("not answer");
        }
    }

    public void deleteMSG(Integer messageId, Long chatId) {
        try {
            botSettings.execute(new DeleteMessage(String.valueOf(chatId), messageId));
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }

    ///  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=  Switch cases  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+

    public void menuCases(SendMessage sm, Long userId, String text) {
        if (lang.containsKey(userId)) switch (text) {
            case Button.INFO_UNIVERSITY_UZ:
            case Button.INFO_UNIVERSITY_RU:
                sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.MESSENGERS));
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.INFO_UNIVERSITY_UZ : Text.INFO_UNIVERSITY_RU);
                break;
            case Button.DIRECTION_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_UZ));
                sendMSG(sm, Text.DIRECTION_UZ);
                choose.put(userId, "direction");
                break;
            case Button.DIRECTION_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_RU));
                sendMSG(sm, Text.DIRECTION_RU);
                choose.put(userId, "direction");
                break;
            case Button.WORK_AND_TRAVEL_UZ:
            case Button.WORK_AND_TRAVEL_RU:
                sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.YOUTUBE_VIDEO));
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.WORK_AND_TRAVEL_UZ : Text.WORK_AND_TRAVEL_RU);
                break;
            case Button.OFFICE_UZ:
            case Button.OFFICE_RU:
                sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.OFFICE_LOCATION));
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.OFFICE_UZ : Text.OFFICE_RU);
                break;
            case Button.CONTACT_OPERATOR_UZ:
            case Button.CONTACT_OPERATOR_RU:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.CONTACT_OPERATOR_UZ : Text.CONTACT_OPERATOR_RU);
                break;
            case Button.OUR_SUCCESSES_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.OUR_SUCCESSES_UZ_BUTTONS));
                sendMSG(sm, Text.OUR_SUCCESSES_RU);
                choose.put(userId, "ourSuccesses");
                break;
            case Button.OUR_SUCCESSES_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.OUR_SUCCESSES_RU_BUTTONS));
                sendMSG(sm, Text.OUR_SUCCESSES_UZ);
                choose.put(userId, "ourSuccesses");
                break;
            case Button.CHOOSE_LANGUAGE_UZ:
                User updateUserUz = userService.updateLanguage(userId, RU);
                user.put(updateUserUz.getId(), updateUserUz);
                lang.put(updateUserUz.getId(), updateUserUz.getLanguage());
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_RU));
                sendMSG(sm, Text.MENU_RU);
                choose.remove(userId);
                break;
            case Button.CHOOSE_LANGUAGE_RU:
                User updateUserRu = userService.updateLanguage(userId, UZ);
                user.put(updateUserRu.getId(), updateUserRu);
                lang.put(updateUserRu.getId(), updateUserRu.getLanguage());
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_UZ));
                sendMSG(sm, Text.MENU_UZ);
                choose.remove(userId);
                break;
            default:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.DEFAULT_UZ : Text.DEFAULT_RU);
                break;
        }
    }

    public void directionCases(SendMessage sm, Long userId, String text) {
        if (lang.containsKey(userId)) switch (text) {
            case Button.BACHELORS_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_2_UZ));
                sendMSG(sm, Text.DIRECTION_UZ);
                choose.put(userId, "bachelors");
                break;
            case Button.BACHELORS_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_2_RU));
                sendMSG(sm, Text.DIRECTION_RU);
                choose.put(userId, "bachelors");
                break;
            case Button.MASTERS_UZ:
                getDirections(lang.get(userId), true);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(createButtons(directionMasterUz.getFullTime(), UZ, true)));
                sendMSG(sm, Text.MASTERS_UZ);
                choose.put(userId, "masters");
                break;
            case Button.MASTERS_RU:
                getDirections(lang.get(userId), true);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(createButtons(directionMasterRu.getFullTime(), RU, true)));
                sendMSG(sm, Text.MASTERS_RU);
                choose.put(userId, "masters");
                break;
            case Button.BACK_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_UZ));
                sendMSG(sm, Text.MENU_UZ);
                choose.remove(userId);
                break;
            case Button.BACK_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_RU));
                sendMSG(sm, Text.MENU_RU);
                choose.remove(userId);
                break;
            default:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.DEFAULT_UZ : Text.DEFAULT_RU);
                break;
        }
    }

    public void bachelorsDirectionCases(SendMessage sm, Long userId, String text) {
        switch (text) {
            case Button.DAY_TIME_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.BACHELORS_DAY_TIME_DIRECTIONS_UZ));
                sendMSG(sm, Text.DAY_TIME_UZ);
                choose.put(userId, "day_time");
                break;
            case Button.DAY_TIME_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.BACHELORS_DAY_TIME_DIRECTIONS_RU));
                sendMSG(sm, Text.DAY_TIME_RU);
                choose.put(userId, "day_time");
                break;
            case Button.SURFACE_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.BACHELORS_SURFACE_DIRECTIONS_UZ));
                sendMSG(sm, Text.SURFACE_UZ);
                choose.put(userId, "surface");
                break;
            case Button.SURFACE_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.BACHELORS_SURFACE_DIRECTIONS_RU));
                sendMSG(sm, Text.SURFACE_RU);
                choose.put(userId, "surface");
                break;
            case Button.SPECIAL_CORRESPONDENCE_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.BACHELORS_SPECIAL_CORRESPONDENCE_DIRECTIONS_UZ));
                sendMSG(sm, Text.SPECIAL_CORRESPONDENCE_UZ);
                choose.put(userId, "special_correspondence");
                break;
            case Button.SPECIAL_CORRESPONDENCE_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.BACHELORS_SPECIAL_CORRESPONDENCE_DIRECTIONS_RU));
                sendMSG(sm, Text.SPECIAL_CORRESPONDENCE_RU);
                choose.put(userId, "special_correspondence");
                break;
            case Button.BACK_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_UZ));
                sendMSG(sm, Text.DIRECTION_UZ);
                choose.put(userId, "direction");
                break;
            case Button.BACK_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_RU));
                sendMSG(sm, Text.DIRECTION_RU);
                choose.put(userId, "direction");
                break;
            default:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.DEFAULT_UZ : Text.DEFAULT_RU);
                break;
        }

    }

    public void ourSuccessesCases(SendMessage sm, Long userId, String text) {
        if (lang.containsKey(userId)) switch (text) {
            case Button.SCHOLARSHIP_RECIPIENTS_UZ:
            case Button.SCHOLARSHIP_RECIPIENTS_RU:
                sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.SCHOLARSHIP_RECIPIENTS_UZ_LINKS));
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.SCHOLARSHIP_RECIPIENTS_UZ : Text.SCHOLARSHIP_RECIPIENTS_RU);
                break;
            case Button.OUR_ARCHIVEMENTS_UZ:
            case Button.OUR_ARCHIVEMENTS_RU:
                sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.MESSENGERS));
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.OUR_ARCHIVEMENTS_UZ : Text.OUR_ARCHIVEMENTS_RU);
                break;
            case Button.MORE_DETAILS_UZ:
            case Button.MORE_DETAILS_RU:
                sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.MESSENGERS));
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.MORE_DETAILS_UZ : Text.MORE_DETAILS_RU);
                break;
            case Button.BACK_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_UZ));
                sendMSG(sm, Text.MENU_UZ);
                choose.remove(userId);
                break;
            case Button.BACK_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_RU));
                sendMSG(sm, Text.MENU_RU);
                choose.remove(userId);
                break;
            default:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.DEFAULT_UZ : Text.DEFAULT_RU);
                break;
        }
    }

    public void masterDirectionCases(SendMessage sm, Long userId, String text) {
        if (lang.containsKey(userId)) {
            if (lang.get(userId).equals(UZ)) {
                if (directionMasterUzNames.contains(text)) {
                    String name = text.substring(3);
                    directionMasterUz.getFullTime().forEach(fullTime -> {
                        if (fullTime.getName().equals(name)) {
                            sendDuration(userId, name, fullTime.getDuration(), fullTime.getPrice(), fullTime.getFieldCode(), fullTime.getFieldLang(), fullTime.getImage().getFilePath());
                        }
                    });
                }
            }
        }
    }

    public void sendDuration(Long userId, String name, int duration, int price, String field_code, String field_lang, String file_path) {
        String durationText = String.format(lang.get(userId).equals(UZ) ? Text.DURATION_TEXT_UZ : Text.DURATION_TEXT_RU,
                name, price, duration, field_lang, field_code);

        SendPhoto sp = new SendPhoto(userId.toString(), new InputFile("https://source.nordicuniversity.org" + file_path));
        sp.setCaption(durationText);

        sendPhoto(sp);
    }

    public void getDirections(String language, boolean isMaster) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://source.nordicuniversity.org/api/education/directions?eduDegree=" + (isMaster ? "MASTER" : "BACHELOR") + "&language=" + language.toLowerCase();

        ResponseEntity<DirectionResponse> response = restTemplate.getForEntity(url, DirectionResponse.class);

        if (language.equals(UZ)) {
            if (isMaster) directionMasterUz = response.getBody();
            else directionBachelorUz = response.getBody();
        } else {
            if (isMaster) directionMasterRu = response.getBody();
            else directionBachelorRu = response.getBody();
        }
    }

    public List<String> createButtons(List<EducationDirection> directions, String language, boolean isMaster) {
        if (language.equals(UZ)) {
            if (isMaster) return getButtons(directions, directionMasterUzNames, Button.BACK_UZ);
            else return getButtons(directions, directionBachelorUzNames, Button.BACK_UZ);
        } else {
            if (isMaster) return getButtons(directions, directionMasterRuNames, Button.BACK_RU);
            else return getButtons(directions, directionBachelorRuNames, Button.BACK_RU);
        }
    }

    public List<String> getButtons(List<EducationDirection> directions, Set<String> durations, String back) {
        List<String> buttons = directions.stream()
                .map(direction -> {
                    String name = Text.BOOK + direction.getName();
                    durations.add(name);
                    return name;
                })
                .collect(Collectors.toCollection(ArrayList::new));

        buttons.add(back);
        return buttons;
    }
}