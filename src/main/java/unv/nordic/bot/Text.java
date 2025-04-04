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

    String REGISTER_UZ = """
            ✅ Tabriklaymiz, Hurmatli foydalanuvchi! Siz muvaffaqiyatli ro‘yxatdan o‘tdingiz.
            📚 Asosiy bo‘limlar:
            """;
    String REGISTER_RU = """
            ✅ Спасибо, уважаемый пользователь! Вы успешно зарегистрировались.
            📚 Главные разделы:
            """;
}
