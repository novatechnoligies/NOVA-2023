//package com.nova.demo.pojo;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Component;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//@Component
//public class ExcelGenerator {
//
//    public void generateExcel() {
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Example Sheet");
//
//        Row headerRow = sheet.createRow(0);
//        Cell headerCell = headerRow.createCell(0);
//        headerCell.setCellValue("Hello, World! This is an Excel file generated using Apache POI.");
//
//        try (FileOutputStream outputStream = new FileOutputStream("example.xlsx")) {
//            workbook.write(outputStream);
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
