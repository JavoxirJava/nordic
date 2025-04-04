package unv.nordic.bot;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import unv.nordic.entity.User;

@Component
public class AutoRun {

    private final BotMethods botMethods;

    public AutoRun(BotMethods botMethods) {
        this.botMethods = botMethods;
    }

    @PostConstruct
    public void init() {
        botMethods.getUsersInfo();
    }
}
