package unv.nordic.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class BotSettings extends TelegramLongPollingBot {

    final BotMethods botMethods;
    Thread botThread;

    @Override
    public void onUpdateReceived(Update update) {
        botThread = new Thread(() -> {
            System.out.println(Template.ANSI_BLUE + botThread.getName() + " -> New Thread started." + Template.ANSI_RESET);
            if (update.hasMessage()) botMethods.message(update.getMessage());
            else if (update.hasCallbackQuery()) botMethods.callbackData(update.getCallbackQuery());
            stopBot();
        });
        botThread.start();
    }

    @Override
    public String getBotUsername() {
        return Template.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Template.BOT_TOKEN;
    }

    public void stopBot() {
        if (botThread != null && botThread.isAlive()) {
            botThread.interrupt();
            System.err.println(Template.ANSI_RED + botThread.getName() + " -> Bot thread stopped." + Template.ANSI_RESET);
        }
    }
}
