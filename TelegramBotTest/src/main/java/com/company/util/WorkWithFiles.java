package com.company.util;

import com.company.database.Database;
import com.company.entity.Todo;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WorkWithFiles {


    public static File getTodosWithPDF() {
        File file = new File("src/main/resources/todos.pdf");

        try (PdfWriter pdfWriter = new PdfWriter(file)) {
            List<Todo> todoList = Database.getTodos();

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);

            pdfDocument.addNewPage();

            Document document = new Document(pdfDocument);
            Paragraph paragraph = new Paragraph("Todos");
            paragraph.setTextAlignment(TextAlignment.CENTER);
            document.add(paragraph);


            float[] tableSize = {10, 25, 150, 30};
            Table table = new Table(tableSize);
            table.addCell("Id");
            table.addCell("UserId");
            table.addCell("Title");
            table.addCell("Completed");


            for (Todo todo : todoList) {
                table.addCell(String.valueOf(todo.getId()));
                table.addCell(String.valueOf(todo.getUserId()));
                table.addCell(todo.getTitle());
                table.addCell(String.valueOf(todo.getCompleted()));
            }

            document.add(table);


            document.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return file;

    }


    public static File getTodosWithExcel(){
        File file = new File("src/main/resources/todos.xlsx");

        try (XSSFWorkbook workbook = new XSSFWorkbook();
            FileOutputStream outputStream = new FileOutputStream(file);) {

            XSSFSheet sheet = workbook.createSheet("Todos");

            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("UserId");
            headerRow.createCell(2).setCellValue("Title");
            headerRow.createCell(3).setCellValue("Completed");

            List<Todo> todoList = Database.getTodos();

            int rowIndex = 0;
            for (Todo todo : todoList) {
                XSSFRow row = sheet.createRow(++rowIndex);
                row.createCell(0).setCellValue(todo.getId());
                row.createCell(1).setCellValue(todo.getUserId());
                row.createCell(2).setCellValue(todo.getTitle());
                row.createCell(3).setCellValue(String.valueOf(todo.getCompleted()));
            }


            for(int i=0;i<4;i++){
                sheet.autoSizeColumn(i);
            }

            workbook.write(outputStream);



        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;

    }
}
