package unv.nordic.bot;

import java.util.List;

public interface Template {
    List<String> ADMIN_PANEL = List.of("Add Group", "Get Groups", "Delete Group");
    List<String> IS_DELETED = List.of("O'chirish", "Bekor qilish");
    String BOT_TOKEN = "7893721856:AAEb9kdCBdBz3eb9zlciCTmWc2218wH62s8";
    String BOT_USERNAME = "@guruh_tekshir_bot";
//    String CREATOR_ID = "3242234234"; // 1085241246
    Long CREATOR_ID = 1085241246L;

    /// Colors
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
}