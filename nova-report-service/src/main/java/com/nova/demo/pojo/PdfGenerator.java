package com.nova.demo.pojo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;

@Component
public class PdfGenerator {

	public void generatePdf() {
		try {
	        String outputDirectory = "C:\\Users\\Dell\\Downloads\\praveen_git\\";  // Specify the desired output directory here

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(outputDirectory+"example.pdf"));
			document.open();
			document.add(new Paragraph("Hello, World! This is a PDF file generated using iText."));
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
