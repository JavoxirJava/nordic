package unv.nordic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import unv.nordic.bot.BotMethods;
import unv.nordic.bot.BotSettings;

@SpringBootApplication
public class NordicApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(NordicApplication.class, args);
        BotMethods botMethods = run.getBean(BotMethods.class);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new BotSettings(botMethods));
        } catch (TelegramApiException e) {
            System.err.println("Bot run error");
            throw new RuntimeException(e);
        }
    }

}
