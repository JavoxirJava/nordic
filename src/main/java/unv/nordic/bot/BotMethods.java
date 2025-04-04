package unv.nordic.bot;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import unv.nordic.entity.User;
import unv.nordic.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class BotMethods {

    private final BotSettings botSettings;
    private final ButtonSettings buttonSettings;
    private final UserService userService;

    Map<Long, String> choose = new HashMap<>(); // careator panelda kerakli bulimni tanlash
    Map<Long, String> lang = new HashMap<>();
    Map<Long, String> fullName = new HashMap<>();
    Set<Long> ADMINS = Set.of(Template.CREATOR_ID);
    String UZ = "UZ", RU = "RU";

    public BotMethods(@Lazy BotSettings botSettings, ButtonSettings buttonSettings, UserService userService) {
        this.botSettings = botSettings;
        this.buttonSettings = buttonSettings;
        this.userService = userService;
    }

    public void message(Message message) {
        Long chatId = message.getChatId();
        Long userId = message.getFrom().getId();
        if (message.hasText()) {
            SendMessage sm = new SendMessage(chatId.toString(), message.getText());
            String text = message.getText();
            if (ADMINS.contains(userId)) creatorPanel(sm, text, chatId);
            else userPanel(sm, text, chatId);
        } else if (message.hasContact()) {
            if (choose.containsKey(userId) && choose.get(userId).equals("phone"))
                addUser(userId, message.getContact().getPhoneNumber());
        }
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
        }
    }

    public void userPanel(SendMessage sm, String text, Long userId) {
        if ("/start".equals(text)) {
            sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.chooseLang));
            sendMSG(sm, Text.chooseLang);
            choose.put(userId, "lang");
        } else if (choose.containsKey(userId)) {
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
                        sendMSG(sm, lang.get(userId).equals(UZ) ? Text.PHONE_UZ : Text.PHONE_RU);
                        fullName.put(userId, text);
                        choose.put(userId, "phone");
                    }
                    break;
                case "phone":
                    String phoneRegex = "^\\+9989[01]\\d{7}$";
                    if (lang.containsKey(userId)) {
                        if (text.matches(phoneRegex))
                            sendMSG(sm, lang.get(userId).equals(UZ) ? Text.FAILED_PHONE_UZ : Text.FAILED_PHONE_RU);
                        else {
                            addUser(userId, text);
                            if (lang.get(userId).equals(UZ)) {
                                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_UZ));
                                sendMSG(sm, Text.REGISTER_UZ);
                            } else {
                                sm.setReplyMarkup(buttonSettings.getKeyboardButton(Button.MENU_RU));
                                sendMSG(sm, Text.REGISTER_RU);
                            }
                            choose.put(userId, "menu");
                        }
                    }
                    break;
                case "menu":
                    menuCases(userId, text);
            }
        }
    }

    ///  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=  UserService  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=
    public void addUser(Long userId, String phoneNumber) {
        userService.saveUser(User.builder()
                .id(userId)
                .fullName(fullName.get(userId))
                .phoneNumber(phoneNumber)
                .language(lang.get(userId))
                .build());
    }

    ///  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=  Messages  +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+
    public void sendMSG(SendMessage sendMessage, String text) {
        try {
            sendMessage.setText(text);
            botSettings.execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("not execute");
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

    public void menuCases(Long userId, String text) {
        if (lang.containsKey(userId)) {
            switch (text) {
                case Button.INFO_UNIVERSITY_UZ:
                case Button.INFO_UNIVERSITY_RU:

            }
        }
    }
}