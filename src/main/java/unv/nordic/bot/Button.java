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

    /// Bachelors day time directions uz
    String WEA_IER_UZ = "\uD83D\uDCDA Jahon iqtisodiyoti va xalqaro iqtisodiy munosabatlar";
    String HISTORY_UZ = "\uD83D\uDCDA Tarix";
    String FLA_L_UZ = "📚 Xorijiy til va adabiyoti";
    String PE_UZ = "\uD83D\uDCDA Boshlang‘ich ta‘lim";
    String PRESCHOOL_EDUCATION = "\uD83D\uDCDA Maktabgacha ta‘lim";
    String PSYCHOLOGY_UZ = "📚 Psixologiya";
    String SPECIAL_PEDAGOGY_UZ = "\uD83D\uDCDA Maxsus pedagogika";
    String ECONOMICS_UZ = "📚 Iqtisodiyot";
    String F_AFT_UZ = "\uD83D\uDCDA Moliya va moliyaviy texnologiyalar";
    String BUSINESS_MANAGEMENT_UZ = "\uD83D\uDCDA Biznesni boshqarish";
    String IE_AM_UZ = "\uD83D\uDCDA Sanoat muhandisligi va menejmenti";
    String CE_UZ = "📚 Kompyuter injiniringi";
    String MUSIC_EDUCATION_UZ = "\uD83D\uDCDA Musiqa ta'limi";
    String TAH_UZ = "📚 Turizm va mehmondoʻstlik";
    String JOURNALISM_UZ = "📚 Jurnalistika";
    String APPLIED_MATHEMATICS_UZ = "\uD83D\uDCDA Amaliy matematika";
    List<String> BACHELORS_DAY_TIME_DIRECTIONS_UZ = List.of(WEA_IER_UZ, HISTORY_UZ, FLA_L_UZ, PE_UZ, PRESCHOOL_EDUCATION,
            PSYCHOLOGY_UZ, SPECIAL_PEDAGOGY_UZ, ECONOMICS_UZ, F_AFT_UZ, BUSINESS_MANAGEMENT_UZ, IE_AM_UZ, CE_UZ,
            MUSIC_EDUCATION_UZ, TAH_UZ, JOURNALISM_UZ, APPLIED_MATHEMATICS_UZ, BACK_UZ);

    /// Bachelors day time directions ru
    String WEA_IER_RU = "\uD83D\uDCDA Мировая экономика и международные экономические отношения";
    String HISTORY_RU = "\uD83D\uDCDA История";
    String FLA_L_RU = "📚 Иностранный язык и литература";
    String PE_RU = "\uD83D\uDCDA Начальное образование";
    String PRESCHOOL_EDUCATION_RU = "\uD83D\uDCDA Дошкольное образование";
    String PSYCHOLOGY_RU = "📚 Психология";
    String SPECIAL_PEDAGOGY_RU = "\uD83D\uDCDA Специальная педагогика";
    String ECONOMICS_RU = "📚 Экономика";
    String F_AFT_RU = "\uD83D\uDCDA Финансы и финансовые технологии";
    String BUSINESS_MANAGEMENT_RU = "\uD83D\uDCDA Управление бизнесом";
    String IE_AM_RU = "\uD83D\uDCDA Промышленная инженерия и менеджмент";
    String CE_RU = "📚 Компьютерная инженерия";
    String MUSIC_EDUCATION_RU = "\uD83D\uDCDA Музыкальное образование";
    String TAH_RU = "📚 Туризм и гостеприимство";
    String JOURNALISM_RU = "📚 Журналистика";
    String APPLIED_MATHEMATICS_RU = "\uD83D\uDCDA Прикладная математика";
    List<String> BACHELORS_DAY_TIME_DIRECTIONS_RU = List.of(WEA_IER_RU, HISTORY_RU, FLA_L_RU, PE_RU, PRESCHOOL_EDUCATION_RU,
            PSYCHOLOGY_RU, SPECIAL_PEDAGOGY_RU, ECONOMICS_RU, F_AFT_RU, BUSINESS_MANAGEMENT_RU, IE_AM_RU, CE_RU,
            MUSIC_EDUCATION_RU, TAH_RU, JOURNALISM_RU, APPLIED_MATHEMATICS_RU, BACK_RU);

    /// Bachelors surface directions uz
    List<String> BACHELORS_SURFACE_DIRECTIONS_UZ = List.of(JOURNALISM_UZ, HISTORY_UZ, CE_UZ, ECONOMICS_UZ, F_AFT_UZ,
            PSYCHOLOGY_UZ, JOURNALISM_UZ, BACK_UZ);

    /// Bachelors surface directions ru
    List<String> BACHELORS_SURFACE_DIRECTIONS_RU = List.of(JOURNALISM_RU, HISTORY_RU, CE_RU, ECONOMICS_RU, F_AFT_RU,
            PSYCHOLOGY_RU, JOURNALISM_RU, BACK_RU);

    /// Bachelors Special correspondence directions uz
    String MEA_UZ = "📚 Musiqa ta'limi va san'at";
    List<String> BACHELORS_SPECIAL_CORRESPONDENCE_DIRECTIONS_UZ = List.of(PE_UZ, PRESCHOOL_EDUCATION, MEA_UZ, BACK_UZ);

    /// Bachelors Special correspondence directions ru
    String MEA_RU = "📚 Музыкальное образование и искусство";
    List<String> BACHELORS_SPECIAL_CORRESPONDENCE_DIRECTIONS_RU = List.of(PE_RU, PRESCHOOL_EDUCATION_RU, MEA_RU, BACK_RU);

    /// Masters uz
    String TAM_B_UZ = "📚 Ta'lim va tarbiya nazariyasi va metodikasi (Boshlang'ich ta'lim)";
    String TAM_M_UZ = "📚 Ta'lim va tarbiya nazariyasi va metodikasi (Maktabgacha uchun)";
    String DC_UZ = "📚 Maʼlumotlar ilmi";
    String PEDAGOGY_UZ = "📚 Pedagogika";
    String WORLD_ECONOMY_UZ = "📚 Jahon iqtisodiyoti";
    List<String> MASTERS_DIRECTIONS_UZ = List.of(TAM_B_UZ, TAM_M_UZ, MEA_UZ, CE_UZ, DC_UZ, TAH_UZ, FLA_L_UZ,
            PEDAGOGY_UZ, JOURNALISM_UZ, ECONOMICS_UZ, WORLD_ECONOMY_UZ, PSYCHOLOGY_UZ, BACK_UZ);

    /// Masters ru
    String TAM_B_RU = "📚 Теория и методика обучения и воспитания (Начальное образование)";
    String TAM_M_RU = "📚 Теория и методика обучения и воспитания (для дошкольников)";
    String DC_RU = "📚 Наука о данных";
    String PEDAGOGY_RU = "📚 Педагогика";
    String WORLD_ECONOMY_RU = "📚 Мировая экономика";
    List<String> MASTERS_DIRECTIONS_RU = List.of(TAM_B_RU, TAM_M_RU, MEA_RU, CE_RU, DC_RU, TAH_RU, FLA_L_RU,
            PEDAGOGY_RU, JOURNALISM_RU, ECONOMICS_RU, WORLD_ECONOMY_RU, PSYCHOLOGY_RU, BACK_RU);

    /// Our successes uz
    String SCHOLARSHIP_RECIPIENTS_UZ = "\uD83C\uDFAF Grant sohiblari";
    String OUR_ARCHIVEMENTS_UZ = "\uD83C\uDFC5 Yutuqlarimiz";
    String MORE_DETAILS_UZ = "ℹ️ Batafsil";
    List<String> OUR_SUCCESSES_UZ_BUTTONS = List.of(SCHOLARSHIP_RECIPIENTS_UZ, OUR_ARCHIVEMENTS_UZ, MORE_DETAILS_UZ, BACK_UZ);

    /// Our successes ru
    String SCHOLARSHIP_RECIPIENTS_RU = "\uD83C\uDFAF Получатели грантов";
    String OUR_ARCHIVEMENTS_RU = "\uD83C\uDFC5 Наши достижения";
    String MORE_DETAILS_RU = "ℹ️ Подробнее";
    List<String> OUR_SUCCESSES_RU_BUTTONS = List.of(SCHOLARSHIP_RECIPIENTS_RU, OUR_ARCHIVEMENTS_RU, MORE_DETAILS_RU, BACK_RU);

    /// Scholarship recipients uz
    List<Link> SCHOLARSHIP_RECIPIENTS_UZ_LINKS = List.of(TELEGRAM, INSTAGRAM);
}