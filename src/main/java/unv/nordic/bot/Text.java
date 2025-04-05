package unv.nordic.bot;

public interface Text {
    String BOOK = "📚 ";
    int BOOK_INDEX = 3;

    int DAY_TIME = 1;
    int SURFACE = 2;
    int SPECIAL_CORRESPONDENCE = 3;

    /// admin
    String ADMIN_TEXT = "Kerakli menuni tanlang:";
    String ADMIN_SEND_MESSAGE = "Habarni kiriting:";
    String ADMIN_USER_COUNT = "Foydalanuvchilar soni: ";
    String ADMIN_GET_USERS_TABLE = "⏳ Bir oz ko'ting foydalanuvchilar ro'yxati tayyorlanmoqda...";
    String ADMIN_SUCCESS_SEND_MESSAGE = "Habarni muvaffaqiyatli yuborildi!";

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

    String DEFAULT_UZ = "Bu buyruq hozirda mavjud emas \uD83E\uDD37\uD83C\uDFFB\u200D♂️ /start buyrug'idan foydalaning.";
    String DEFAULT_RU = "Эта команда в данный момент недоступна \uD83E\uDD37\uD83C\uDFFB\u200D♂️\nИспользуйте команду /start.";

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

    String DURATION_TEXT_UZ = """
            📚 %s
            
            💰 Kontrakt: %d so‘m
            ⏳ Davomiylik: %s yil
            🗣 Ta’lim tili: %s
            📌 Ta’lim kodi: %s
            
            \uD83D\uDD39 Hujjat topshirish muddati: 1-oktyabrgacha
            \uD83D\uDD39 Qabul bo‘limi bilan bog‘lanish uchun "Menejer bilan aloqa" tugmasini bosing
            \uD83D\uDCDD Hujjat topshirish
            \uD83D\uDCDE Menejer bilan aloqa: 🔹 +998555084400 | @nordikedu""";

    String DURATION_TEXT_RU = """
            📚 %s
            
            💰 Контракт: %d сум
            ⏳ Продолжительность: %d года
            🗣 Язык обучения: %s
            📌 Код обучения: %s
            
            🔹 Срок подачи документов: до 1 октября
            🔹 Для связи с приемной комиссией нажмите кнопку «Связь с менеджером»
            📝 Подача документов
            📞 Связь с менеджером: 🔹 +998555084400 | @nordikedu""";

    String KOREA_UZ = """
            #xushxabar
            #GKS_scholarship
            
            🇺🇿🇰🇷 Nozima nufuzli stipendiya sohibasi!
            
            ⚡️Nordikda xushxabarlar seriyasi davom etmoqda!\s
            
            Xorijiy til yo‘nalishi talabasi Nozima Shavkatova Koreya hukumatining eng nufuzli stipendiyalaridan biri (GKS)ni qo‘lga kiritdi.
            
            [📌 Batafsil](https://nordicuniversity.org/uz/press-service/news/nozima-nufuzli-stipendiya-sohibi)
            """;

    String ITALY_UZ = """
            🇺🇿🇮🇹Talabamiz Italiyaning nufuzli universitetida grant asosida o‘qish imkoniyatini qo‘lga kiritdi
            
            Xorijiy til va adabiyoti: ingliz tili yo‘nalishi talabasi Abduqodir Jo‘rayev Partenope (Universita' Degli Studi Di Napoli "Parthenope" - Italiya) universitetida ta'lim olishga kirishmoqda.\s
            
            > Ma'lumot o‘rnida, "Partenope" universiteti 1919-yilda Italiyaning Neapol shahrida tashkil topgan. 15 ming nafarga yaqin talabalarga xalqaro baholanuvchi bilim, muloqot va tanqidiy fikrlash qobiliyatlarini rivojlantirishga qaratilgan puxta ta'lim berib kelmoqda.\s
            
            Universitet iqtisodiy, yuridik, muhandislik, texnologik sohalar, avtomobilga oid fanlar va taraqqiyotning muhim sohalarida oliy ta'lim va tadqiqot markazlariga aylangan.
            
            [⏺XNU rasmiy kanali](https://t.me/nordic_edu)
            """;

    String ITALY_2_UZ = """
            ⚡️Italiyaning nufuzli Trento universiteti grant sohibi!\s
            
            Nordik universitetining Jahon iqtisodiyoti magistratura mutaxassisligi talabasi Javlon Ne'matov Trento universitetida grant asosida o‘qish imkoniyatiga ega bo‘ldi!\s
            
            📊 THE dunyo top reytingida 350-o‘rin,\s
                QS dunyo universitetlari reytingida 457-o‘rinda turuvchi Trento universiteti granti - faqat Nordik universiteti talabalari uchun!\s
            
            ✅ Talabalarimiz safimizga qo‘shiling va o‘zingiz uchun xalqaro imkoniyatlarga yo‘l oching!\s
            ➖➖➖➖➖
            🔔 Eslatib o‘tamiz, 12 ta magistratura mutaxassisligi va 16 ta bakalavriat yo‘nalishiga qabulimiz [davom etmoqda](https://t.me/nordic_edu/4147).
            
            ➡️ https://qabul.nordicuniversity.org/uz
            
            +998555084400/@nordic_chat_bot
            
            [⏺Nordik rasmiy kanali](https://t.me/nordic_edu)
            """;

    String ITALY_3_UZ = """
            ⚡️Italiyaning nufuzli Trento universiteti grant sohibasi!\s
            
            Nordik universitetining Jahon iqtisodiyoti va xalqaro iqtisodiy munosabatlar bakalavriat yo‘nalishi talabasi Karina Rahmatova Trento universitetida grant asosida o‘qish imkoniyatiga ega bo‘ldi!\s
            
            📊THE dunyo top reytingida 350-o‘rin,\s
                 QS dunyo reytingida 457-o‘rinda turuvchi Trento universiteti granti - faqat Nordik universiteti talabalari uchun!\s
            
            ✅ Safimizga qo‘shiling va xalqaro almashinuv dasturlarimizdan foydalaning!\s
            
            📺 https://www.youtube.com/shorts/d27NBVaFSmo
            ➖➖➖➖➖
            📌Qabulimiz davom etmoqda.
            
            ➡️ https://qabul.nordicuniversity.org/uz
            
            +998555084400/@nordic_chat_bot""";

    String UZ_REPORT_1_UZ = """
             ⚡️⚡️⚡Jurnalistika mutaxassisligi grant sohiblari bilan tanishing!\s
            
             Magistraturaga kirish imtihonlarida eng yuqori ball bilan talabalikka tavsiya etilgan 10 nafar talabgorlarga 100% lik grantlar ajratildi.\s
            
            > O‘zbekiston Respublikasi Ekologiya, atrof-muhitni muhofaza qilish va iqlim o‘zgarishi vazirligining maqsadli grantlar sohiblari:\s
            1. Ismat Do‘stmurodov
            
            2. Nizomjon Islomov
            
            3. Umarbek Esanmurodov.\s
            
            > Kirish imtihonida (100 ballik tizimdan) eng yuqori ball to‘plagan "UzReport jurnalistika, media va kommunikatsiyalar akademiyasi" grantlari sohiblari:\s
            
            1. Muhammadali Mamadaliyev - 95 ball
            
            2. Muxtasar Isaqova - 93 ball
            
            3. Gulzoda Olimjonova - 93 ball
            
            4. Anvar Samadov - 90 ball
            
            5. Avazbek Arabboyev - 90 ball
            
            6. Sayyora Qodirova - 85 ball
            
            7. Umidjon Mamarasulov - 85 ball.\s
            
            Grant sohiblarini tabriklaymiz!
            
            [⏺Nordik rasmiy kanali](https://t.me/nordic_edu)
            """;

    String UZ_REPORT_2_UZ = """
            ⚡️Grant sohiblarini tabriklaymiz!\s
            
            Jurnalistika yo‘nalishiga eng yuqori ball bilan talabalikka tavsiya etilgan 9 nafar talabgorlarga 50 % lik grantlar ajratildi.\s
            
            > "UzReport jurnalistika, media va kommunikatsiyalar akademiyasi" grantlari sohiblari bilan tanishing:
            
            1. Sarvinoz Odilova
            
            2. Gulbahor Abduhalimova
            
            3. Sanjar Quvandiqov
            
            4. Sarvinoz Rajabova
            
            5. Simoraxon Rahimjonova
            
            6. Diyora Davlotova
            
            7. Shodiyor Niyatqobilov\s
            
            8. Shahnoza Rahmatova
            
            9. Diyorbek Jo‘raboyev.\s
            
            [⏺Nordik rasmiy kanali](https://t.me/nordic_edu)
            """;

    String POLAND_UZ = """
            🇵🇱 Talabamiz Polshaga yo‘l oldi! 🛫
            
            Madinabonu Isaqova Erasmus+ KA171 ICM xalqaro dasturi grantini qo‘lga kiritdi.\s
            
            Grant asosida Polshaning WSEI universitetida bepul taʼlim olish imkoniyatiga ega bo‘ldi. Madinabonuga bilim olish va fan bilan mashg‘ul bo‘lishi uchun stipendiya ham ajratilmoqda.
            
            Omad Madinabonu!
            
            🌐 https://youtube.com/shorts/zMZWXynqmVs?si=LET3pWjx0oYV5JVu
            """;

    String AMERICA_UZ = """
            #AQSh_talabalarimiz_nigohida
            
            📹 Nordic news| AQShning Michigan shtatidagi Lawrence Technological Universitydan maxsus reportaj.
            
            📽 https://youtu.be/g0F29jsxu3k""";

    String KOREA_RU = """
            #хорошиеновости
            #стипендия_ГКС
            
            🇺🇿🇰🇷 Нозима — обладательница престижной стипендии!
            
            ⚡️Продолжается серия хороших новостей в странах Северной Европы!
            
            Студентка, изучающая иностранный язык, Нозима Шавкатова выиграла одну из самых престижных стипендий (GKS) от правительства Кореи.
            
            [📌Подробнее](https://nordicuniversity.org/uz/press-service/news/nozima-nufuzli-stipendiya-sohibi)""";

    String ITALY_RU = """
            🇺🇿🇮🇹Наш студент получил стипендию на обучение в престижном университете Италии
            
            Студент факультета иностранного языка и литературы: английского языка Абдукадыр Джораев начинает обучение в Университете Партенопе (Universita' Degli Studi Di Napoli "Parthenope" - Италия).
            
            > Для информации: Университет Партенопа был основан в 1919 году в Неаполе, Италия. Он обеспечивает серьезное образование, направленное на развитие знаний, навыков общения и критического мышления, оцененных на международном уровне, у почти 15 000 студентов.
            
            Университет стал центром высшего образования и исследований в области экономики, права, инженерии, технологий, автомобильных наук и других важных направлений развития.
            
            [⏺Официальный канал XNU](https://t.me/nordic_edu)""";

    String ITALY_2_RU = """
            ⚡️Получатель гранта престижного Университета Тренто в Италии!
            
            Джавлон Нематов, студент магистратуры по направлению «Мировая экономика» в Северном университете, получил стипендию на обучение в Университете Тренто!
            
            📊 350-е место в мировом рейтинге лучших
            Университет Тренто, занимающий 457-е место в рейтинге университетов мира QS, предлагает грант — эксклюзивно для студентов университетов Северных стран!
            
            ✅ Присоединяйтесь к нашим студентам и откройте для себя двери в мир международных возможностей!
            ➖➖➖➖➖
            🔔 Напоминаем, что прием на 12 специальностей магистратуры и 16 специальностей бакалавриата продолжается (https://t.me/nordic_edu/4147).
            
            ➡️ https://qabul.nordicuniversity.org/uz
            
            +998555084400/@nordic_chat_bot
            
            [⏺Официальный канал Nordic](https://t.me/nordic_edu)""";

    String ITALY_3_RU = """
            ⚡️Получатель гранта престижного Университета Тренто в Италии!
            
            Студентка бакалавриата по направлению «Мировая экономика и международные экономические отношения» Северного университета Карина Рахматова получила стипендию на обучение в Университете Тренто!
            
            📊350-е место в мировом рейтинге лучших по версии THE,s
            Университет Тренто, занимающий 457-е место в мировом рейтинге QS, предлагает грант исключительно для студентов из скандинавских университетов!
            
            ✅ Присоединяйтесь к нам и воспользуйтесь нашими программами международного обмена!
            
            📺 https://www.youtube.com/shorts/d27NBVaFSmo
            ➖➖➖➖➖
            📌Прием заявок продолжается.
            
            ➡️ https://qabul.nordicuniversity.org/uz
            
            +998555084400/@nordic_chat_bot""";

    String UZ_REPORT_1_RU = """
            ⚡️⚡️⚡Встречайте победителей стипендии по журналистике!
            
            100% стипендии были предоставлены 10 абитуриентам, рекомендованным к зачислению и набравшим наивысшие баллы на вступительных экзаменах в магистратуру.
            
            > Получатели целевых грантов Министерства экологии, охраны окружающей среды и изменения климата Республики Узбекистан:
            1. Исмат Дустмуродов
            
            2. Низамжон Исламов
            
            3. Умарбек Эсанмуродов.с
            
            > Грантополучатели «Академии журналистики, медиа и коммуникаций UzReport», набравшие наивысшие баллы на вступительном экзамене (из 100 баллов):
            
            1. Мухаммадали Мамадалиев – 95 очков
            
            2. Мухтасар Исакова – 93 очка
            
            3. Гульзода Олимжонова – 93 очка
            
            4. Анвар Самедов - 90 очков
            
            5. Авазбек Араббоев – 90 очков
            
            6. Сайёра Кадирова – 85 очков
            
            7. Умиджон Мамарасулов ​​– 85 очков.
            
            Поздравляем получателей грантов!
            
            [⏺Официальный канал Nordic](https://t.me/nordic_edu)""";

    String UZ_REPORT_2_RU = """
            ⚡️Поздравляем грантополучателей!
            
            50% грантов были предоставлены 9 кандидатам, рекомендованным к зачислению на программу «Журналистика» и набравшим наивысшие баллы.
            
            > Познакомьтесь с получателями грантов «Академии журналистики, медиа и коммуникаций UzReport»:
            
            1. Сарвиноз Одилова
            
            2. Гульбахор Абдухалимов
            
            3. Санжар Кувандиков
            
            4. Сарвиноз Раджабова
            
            5. Симорахон Рахимжонова
            
            6. Диёра Давлотова
            
            7. Шодиёр Нияткобиловс
            
            8. Шахноза Рахматова
            
            9. Диёрбек Джурабоев.с
            
            [⏺Официальный канал Nordic](https://t.me/nordic_edu)""";

    String POLAND_RU = """
            🇵🇱 Наш студент отправляется в Польшу! 🛫
            
            Мадинабону Исакова получила грант международной программы Erasmus+ KA171 ICM.
            
            Благодаря стипендии он смог получить бесплатное образование в университете WSEI в Польше. Мадинабону также предоставляется стипендия для продолжения образования и науки.
            
            Удачи, Мадинабону!
            
            🌐 https://youtube.com/shorts/zMZWXynqmVs?si=LET3pWjx0oYV5JVu""";

    String AMERICA_RU = """
            #США_глазами_наших_студентов
            
            📹 Новости Северной Европы| Специальный репортаж из Технологического университета Лоуренса в Мичигане, США.
            
            📽 https://youtu.be/g0F29jsxu3k""";
}
