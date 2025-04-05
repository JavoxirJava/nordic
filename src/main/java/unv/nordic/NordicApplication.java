package unv.nordic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import unv.nordic.bot.BotMethods;
import unv.nordic.bot.BotSettings;
import unv.nordic.bot.ButtonSettings;
import unv.nordic.service.ExcelExporter;
import unv.nordic.service.ImageUploader;
import unv.nordic.service.UserService;

@SpringBootApplication
public class NordicApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(NordicApplication.class, args);
        BotSettings botSettings = run.getBean(BotSettings.class);
        ButtonSettings buttonSettings = run.getBean(ButtonSettings.class);
        UserService userService = run.getBean(UserService.class);
        ExcelExporter excelExporter = run.getBean(ExcelExporter.class);
        ImageUploader imageUploader = run.getBean(ImageUploader.class);

        BotMethods botMethods = new BotMethods(botSettings, buttonSettings, userService, excelExporter, imageUploader);

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new BotSettings(botMethods));
        } catch (TelegramApiException e) {
            System.err.println("Bot run error");
            throw new RuntimeException(e);
        }
    }

}
