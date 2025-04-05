package unv.nordic.bot;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import unv.nordic.entity.User;
import unv.nordic.payload.DirectionResponse;
import unv.nordic.payload.EducationDirection;
import unv.nordic.service.ExcelExporter;
import unv.nordic.service.ImageUploader;
import unv.nordic.service.UserService;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BotMethods {

    private final BotSettings botSettings;
    private final ButtonSettings buttonSettings;
    private final UserService userService;
    private final ExcelExporter excelExporter;

    Map<Long, String> choose = new HashMap<>();
    Map<Long, User> user = new HashMap<>();
    Map<Long, String> lang = new HashMap<>();
    Map<Long, String> fullName = new HashMap<>();
    Map<String, String> images = new HashMap<>();
    Set<Long> ADMINS = Set.of(Template.CREATOR_ID);
    Set<String> directionBachelorDayTimeNamesUz = new HashSet<>();
    Set<String> directionBachelorSurfaceNamesUz = new HashSet<>();
    Set<String> directionBachelorSpecialCorrespondenceNamesUz = new HashSet<>();
    Set<String> directionBachelorDayTimeNamesRu = new HashSet<>();
    Set<String> directionBachelorSurfaceNamesRu = new HashSet<>();
    Set<String> directionBachelorSpecialCorrespondenceNamesRu = new HashSet<>();
    Set<String> directionMasterUzNames = new HashSet<>();
    Set<String> directionMasterRuNames = new HashSet<>();
    DirectionResponse directionMasterUz = new DirectionResponse();
    DirectionResponse directionBachelorUz = new DirectionResponse();
    DirectionResponse directionMasterRu = new DirectionResponse();
    DirectionResponse directionBachelorRu = new DirectionResponse();
    String UZ = "UZ", RU = "RU";
    private static int counter = 0;

    public BotMethods(@Lazy BotSettings botSettings, ButtonSettings buttonSettings, UserService userService, ExcelExporter excelExporter, @Lazy ImageUploader imageUploader) {
        this.botSettings = botSettings;
        this.buttonSettings = buttonSettings;
        this.userService = userService;
        this.excelExporter = excelExporter;

        /// users info write
        counter++;
        if (counter == 2) {
            getUsersInfo();
            images = imageUploader.loadExistingFileIds();
        }
    }

    public void message(Message message) {
        Long chatId = message.getChatId();
        Long userId = message.getFrom().getId();
        SendMessage sm = new SendMessage(chatId.toString(), "");
        boolean isSendMessage = (ADMINS.contains(userId) && choose.containsKey(userId) && choose.get(userId).equals("sendMessage"));
        if (message.hasText()) {
            String text = message.getText();
            if (ADMINS.contains(userId)) creatorPanel(sm, text, chatId);
            else userPanel(sm, text, chatId);
        } else if (message.hasContact()) {
            if (choose.containsKey(userId) && choose.get(userId).equals("phone"))
                registerUser(userId, sm, message.getContact().getPhoneNumber());
        } else if (message.hasPhoto() && isSendMessage) {
            List<PhotoSize> photos = message.getPhoto();
            String fileId = photos.get(photos.size() - 1).getFileId();

            String caption = message.getCaption();

            userService.getAllUsers().forEach(user1 -> {
                SendPhoto sp = new SendPhoto();
                sp.setChatId(user1.getId().toString());
                sp.setPhoto(new InputFile(fileId));
                if (caption != null) sp.setCaption(caption);
                sendPhoto(sp);
            });

            sm.setChatId(Template.CREATOR_ID);
            sendMSG(sm, Text.ADMIN_SUCCESS_SEND_MESSAGE);
        } else if (message.hasVideo() && isSendMessage) {

            String fileId = message.getVideo().getFileId();
            String caption = message.getCaption();

            userService.getAllUsers().forEach(user1 -> {
                SendVideo sv = new SendVideo();
                sv.setChatId(user1.getId().toString());
                sv.setVideo(new InputFile(fileId));
                if (caption != null) sv.setCaption(caption);

                sendVideo(sv);
            });

            sm.setChatId(Template.CREATOR_ID);
            sendMSG(sm, Text.ADMIN_SUCCESS_SEND_MESSAGE);
        }
    }

    public void creatorPanel(SendMessage sm, String text, Long userId) {
        switch (text) {
            case "/start": {
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.ADMIN_MENU));
                sendMSG(sm, Text.ADMIN_TEXT);
                break;
            }
            case Button.SEND_MESSAGE:
                sendMSG(sm, Text.ADMIN_SEND_MESSAGE);
                choose.put(userId, "sendMessage");
                break;
            case Button.GET_USER_COUNT:
                Long userCount = userService.getUserCount();
                sendMSG(sm, Text.ADMIN_USER_COUNT + userCount);
                break;
            case Button.GET_USERS_TABLE:
                sendMSG(sm, Text.ADMIN_GET_USERS_TABLE);
                List<User> users = userService.getAllUsers();
                File file = excelExporter.exportUsersToExcel(users);
                sendExcelToTelegram(userId, file);
                break;
            default:
                if (choose.containsKey(userId) && choose.get(userId).equals("sendMessage")) {
                    userService.getAllUsers().forEach(user1 -> {
                        sm.setChatId(user1.getId());
                        sendMSG(sm, text);
                    });
                    sm.setChatId(Template.CREATOR_ID);
                    sendMSG(sm, Text.ADMIN_SUCCESS_SEND_MESSAGE);
                } else sendMSG(sm, lang.get(userId).equals(UZ) ? Text.DEFAULT_UZ : Text.DEFAULT_RU);
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
                case "day_time_uz":
                    bachelorDirectionCases(sm, userId, text, directionBachelorDayTimeNamesUz, directionBachelorUz.getFullTime());
                    break;
                case "day_time_ru":
                    bachelorDirectionCases(sm, userId, text, directionBachelorDayTimeNamesRu, directionBachelorRu.getFullTime());
                    break;
                case "surface_uz":
                    bachelorDirectionCases(sm, userId, text, directionBachelorSurfaceNamesUz, directionBachelorUz.getPartTime());
                    break;
                case "surface_ru":
                    bachelorDirectionCases(sm, userId, text, directionBachelorSurfaceNamesRu, directionBachelorRu.getPartTime());
                    break;
                case "special_correspondence_uz":
                    bachelorDirectionCases(sm, userId, text, directionBachelorSpecialCorrespondenceNamesUz, directionBachelorUz.getSpecialPartTime());
                    break;
                case "special_correspondence_ru":
                    bachelorDirectionCases(sm, userId, text, directionBachelorSpecialCorrespondenceNamesRu, directionBachelorRu.getSpecialPartTime());
                    break;
                case "grant_recipients":
                    grantRecipientsCases(sm, userId, text);
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

    public void sendVideo(SendVideo sendVideo) {
        try {
            botSettings.execute(sendVideo);
        } catch (TelegramApiException e) {
            System.err.println("not execute");
            System.err.println(e.getMessage());
        }
    }

    public void sendExcelToTelegram(Long chatId, File excelFile) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId.toString());
        sendDocument.setDocument(new InputFile(excelFile, "users.xlsx"));

        try {
            botSettings.execute(sendDocument);
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
                sendMSG(sm, Text.OUR_SUCCESSES_UZ);
                choose.put(userId, "ourSuccesses");
                break;
            case Button.OUR_SUCCESSES_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.OUR_SUCCESSES_RU_BUTTONS));
                sendMSG(sm, Text.OUR_SUCCESSES_RU);
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
                getDirections(lang.get(userId), false);
                break;
            case Button.BACHELORS_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_2_RU));
                sendMSG(sm, Text.DIRECTION_RU);
                choose.put(userId, "bachelors");
                getDirections(lang.get(userId), false);
                break;
            case Button.MASTERS_UZ:
                getDirections(lang.get(userId), true);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(createButtons(directionMasterUz.getFullTime(), UZ, true, Text.SPECIAL_CORRESPONDENCE)));
                sendMSG(sm, Text.MASTERS_UZ);
                choose.put(userId, "masters");
                break;
            case Button.MASTERS_RU:
                getDirections(lang.get(userId), true);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(createButtons(directionMasterRu.getFullTime(), RU, true, Text.SPECIAL_CORRESPONDENCE)));
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
        List<String> buttons;
        switch (text) {
            case Button.DAY_TIME_UZ:
                buttons = createButtons(directionBachelorUz.getFullTime(), UZ, false, Text.DAY_TIME);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(buttons));
                sendMSG(sm, Text.DAY_TIME_UZ);
                choose.put(userId, "day_time_uz");
                break;
            case Button.DAY_TIME_RU:
                buttons = createButtons(directionBachelorRu.getFullTime(), RU, false, Text.DAY_TIME);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(buttons));
                sendMSG(sm, Text.DAY_TIME_RU);
                choose.put(userId, "day_time_ru");
                break;
            case Button.SURFACE_UZ:
                buttons = createButtons(directionBachelorUz.getPartTime(), UZ, false, Text.SURFACE);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(buttons));
                sendMSG(sm, Text.SURFACE_UZ);
                choose.put(userId, "surface_uz");
                break;
            case Button.SURFACE_RU:
                buttons = createButtons(directionBachelorRu.getPartTime(), RU, false, Text.SURFACE);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(buttons));
                sendMSG(sm, Text.SURFACE_RU);
                choose.put(userId, "surface_ru");
                break;
            case Button.SPECIAL_CORRESPONDENCE_UZ:
                buttons = createButtons(directionBachelorUz.getSpecialPartTime(), UZ, false, Text.SPECIAL_CORRESPONDENCE);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(buttons));
                sendMSG(sm, Text.SPECIAL_CORRESPONDENCE_UZ);
                choose.put(userId, "special_correspondence_uz");
                break;
            case Button.SPECIAL_CORRESPONDENCE_RU:
                buttons = createButtons(directionBachelorRu.getSpecialPartTime(), RU, false, Text.SPECIAL_CORRESPONDENCE);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(buttons));
                sendMSG(sm, Text.SPECIAL_CORRESPONDENCE_RU);
                choose.put(userId, "special_correspondence_ru");
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
                sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.SCHOLARSHIP_RECIPIENTS_UZ_LINKS));
                sendMSG(sm, Text.SCHOLARSHIP_RECIPIENTS_UZ);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.GRANT_RECIPIENTS_UZ));
                sendMSG(sm, Text.DIRECTION_UZ);
                choose.put(userId, "grant_recipients");
                break;
            case Button.SCHOLARSHIP_RECIPIENTS_RU:
                sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.SCHOLARSHIP_RECIPIENTS_UZ_LINKS));
                sendMSG(sm, Text.SCHOLARSHIP_RECIPIENTS_RU);
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.GRANT_RECIPIENTS_RU));
                sendMSG(sm, Text.DIRECTION_RU);
                choose.put(userId, "grant_recipients");
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
            if (Button.BACK_UZ.equals(text)) {
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_UZ));
                sendMSG(sm, Text.DIRECTION_UZ);
                choose.put(userId, "direction");
            } else if (Button.BACK_RU.equals(text)) {
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_RU));
                sendMSG(sm, Text.DIRECTION_RU);
                choose.put(userId, "direction");
            } else if (lang.get(userId).equals(UZ))
                sendDurationInfo(userId, text, directionMasterUzNames, directionMasterUz.getFullTime());
            else sendDurationInfo(userId, text, directionMasterRuNames, directionMasterRu.getFullTime());
        }
    }

    public void bachelorDirectionCases(SendMessage sm, Long userId, String text, Set<String> buttons, List<EducationDirection> educationDirections) {
        if (lang.containsKey(userId)) {
            if (Button.BACK_UZ.equals(text)) {
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_2_UZ));
                sendMSG(sm, Text.DIRECTION_UZ);
                choose.put(userId, "bachelors");
            } else if (Button.BACK_RU.equals(text)) {
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.DIRECTIONS_2_RU));
                sendMSG(sm, Text.DIRECTION_RU);
                choose.put(userId, "bachelors");
            } else sendDurationInfo(userId, text, buttons, educationDirections);
        }
    }

    public void grantRecipientsCases(SendMessage sm, Long userId, String text) {
        SendPhoto sp = new SendPhoto();
        sp.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.MESSENGERS));
        sm.setReplyMarkup(buttonSettings.getInlineMarkupLink(Button.MESSENGERS));

        switch (text) {
            case Button.KOREA_UZ:
            case Button.KOREA_RU:
                sp.setChatId(userId);
                sp.setPhoto(new InputFile(images.get(Button.KOREA_IMAGE_NAME)));
                sp.setCaption(lang.get(userId).equals(UZ) ? Text.KOREA_UZ : Text.KOREA_RU);
                sendPhoto(sp);
                break;
            case Button.ITALY_UZ:
                sendMSG(sm, Text.ITALY_UZ);
                sendMSG(sm, Text.ITALY_2_UZ);
                sendMSG(sm, Text.ITALY_3_UZ);
                break;
            case Button.ITALY_RU:
                sendMSG(sm, Text.ITALY_RU);
                sendMSG(sm, Text.ITALY_2_RU);
                sendMSG(sm, Text.ITALY_3_RU);
                break;
            case Button.UZ_REPORT_UZ:
            case Button.UZ_REPORT_RU:
                sp.setChatId(userId);
                sp.setPhoto(new InputFile(images.get(Button.UZ_REPORT_IMAGE_NAME)));
                sp.setCaption(lang.get(userId).equals(UZ) ? Text.UZ_REPORT_1_UZ : Text.UZ_REPORT_1_RU);
                sendPhoto(sp);
                sp.setPhoto(new InputFile(images.get(Button.UZ_REPORT_IMAGE_NAME_2)));
                sp.setCaption(lang.get(userId).equals(UZ) ? Text.UZ_REPORT_2_UZ : Text.UZ_REPORT_2_RU);
                sendPhoto(sp);
                break;
            case Button.POLAND_UZ:
            case Button.POLAND_RU:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.POLAND_UZ : Text.POLAND_RU);
                break;
            case Button.AMERICA_UZ:
            case Button.AMERICA_RU:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.AMERICA_UZ : Text.AMERICA_RU);
                break;
            case Button.BACK_UZ:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.OUR_SUCCESSES_UZ_BUTTONS));
                sendMSG(sm, Text.OUR_SUCCESSES_UZ);
                choose.put(userId, "ourSuccesses");
                break;
            case Button.BACK_RU:
                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.OUR_SUCCESSES_RU_BUTTONS));
                sendMSG(sm, Text.OUR_SUCCESSES_RU);
                choose.put(userId, "ourSuccesses");
                break;
            default:
                sendMSG(sm, lang.get(userId).equals(UZ) ? Text.DEFAULT_UZ : Text.DEFAULT_RU);
                break;

        }
    }

    private void sendDurationInfo(Long userId, String text, Set<String> direction, List<EducationDirection> educationDirections) {
        if (direction.contains(text)) {
            String name = text.substring(Text.BOOK_INDEX);
            educationDirections.forEach(time -> {
                if (time.getName().equals(name)) {
                    sendDuration(userId, name, time.getDuration(), time.getPrice(), time.getFieldCode(), time.getFieldLang(), time.getImage().getFilePath());
                }
            });
        }
    }

    public void sendDuration(Long userId, String name, int duration, int price, String field_code, String field_lang, String file_path) {
        String durationText = String.format(lang.get(userId).equals(UZ) ? Text.DURATION_TEXT_UZ : Text.DURATION_TEXT_RU,
                name, price, duration, field_lang, field_code);

        SendPhoto sp = new SendPhoto(userId.toString(), new InputFile(Template.API_URL + file_path));
        sp.setCaption(durationText);

        sendPhoto(sp);
    }

    public void getDirections(String language, boolean isMaster) {
        RestTemplate restTemplate = new RestTemplate();

        String url = Template.API_URL + "/api/education/directions?eduDegree=" + (isMaster ? "MASTER" : "BACHELOR") + "&language=" + language.toLowerCase();

        ResponseEntity<DirectionResponse> response = restTemplate.getForEntity(url, DirectionResponse.class);

        if (language.equals(UZ)) {
            if (isMaster) directionMasterUz = response.getBody();
            else directionBachelorUz = response.getBody();
        } else {
            if (isMaster) directionMasterRu = response.getBody();
            else directionBachelorRu = response.getBody();
        }
    }

    public List<String> createButtons(List<EducationDirection> directions, String language, boolean isMaster, int bachelor) {
        if (language.equals(UZ)) {
            if (isMaster) return getButtons(directions, directionMasterUzNames, Button.BACK_UZ);
            else {
                if (bachelor == Text.DAY_TIME)
                    return getButtons(directions, directionBachelorDayTimeNamesUz, Button.BACK_UZ);
                else if (bachelor == Text.SURFACE)
                    return getButtons(directions, directionBachelorSurfaceNamesUz, Button.BACK_UZ);
                return getButtons(directions, directionBachelorSpecialCorrespondenceNamesUz, Button.BACK_UZ);
            }
        } else {
            if (isMaster) return getButtons(directions, directionMasterRuNames, Button.BACK_RU);
            else {
                if (bachelor == Text.DAY_TIME)
                    return getButtons(directions, directionBachelorDayTimeNamesRu, Button.BACK_RU);
                else if (bachelor == Text.SURFACE)
                    return getButtons(directions, directionBachelorSurfaceNamesRu, Button.BACK_RU);
                return getButtons(directions, directionBachelorSpecialCorrespondenceNamesRu, Button.BACK_RU);
            }
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