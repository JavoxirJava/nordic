package unv.nordic.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import unv.nordic.bot.BotSettings;
import unv.nordic.bot.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ImageUploader implements CommandLineRunner {

    private final BotSettings bot;

    public ImageUploader(BotSettings botSettings) {
        this.bot = botSettings;
    }

    private static final String IMAGE_FOLDER = "images/";
    private static final String OUTPUT_FILE = "fileIds.txt";
    private static final Long DUMMY_CHAT_ID = Template.CREATOR_ID_2;

    @Override
    public void run(String... args) throws Exception {
        Map<String, String> savedFileIds = loadExistingFileIds();

        File folder = new File(IMAGE_FOLDER);
        File[] files = folder.listFiles((dir, name) -> {
            System.out.println(name);
            return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".webp");
        });

        if (files == null || files.length == 0) {
            System.out.println("📁 Rasm fayllar topilmadi.");
            return;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true)); // append true

        for (File image : files) {
            String fileName = image.getName();

            if (savedFileIds.containsKey(fileName)) {
                System.out.println("ℹ️ FileID mavjud: " + fileName + " – o‘tkazildi");
                continue;
            }

            try {
                SendPhoto sp = new SendPhoto();
                sp.setChatId(DUMMY_CHAT_ID.toString());
                sp.setPhoto(new InputFile(image));

                Message msg = bot.execute(sp);
                String fileId = msg.getPhoto()
                        .stream()
                        .max(Comparator.comparing(PhotoSize::getFileSize))
                        .get()
                        .getFileId();

                writer.write(fileName + "=" + fileId);
                writer.newLine();

                System.out.println("✅ Success: " + fileName);
            } catch (Exception e) {
                System.err.println("❌ Error: " + fileName);
                System.err.println(e.getMessage());
            }
        }

        writer.close();
        System.out.println("📄 New files added (if exist).");
    }

    public Map<String, String> loadExistingFileIds() {
        Map<String, String> map = new HashMap<>();
        File file = new File(OUTPUT_FILE);

        if (!file.exists()) return map;

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                String[] parts = line.split("=");
                if (parts.length == 2) map.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            System.err.println("⚠️ fileIds.txt read error!");
            System.err.println(e.getMessage());
        }

        return map;
    }
}
