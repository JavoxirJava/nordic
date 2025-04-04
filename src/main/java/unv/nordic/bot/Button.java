package unv.nordic.bot;

import unv.nordic.payload.Link;

import java.util.List;

public interface Button {
    /// Language
    String UZ = "\uD83C\uDDFA\uD83C\uDDFF O'zbekcha";
    String RU = "\uD83C\uDDF7\uD83C\uDDFA Русский";
    List<String> chooseLang = List.of(UZ, RU);

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
    String CHOOSE_LANGUAGE_RU = "\uD83C\uDDF2\uD83C\uDDFE Изменить язык";
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

    /// Masters uz
    String TAM_B_UZ = "📚 Ta'lim va tarbiya nazariyasi va metodikasi (Boshlang'ich ta'lim)";
    String TAM_M_UZ = "📚 Ta'lim va tarbiya nazariyasi va metodikasi (Maktabgacha uchun)";
    String MEA_UZ = "📚 Musiqa ta'limi va san'at";
    String CE_UZ = "📚 Kompyuter injiniringi";
    String DC_UZ = "📚 Maʼlumotlar ilmi";
    String TAH_UZ = "📚 Turizm va mehmondoʻstlik";
    String FLA_L_UZ = "📚 Xorijiy til va adabiyoti";
    String PEDAGOGY_UZ = "📚 Pedagogika";
    String JOURNALISM_UZ = "📚 Jurnalistika";
    String ECONOMICS_UZ = "📚 Iqtisodiyot";
    String WORLD_ECONOMY_UZ = "📚 Jahon iqtisodiyoti";
    String PSYCHOLOGY_UZ = "📚 Psixologiya";
    List<String> MASTERS_DIRECTIONS_UZ = List.of(TAM_B_UZ, TAM_M_UZ, MEA_UZ, CE_UZ, DC_UZ, TAH_UZ, FLA_L_UZ, PEDAGOGY_UZ, JOURNALISM_UZ, ECONOMICS_UZ, WORLD_ECONOMY_UZ, PSYCHOLOGY_UZ, BACK_UZ);


    /// Masters ru
    String TAM_B_RU = "📚 Теория и методика обучения и воспитания (Начальное образование)";
    String TAM_M_RU = "📚 Теория и методика обучения и воспитания (для дошкольников)";
    String MEA_RU = "📚 Музыкальное образование и искусство";
    String CE_RU = "📚 Компьютерная инженерия";
    String DC_RU = "📚 Наука о данных";
    String TAH_RU = "📚 Туризм и гостеприимство";
    String FLA_L_RU = "📚 Иностранный язык и литература";
    String PEDAGOGY_RU = "📚 Педагогика";
    String JOURNALISM_RU = "📚 Журналистика";
    String ECONOMICS_RU = "📚 Экономика";
    String WORLD_ECONOMY_RU = "📚 Мировая экономика";
    String PSYCHOLOGY_RU = "📚 Психология";
    List<String> MASTERS_DIRECTIONS_RU = List.of(TAM_B_RU, TAM_M_RU, MEA_RU, CE_RU, DC_RU, TAH_RU, FLA_L_RU, PEDAGOGY_RU, JOURNALISM_RU, ECONOMICS_RU, WORLD_ECONOMY_RU, PSYCHOLOGY_RU, BACK_RU);
}