package unv.nordic.bot;

import java.util.List;
import java.util.Set;

public interface Button {
    /// language
    String UZ = "\uD83C\uDDFA\uD83C\uDDFF O'zbekcha";
    String RU = "\uD83C\uDDF2\uD83C\uDDFE Русский";
    List<String> chooseLang = List.of(UZ, RU);

    /// menu uz
    String INFO_UNIVERSITY_UZ = "ℹ️ Universitet haqida";
    String DIRECTION_UZ = "\uD83D\uDCDA Yo‘nalishlar";
    String WORK_AND_TRAVEL_UZ = "✈️ Work and Travel";
    String CONTACT_OPERATOR_UZ = "\uD83D\uDCDE Operator bilan bog‘lanish";
    String OUR_SUCCESSES_UZ = "\uD83C\uDFC6 Yutuqlarimiz";
    String CHOOSE_LANGUAGE_UZ = "\uD83C\uDDFA\uD83C\uDDFF Tilni o'zgartirish";
    List<String> MENU_UZ = List.of(INFO_UNIVERSITY_UZ, DIRECTION_UZ, WORK_AND_TRAVEL_UZ, CONTACT_OPERATOR_UZ, OUR_SUCCESSES_UZ, CHOOSE_LANGUAGE_UZ);

    /// menu ru
    String INFO_UNIVERSITY_RU = "ℹ️ Информация о университете";
    String DIRECTION_RU = "\uD83D\uDCDA Направления";
    String WORK_AND_TRAVEL_RU = "✈️ Работа и путешествия";
    String CONTACT_OPERATOR_RU = "\uD83D\uDCDE Связаться с оператором";
    String OUR_SUCCESSES_RU = "\uD83C\uDFC6 Наши успехи";
    String CHOOSE_LANGUAGE_RU = "\uD83C\uDDF2\uD83C\uDDFE Изменить язык";
    List<String> MENU_RU = List.of(INFO_UNIVERSITY_RU, DIRECTION_RU, WORK_AND_TRAVEL_RU, CONTACT_OPERATOR_RU, OUR_SUCCESSES_RU, CHOOSE_LANGUAGE_RU);

    /// menu set
}
