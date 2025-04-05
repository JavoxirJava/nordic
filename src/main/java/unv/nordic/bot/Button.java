package unv.nordic.bot;

import unv.nordic.payload.Link;

import java.util.List;

public interface Button {
    /// Language
    String UZ = "\uD83C\uDDFA\uD83C\uDDFF O'zbekcha";
    String RU = "\uD83C\uDDF7\uD83C\uDDFA Русский";
    List<String> chooseLang = List.of(UZ, RU);

    /// Admin menu
    String SEND_MESSAGE = "\uD83D\uDCE8 Send message";
    String GET_USER_COUNT = "\uD83D\uDC65 Get user count";
    String GET_USERS_TABLE = "\uD83D\uDC65 Get users table \uD83D\uDDD2";
    List<String> ADMIN_MENU = List.of(SEND_MESSAGE, GET_USER_COUNT, GET_USERS_TABLE);

    /// Menu uz
    String INFO_UNIVERSITY_UZ = "ℹ️ Universitet haqida";
    String DIRECTION_UZ = "\uD83D\uDCDA Yo‘nalishlar";
    String WORK_AND_TRAVEL_UZ = "✈️ Work and Travel";
    String OFFICE_UZ = "\uD83D\uDCCD Ofisga kelish";
    String CONTACT_OPERATOR_UZ = "\uD83D\uDCDE Operator bilan bog‘lanish";
    String OUR_SUCCESSES_UZ = "\uD83C\uDFC6 Yutuqlarimiz";
    String CHOOSE_LANGUAGE_UZ = "\uD83C\uDDFA\uD83C\uDDFF Tilni o'zgartirish";
    List<String> MENU_UZ = List.of(INFO_UNIVERSITY_UZ, DIRECTION_UZ, WORK_AND_TRAVEL_UZ, OFFICE_UZ, CONTACT_OPERATOR_UZ, OUR_SUCCESSES_UZ, CHOOSE_LANGUAGE_UZ);

    /// Menu ru
    String INFO_UNIVERSITY_RU = "ℹ️ Информация о университете";
    String DIRECTION_RU = "\uD83D\uDCDA Направления";
    String WORK_AND_TRAVEL_RU = "✈️ Работа и путешествия";
    String OFFICE_RU = "\uD83D\uDCCD Вход в офис";
    String CONTACT_OPERATOR_RU = "\uD83D\uDCDE Связаться с оператором";
    String OUR_SUCCESSES_RU = "\uD83C\uDFC6 Наши успехи";
    String CHOOSE_LANGUAGE_RU = "\uD83C\uDDF7\uD83C\uDDFA Изменить язык";
    List<String> MENU_RU = List.of(INFO_UNIVERSITY_RU, DIRECTION_RU, WORK_AND_TRAVEL_RU, OFFICE_RU, CONTACT_OPERATOR_RU, OUR_SUCCESSES_RU, CHOOSE_LANGUAGE_RU);

    /// Messengers
    Link TELEGRAM = Link.builder().name("\uD83D\uDCE9 Telegram").url("https://t.me/nordic_edu").build();
    Link YOUTUBE = Link.builder().name("\uD83D\uDCF9 YouTube").url("https://www.youtube.com/@nordic_university").build();
    Link INSTAGRAM = Link.builder().name("\uD83D\uDCF8 Instagram").url("https://www.instagram.com/nordic_edu/").build();
    Link WEB_SITE = Link.builder().name("Veb-site / Веб-сайт").url("https://nordicuniversity.org/").build();
    Link FACE_BOOK = Link.builder().name("\uD83D\uDCD8 Facebook").url("https://www.facebook.com/nordicuniversity.edu/?ref=pages_you_manage").build();
    Link TWITTER = Link.builder().name("\uD83D\uDC26 Twitter").url("https://x.com/nordic_edu").build();
    Link LINKEDIN = Link.builder().name("\uD83D\uDCBC LinkedIn").url("https://www.linkedin.com/company/nordic-international-university/?viewAsMembeL=true").build();
    List<Link> MESSENGERS = List.of(TELEGRAM, YOUTUBE, INSTAGRAM, WEB_SITE, FACE_BOOK, TWITTER, LINKEDIN);

    /// Video
    Link YOUTUBE_LINK = Link.builder().name("\uD83D\uDCF9 Video ko'rish").url("https://www.youtube.com/watch?v=zvjfcI73Tw0").build();
    List<Link> YOUTUBE_VIDEO = List.of(YOUTUBE_LINK);

    /// Location
    Link OFFICE_LOCATION_ONE = Link.builder().name("\uD83C\uDFE2 1-filial / 1-филиал").url("https://maps.app.goo.gl/NNS7p6t789Tv24Ng7").build();
    Link OFFICE_LOCATION_TWO = Link.builder().name("\uD83C\uDFE2 2-filial / 2-филиал").url("https://maps.app.goo.gl/ehYzuURmf9kF1qbp9").build();
    List<Link> OFFICE_LOCATION = List.of(OFFICE_LOCATION_ONE, OFFICE_LOCATION_TWO);

    /// Directions uz
    String BACHELORS_UZ = "\uD83C\uDF93 Bakalavr";
    String MASTERS_UZ = "\uD83C\uDF93 Magistratura";
    String BACK_UZ = "\uD83D\uDD19 Orqaga";
    List<String> DIRECTIONS_UZ = List.of(BACHELORS_UZ, MASTERS_UZ, BACK_UZ);

    /// Directions ru
    String BACHELORS_RU = "\uD83C\uDF93 Холостяк";
    String MASTERS_RU = "\uD83C\uDF93 Степень магистра";
    String BACK_RU = "\uD83D\uDD19 Назад";
    List<String> DIRECTIONS_RU = List.of(BACHELORS_RU, MASTERS_RU, BACK_RU);

    /// Directions 2 uz
    String DAY_TIME_UZ = "⏰ Kunduzgi";
    String SURFACE_UZ = "\uD83D\uDCC5 Sirtqi";
    String SPECIAL_CORRESPONDENCE_UZ = "\uD83D\uDCC6 Maxsus sirtqi";
    List<String> DIRECTIONS_2_UZ = List.of(DAY_TIME_UZ, SURFACE_UZ, SPECIAL_CORRESPONDENCE_UZ, BACK_UZ);

    /// Directions 2 ru
    String DAY_TIME_RU = " Дневное время";
    String SURFACE_RU = "\uD83D\uDCC5 Поверхность";
    String SPECIAL_CORRESPONDENCE_RU = "\uD83D\uDCC6 Специальная переписка";
    List<String> DIRECTIONS_2_RU = List.of(DAY_TIME_RU, SURFACE_RU, SPECIAL_CORRESPONDENCE_RU, BACK_RU);

    /// Our successes uz
    String SCHOLARSHIP_RECIPIENTS_UZ = "\uD83C\uDFAF Grant sohiblari";
    String OUR_ARCHIVEMENTS_UZ = "\uD83C\uDFC5 Yutuqlarimiz";
    String MORE_DETAILS_UZ = "ℹ️ Batafsil";
    List<String> OUR_SUCCESSES_UZ_BUTTONS = List.of(SCHOLARSHIP_RECIPIENTS_UZ, OUR_ARCHIVEMENTS_UZ, MORE_DETAILS_UZ, BACK_UZ);

    /// Our successes ru
    String SCHOLARSHIP_RECIPIENTS_RU = "\uD83C\uDFAF Получатели стипендии";
    String OUR_ARCHIVEMENTS_RU = "\uD83C\uDFC5 Награды";
    String MORE_DETAILS_RU = "ℹ️ Подробнее";
    List<String> OUR_SUCCESSES_RU_BUTTONS = List.of(SCHOLARSHIP_RECIPIENTS_RU, OUR_ARCHIVEMENTS_RU, MORE_DETAILS_RU, BACK_RU);

    /// Grant recipients uz
    String KOREA_UZ = "\uD83C\uDDF0\uD83C\uDDF7 Koreya";
    String ITALY_UZ = "\uD83C\uDDEE\uD83C\uDDF9 Italiya";
    String UZ_REPORT_UZ = "\uD83C\uDDFA\uD83C\uDDFF Uz Report";
    String POLAND_UZ = "\uD83C\uDDF5\uD83C\uDDF1 Polsha";
    String AMERICA_UZ = "\uD83C\uDDFA\uD83C\uDDF8 Amerika";
    List<String> GRANT_RECIPIENTS_UZ = List.of(KOREA_UZ, ITALY_UZ, UZ_REPORT_UZ, POLAND_UZ, AMERICA_UZ, BACK_UZ);

    /// Grant recipients ru
    String KOREA_RU = "\uD83C\uDDF0\uD83C\uDDF7 Корея";
    String ITALY_RU = "\uD83C\uDDEE\uD83C\uDDF9 Италия";
    String UZ_REPORT_RU = "\uD83C\uDDFA\uD83C\uDDFF Уз отчет";
    String POLAND_RU = "\uD83C\uDDF5\uD83C\uDDF1 Польша";
    String AMERICA_RU = "\uD83C\uDDFA\uD83C\uDDF8 Америка";
    List<String> GRANT_RECIPIENTS_RU = List.of(KOREA_RU, ITALY_RU, UZ_REPORT_RU, POLAND_RU, AMERICA_RU, BACK_RU);

    /// Grant recipients image names
    String KOREA_IMAGE_NAME = "KOREA.jpg";
    String UZ_REPORT_IMAGE_NAME = "UZ_REPORT.jpg";
    String UZ_REPORT_IMAGE_NAME_2 = "UZ_REPORT_2.jpg";

    /// Scholarship recipients uz
    List<Link> SCHOLARSHIP_RECIPIENTS_UZ_LINKS = List.of(TELEGRAM, INSTAGRAM);
}