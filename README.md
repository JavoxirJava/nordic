# 🎓 Nordic University Telegram Bot

`Nordic Admission Bot` — bu Nordic University uchun ishlab chiqilgan, foydalanuvchilarga universitet haqida to‘liq ma’lumotlarni taqdim etuvchi Telegram botdir. Ushbu bot **Java + Spring Boot** texnologiyalari asosida yozilgan.

---

## 🎯 Maqsad

- Universitet haqida umumiy ma’lumot taqdim etish
- Turli yo‘nalishlar (bakalavr, magistratura) bo‘yicha foydalanuvchilarni xabardor qilish
- Foydalanuvchi bilan tugmalar orqali muloqot qilish
- Admin panel orqali xabarlar tarqatish va foydalanuvchi ma’lumotlarini boshqarish

---

## 🛠 Texnologiyalar

- ☕ Java 17
- 🌱 Spring Boot 3
- 📦 Maven
- 📬 [TelegramBots Java Library](https://github.com/rubenlagus/TelegramBots)
- 🐘 PostgreSQL (config via `application.properties`)

---

## 🧩 Muhim komponentlar

| Fayl/Komponent | Tavsifi |
|----------------|---------|
| `Template.java` | Bot token, username va API bazaviy manzillar |
| `BotSettings.java` | Telegram botni konfiguratsiya qiladi |
| `BotMethods.java` | Foydalanuvchiga xabar, rasm, video yuborish funksiyalari |
| `application.properties` | PostgreSQL konfiguratsiyasi (username, password, db name) |

---

## ⚙️ Ishga tushirish (local)

```bash
# 1. Loyihani klonlash
git clone https://github.com/yourusername/nordic-telegram-bot.git
cd nordic-telegram-bot

# 2. Telegram token va API manzillarni Template.java ga qo‘shing

# 3. Maven orqali build
mvn clean install

# 4. Dastur ishga tushirish
java -jar target/nordic-telegram-bot.jar
```

🌐 API Manzillari
Bot quyidagi API orqali yo‘nalishlar bo‘yicha ma’lumotlarni oladi:
```API
GET /api/education/directions?eduDegree=MASTER&language=uz
GET /api/education/directions?eduDegree=BACHELOR&language=ru
```
Ushbu manzillar Template.java ichida BASE_URL orqali boshqariladi.

# 🧑‍💼 Foydalanuvchi interfeysi
Botda foydalanuvchi inline tugmalar orqali:

Yo‘nalish tanlashi mumkin

Universitet haqida ma’lumot olishi mumkin

Til tanlovi: O‘zbekcha va Ruscha

# 👨‍💻 Admin Panel Imkoniyatlari
## Admin foydalanuvchi uchun quyidagi imkoniyatlar mavjud:

1. 🔁 Barcha foydalanuvchilarga rasm, video va matnli xabar yuborish
2. 👥 Foydalanuvchilar sonini ko‘rish
3. 📤 Foydalanuvchilarni .xlsx formatda Excel fayl sifatida yuklab olish

# 🚀 Deployment

✅ Bot lokalda ishga tushadi

✅ Serverda joylashtirilgan versiyasi mavjud

🔗 Telegramdagi manzili: @nordic_admissionbot

# 👨‍🎓 Muallif
*Javohir* – Java dasturchi va Telegram bot ishlab chiqaruvchisi
Loyihani Nordic University uchun ishlab chiqqan.
📬 Aloqa: @M_Javoxir_1

# 📝 Litsenziya
Bu loyiha universitet ichki ishlanmasi hisoblanadi. Koddan foydalanish uchun ruxsat so‘rashingiz kerak.

