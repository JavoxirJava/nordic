package unv.nordic.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import unv.nordic.payload.Link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ButtonSettings {


    /// inlineButton
    public InlineKeyboardMarkup getInlineMarkup(List<String> list) {
        return new InlineKeyboardMarkup(getInlineButtonRows(list));
    }

    /// inlineLinkButton
    public InlineKeyboardMarkup getInlineMarkupLink(List<Link> links) {
        return new InlineKeyboardMarkup(getInlineButtonRowsLink(links));
    }

    /// button
    private List<List<InlineKeyboardButton>> getInlineButtonRows(List<String> data) {
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        int length = data.size() % 2 != 0 ? data.size() - 1 : data.size();
        for (int i = 0; i < length; i += 2) {
            List<InlineKeyboardButton> inlineButton = new ArrayList<>();
            inlineButton.add(getInlineButton(data.get(i), data.get(i), false));
            inlineButton.add(getInlineButton(data.get(i + 1), data.get(i + 1), false));
            rows.add(inlineButton);
        }
        if (data.size() % 2 != 0) {
            String text = data.get(data.size() - 1);
            rows.add(Collections.singletonList(getInlineButton(text, text, false)));
        }
        return rows;
    }

    /// links
    private List<List<InlineKeyboardButton>> getInlineButtonRowsLink(List<Link> links) {
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        int length = links.size() % 2 != 0 ? links.size() - 1 : links.size();
        for (int i = 0; i < length; i += 2) {
            List<InlineKeyboardButton> inlineButton = new ArrayList<>();
            inlineButton.add(getInlineButton(links.get(i).name(), links.get(i).url(), true));
            inlineButton.add(getInlineButton(links.get(i + 1).name(), links.get(i + 1).url(), true));
            rows.add(inlineButton);
        }
        if (links.size() % 2 != 0) {
            Link link = links.get(links.size() - 1);
            rows.add(Collections.singletonList(getInlineButton(link.name(), link.url(), true)));
        }
        return rows;
    }

    private InlineKeyboardButton getInlineButton(String text, String callback, boolean isLink) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        if (isLink) inlineKeyboardButton.setUrl(callback);
        else inlineKeyboardButton.setCallbackData(callback);
        inlineKeyboardButton.setText(text);
        return inlineKeyboardButton;
    }


    /// keyboardButton
    public ReplyKeyboardMarkup getKeyboardButton(List<String> data) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        int length = data.size() % 2 != 0 ? data.size() - 1 : data.size();
        for (int i = 0; i < length; i += 2) {
            KeyboardRow keyboardRow = new KeyboardRow();
            keyboardRow.add(getKeyboardButton(data.get(i)));
            keyboardRow.add(getKeyboardButton(data.get(i + 1)));
            keyboardRows.add(keyboardRow);
        }
        KeyboardRow keyboardRow2 = new KeyboardRow();
        if (data.size() % 2 != 0) {
            keyboardRow2.add(getKeyboardButton(data.get(data.size() - 1)));
        }
        keyboardRows.add(keyboardRow2);
        markup.setSelective(true);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        markup.setKeyboard(keyboardRows);
        return markup;
    }


    private KeyboardButton getKeyboardButton(String text) {
        return new KeyboardButton(text);
    }

    /// Number or Location
    public ReplyKeyboardMarkup phoneNumberOrLocation(boolean isPhone) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton();
        if (isPhone) {
            keyboardButton.setText("Telefon raqamni yuborish");
            keyboardButton.setRequestContact(true);
        } else {
            keyboardButton.setText("hozirgi joylashuvni yuborish");
            keyboardButton.setRequestLocation(true);
        }
        keyboardFirstRow.add(keyboardButton);
        keyboard.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}