package unv.nordic.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import unv.nordic.entity.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExporter {
    public File exportUsersToExcel(List<User> users) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users");

        // Sarlavha (header) yozish
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Full Name");
        header.createCell(2).setCellValue("Phone Number");
        header.createCell(3).setCellValue("Language");

        // Har bir userni yozish
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getFullName());
            row.createCell(2).setCellValue(user.getPhoneNumber());
            row.createCell(3).setCellValue(user.getLanguage());
        }

        File tempFile = null;
        try {
            tempFile = File.createTempFile("users-", ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(tempFile);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


        return tempFile;
    }
}
