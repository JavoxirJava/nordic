package unv.nordic.bot;

public interface Text {
    String chooseLang = """
            🇺🇿 Assalomu alaykum! Tilni tanlang:
            🇷🇺 Здравствуйте! Выберите язык:
            """;

    String FISH_UZ = "📝 Iltimos, F.I.O ni kiriting (masalan: Aliyev Jasur):";
    String FISH_RU = "📝 Пожалуйста, введите ФИО (например: Алиев Ясур):";

    String FAILED_FISH_UZ = "❗ Iltimos, to‘liq F.I.O ni kiriting (masalan: Aliyev Jasur)!";
    String FAILED_FISH_RU = "❗ Пожалуйста, введите полное ФИО (например: Алиев Ясур)!";

    String PHONE_UZ = "\uD83D\uDCDE Telefon raqamingizni ulashing yoki kiriting (masalan: +998901234567):";
    String PHONE_RU = "\uD83D\uDCDE Введите ваш номер телефона (например: +998901234567):";

    String FAILED_PHONE_UZ = "❗ Iltimos, to‘liq telefon raqamingizni kiriting (masalan: +998901234567)!";
    String FAILED_PHONE_RU = "❗ Пожалуйста, введите полный номер телефона (например: +998901234567)!";

    String REGISTERED_PHONE_UZ = "❗ Bu telefon raqami allaqachon roʻyxatdan oʻtgan.";
    String REGISTERED_PHONE_RU = "❗ Этот номер телефона уже зарегистрирован.";

    String MENU_UZ = "\uD83D\uDDD2 Bosh menu";
    String MENU_RU = "\uD83D\uDDD2 Главное меню";

    String REGISTER_UZ = """
            ✅ Tabriklaymiz, Hurmatli foydalanuvchi! Siz muvaffaqiyatli ro‘yxatdan o‘tdingiz.
            📚 Asosiy bo‘limlar:
            """;
    String REGISTER_RU = """
            ✅ Спасибо, уважаемый пользователь! Вы успешно зарегистрировались.
            📚 Главные разделы:
            """;

    String INFO_UNIVERSITY_UZ = """
            🎓 Nordik Universiteti – Sizning Kelajagingiz 🌍
            
            ✅ Universitet ustunliklari:
            
            📜 Xalqaro darajali diplom
            🎓 Bitiruvchilarimiz O‘zbekiston va Yevropada tan olinadigan xalqaro diplomga ega bo‘lishadi.
            
            🎯 Grant imkoniyatlari
            💰 Universitet 100% va 50% grantlar taqdim etadi.
            
            🌏 Double Degree (Ikki diplomli ta’lim)
            📚 Finlandiyaning Kareliya amaliy fanlar universiteti bilan double va joint degree dasturlarida o‘qish imkoniyati mavjud.
            
            👨‍🏫 Malakali ustozlar
            🏅 Talabalarimiz uchun mahalliy va Yevropadan saralangan professor-o‘qituvchilar dars o‘tishadi.
            
            ✈️ Chet elda o‘quv dasturlari
            📖 Universitet Finlandiyada tashkil etilgan o‘quv dasturlarida ishtirok etish imkoniyatlarini taqdim qiladi.
            
            💼 Work & Travel
            🌍 Nordik universiteti talabalarga yoz oylarida Yevropada ishlab, kontrakt uchun pul topish imkoniyatini ham yaratib beradi.
            
            🚀 Kelajagingiz sari ilk qadamni bugun tashlang!
            """;

    String INFO_UNIVERSITY_RU = """
            🎓 Северный университет – Ваше будущее 🌍
            
            ✅ Преимущества университета:
            
            📜 Диплом международного уровня
            🎓 Наши выпускники получат международный диплом, признаваемый в Узбекистане и Европе.
            
            🎯 Возможности получения стипендии
            💰 Университет предлагает 100% и 50% гранты.
            
            🌏 Двойной диплом
            📚 Есть возможность обучения по программам двойных и совместных дипломов с Карельским университетом прикладных наук в Финляндии.
            
            👨‍🏫 Квалифицированные преподаватели
            🏅 Наших студентов обучают избранные местные и европейские профессора.
            
            ✈️ Программы обучения за рубежом
            📖 Университет предоставляет возможность участия в образовательных программах, организованных в Финляндии.
            
            💼 Работа и путешествия
            🌍 Nordic University также предоставляет студентам возможность работать в Европе в летние месяцы и зарабатывать деньги на стажировку.
            
            🚀 Сделайте первый шаг к своему будущему уже сегодня!
            """;

    String WORK_AND_TRAVEL_UZ = """
            ✈️ "Work and Travel": Xalqaro Nordik universitetida ish va sayohat dasturi
            
            📌 "Work and Travel" – taʼtilda mehnat va yangi manzillarga sayohatni uyg‘unlashtirish imkoniyati!
            
            Dastur:
            ✅ Taʼtilda hamkor mamlakatlarda ishlash
            📚 Finlandiya kabi rivojlangan davlatlarda havfsiz daromad va yangi madaniyatlar bilan tanishish
            ✅ Kasbiy ko‘nikmalarni oshirish
            💼 Ish tajribasi orttirish, xalqaro standartlarda ishlash va kasbiy mahoratni oshirish
            ✅ Yangi yurtlarni kashf qilish
            🌍 Yevropaning turli burchaklarini o‘rganish va yangi qadriyatlar bilan tanishish
            ✅ Shaxsiy va kasbiy rivojlanish
            🧠 Dunyoqarashni kengaytirish, mustaqillik va xalqaro tajribaga ega bo‘lish uchun ajoyib imkoniyat
            
            🚀 Biz sizga o‘quv va ish tajribalarini boyitishda yordam berishga tayyormiz!
            """;

    String WORK_AND_TRAVEL_RU = """
            ✈️ «Work and Travel»: программа Work and Travel в Международном Северном университете
            
            📌 «Work and Travel» — возможность совмещать работу и путешествия по новым направлениям во время отпуска!
            
            Программа:
            ✅ Работа в странах-партнерах во время отпуска
            📚 Надежный доход и знакомство с новыми культурами в развитых странах, таких как Финляндия
            ✅ Улучшить профессиональные навыки
            💼 Получайте опыт работы, работайте по международным стандартам и повышайте профессиональные навыки
            ✅ Открытие новых земель
            🌍 Исследование разных уголков Европы и знакомство с новыми ценностями
            ✅ Личностное и профессиональное развитие
            🧠 Прекрасная возможность расширить свой кругозор, обрести независимость и получить международный опыт
            
            🚀 Мы готовы помочь вам обогатить ваш опыт обучения и работы!
            """;

    String OFFICE_UZ = """
            📍 Toshkent shahridagi o‘quv binolarimiz
            
            Hurmatli abituriyent, Xalqaro Nordik universiteti Toshkent shahrida ikkita o‘quv binoda joylashgan. O‘zingizga qulay kampusimizni tanlang:
            
            🏢 1-filial: Toshkent sh., Chilanzar tumani, Bunyodkor shoh ko‘chasi 8/2
            🏢 2-filial: Toshkent sh., Shayhontohur tumani, Sebzor ko‘chasi, 22 A
            
            ✅ O‘zingizga mos keladigan binoni tanlang va batafsil ma’lumotga ega bo‘ling!
            """;

    String OFFICE_RU = """
            📍 Наши учебные корпуса в Ташкенте
            
            Уважаемый абитуриент, Международный Северный университет располагается в двух учебных корпусах в Ташкенте. Выберите удобный для вас кампус:
            
            🏢 Филиал 1: г. Ташкент, Чиланзарский район, проспект Бунёдкор 8/2
            🏢 Филиал 2: г. Ташкент, Шайхонтохурский район, улица Себзора, 22 А
            
            ✅ Выберите подходящее вам здание и получите подробную информацию!
            """;

    String CONTACT_OPERATOR_UZ = """
            📞 Operator bilan bog‘lanish
            
            Agar sizga qo‘shimcha ma’lumot kerak bo‘lsa yoki savollaringiz bo‘lsa, quyidagi raqam orqali bizning operatorimiz bilan bog‘lanishingiz mumkin:
            
            +998 55 508 44 00
            
            Ish vaqti: Dushanba - Shanba, 09:00 - 18:00
            
            Sizning barcha savollaringizga javob berishdan mamnunmiz!
            """;

    String CONTACT_OPERATOR_RU = """
            📞 Связаться с оператором
            
            Если у вас есть дополнительные вопросы или вопросы, вы можете связаться с нашим оператором по номеру:
            
            +998 55 508 44 00
            
            Режим работы: Понедельник - Пятница, 09:00 - 18:00
            
            Мы рады, что вы сможете получить ответ на свои вопросы!
            """;

    String DIRECTION_UZ = "\uD83D\uDCDA Tanlang:";
    String DIRECTION_RU = "\uD83D\uDCDA Выберите:";

    String OUR_SUCCESSES_UZ = "\uD83C\uDFC6 Yutuqlarimiz:";
    String OUR_SUCCESSES_RU = "\uD83C\uDFC6 Наши успехи:";

    String MASTERS_UZ = "📚 Magistratura yo‘nalishlari:";
    String MASTERS_RU = "📚 Программы магистратуры:";

    String DAY_TIME_UZ = "\uD83D\uDCDA Kunduzgi ta’lim yo‘nalishlari:";
    String DAY_TIME_RU = "\uD83D\uDCDA Программы дневного обучения:";

    String SURFACE_UZ = "\uD83D\uDCDA Sirtqi ta’lim yo‘nalishlari:";
    String SURFACE_RU = "\uD83D\uDCDA Направления дистанционного обучения:";

    String SPECIAL_CORRESPONDENCE_UZ = "\uD83D\uDCDA Maxsus sirtqi ta’lim yo‘nalishlari:";
    String SPECIAL_CORRESPONDENCE_RU = "\uD83D\uDCDA Специальные направления заочного обучения:";

    String SCHOLARSHIP_RECIPIENTS_UZ = """
            🎯 Grant sohiblari 🎉
            
            ⚡️ Italiyaning nufuzli Trento universiteti grant sohibi! 🌟
            Nordik universitetining Jahon iqtisodiyoti magistratura mutaxassisligi talabasi Javlon Ne'matov Trento universitetida grant asosida o‘qish imkoniyatiga ega bo‘ldi! 🌍
            📊 THE dunyo top reytingida 350-o‘rin, QS dunyo universitetlari reytingida 457-o‘rinda turuvchi Trento universiteti granti - faqat Nordik universiteti talabalari uchun! 🏆
            ✅ Talabalarimiz safimizga qo‘shiling va o‘zingiz uchun xalqaro imkoniyatlarga yo‘l oching! 🚀
            
            ⚡️ Italiyaning nufuzli Trento universiteti grant sohibasi! 🌟
            Nordik universitetining Jahon iqtisodiyoti va xalqaro iqtisodiy munosabatlar bakalavriat yo‘nalishi talabasi Karina Rahmatova Trento universitetida grant asosida o‘qish imkoniyatiga ega bo‘ldi! 🎓
            📊 THE dunyo top reytingida 350-o‘rin, QS dunyo reytingida 457-o‘rinda turuvchi Trento universiteti granti - faqat Nordik universiteti talabalari uchun! 🌏
            ✅ Safimizga qo‘shiling va xalqaro almashinuv dasturlarimizdan foydalaning! 🌐
            
            🇺🇿🇮🇹 Talabamiz Italiyaning nufuzli universitetida grant asosida o‘qish imkoniyatini qo‘lga kiritdi! 🎊
            Xorijiy til va adabiyoti: ingliz tili yo‘nalishi talabasi Abduqodir Jo‘rayev Partenope universitetida ta'lim olishga kirishmoqda. 📚
            """;

    String SCHOLARSHIP_RECIPIENTS_RU = """
            🎯 Получатели стипендии 🎉
            
            ⚡️ Получатель гранта престижного Университета Тренто в Италии! 🌟
            Джавлон Нематов, магистрант факультета мировой экономики Северного университета, получил стипендию на обучение в Университете Тренто! 🌍
            📊 Грант от Университета Тренто, занимающего 350-е место в мировом рейтинге THE и 457-е место в мировом рейтинге университетов QS, — только для студентов из этого скандинавского университета! 🏆
            ✅ Присоединяйтесь к нашим студентам и откройте для себя двери в мир международных возможностей! 🚀
            
            ⚡️ Стипендиат престижного Университета Тренто в Италии! 🌟
            Карина Рахматова, студентка бакалавриата по направлению «Мировая экономика и международные экономические отношения» Северного университета, получила стипендию на обучение в Университете Тренто! 🎓
            📊 Грант от Университета Тренто, занимающего 350-е место в мировом рейтинге THE и 457-е место в мировом рейтинге QS, — эксклюзивно для студентов из скандинавских университетов! 🌏
            ✅ Присоединяйтесь к нам и воспользуйтесь нашими программами международного обмена! 🌐
            
            🇺🇿🇮🇹 Наш студент выиграл возможность учиться в престижном университете Италии по стипендии! 🎊
            Иностранный язык и литература: студент английского языка Абдукадыр Джораев начинает обучение в Университете Партенопа. 📚
            """;

    String OUR_ARCHIVEMENTS_UZ = """
            🏅 Yutuqlarimiz 🏆
            
            😀 Nordikda xushxabarlar seriyasi davom etmoqda! 🎉
            Xorijiy til yo‘nalishi talabasi Nozima Shavkatova Koreya hukumatining eng nufuzli stipendiyalaridan biri (GKS) ni qo‘lga kiritdi. 🌟
            Endilikda talabamiz o'quv yilining II-semestrini universitetimizning hamkor universitetlaridan birida - Degu universitetida bepul tahsil oladi. 📚
            🌏 Mazkur stipendiya orqali talabamiz o'zi uchun umuman boshqa mamlakatning madaniyatini kashf qilish hamda nufuzli oliygohning zamonaviy o'quv dasturi orqali tahsil oladi! 🚀
            """;

    String OUR_ARCHIVEMENTS_RU = """
            🏅 Наши достижения 🏆
            
            😀 Серия хороших новостей продолжается в Скандинавии! 🎉
            Студентка, изучающая иностранный язык, Нозима Шавкатова выиграла одну из самых престижных стипендий (GKS) от правительства Кореи. 🌟
            Теперь наш студент будет бесплатно обучаться второй семестр учебного года в одном из вузов-партнеров нашего университета - Университете Тэгу. 📚
            🌏 Благодаря этой стипендии наш студент откроет для себя культуру совершенно другой страны и будет обучаться по современной программе в престижном университете! 🚀
            """;
    String MORE_DETAILS_UZ = """
            ℹ️ Nordik - Ta'limda mukammallik sari 🌟
            
            Bizning maqsadimiz - talabalarga xalqaro darajadagi ta’lim va imkoniyatlar taqdim etish! 🚀
            """;

    String MORE_DETAILS_RU = """
            ℹ️ Nordic - На пути к совершенству в образовании 🌟
            
            Наша цель — предоставить студентам образование и возможности мирового класса! 🚀
            """;
}
