package com.nova.demo.pojo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Component
public class PdfGenerator {
	
	private final RestTemplate restTemplate;

    @Autowired
    public PdfGenerator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	public void generatePdf() {
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/findByIdShopDetails/2", HttpMethod.GET, null, String.class);
		JsonObject json = null;
		ResponseEntity<String> data = restTemplate.exchange("http://localhost:8081/getUserDetailsById/3", HttpMethod.GET, null, String.class);
		JsonObject json1 = null;
		if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody().toString();
            Gson gson = new Gson();
             json = gson.fromJson(responseBody, JsonObject.class);
		}
		Document document = new Document();

        try {
            // Create a PdfWriter to save the document to a file
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Admin\\Downloads\\praveen_git\\PDFWithTableExample.pdf"));

            // Open the document
            document.open();

            // Add content to the document
            Font font = new Font(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED));
//            Paragraph paragraph = new Paragraph("Hello, this is a simple iText PDF example.", font);
//            document.add(paragraph);

            // Create a table with 3 columns
            PdfPTable shopDetails = new PdfPTable(4);
            shopDetails.setWidthPercentage(100);
            
            PdfPTable UserDetails = new PdfPTable(4);
            UserDetails.setWidthPercentage(100);
            
            PdfPCell headerCell1 = new PdfPCell(new Paragraph(" LAB :", font));
            headerCell1.setBorder(PdfPCell.LEFT | PdfPCell.TOP );
            headerCell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); // Align the contents at the center
            shopDetails.addCell(headerCell1);
            
            PdfPCell headerCell2 = new PdfPCell(new Paragraph(json.get("shopName").toString()==null ? "name":json.get("shopName").toString(), font));
            headerCell2.setBorder(PdfPCell.TOP );
            headerCell2.setHorizontalAlignment(PdfPCell.LEFT); // Align the contents at the center
            shopDetails.addCell(headerCell2);
            
            PdfPCell headerCell3 = new PdfPCell(new Paragraph(" Address ", font));
            headerCell3.setBorder(PdfPCell.TOP );
            shopDetails.addCell(headerCell3);
            
            PdfPCell headerCell4 = new PdfPCell(new Paragraph(json.get("shopAddress").toString()==null ? "name":json.get("shopAddress").toString(), font));
            headerCell4.setBorder(PdfPCell.RIGHT | PdfPCell.TOP );
            shopDetails.addCell(headerCell4);
            
            PdfPCell phoneCell = new PdfPCell(new Paragraph(" Phone : :", font));
            phoneCell.setBorder(PdfPCell.LEFT  );
            phoneCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); // Align the contents at the center
            shopDetails.addCell(phoneCell);
            
            PdfPCell phoneDataCell = new PdfPCell(new Paragraph(json.get("phone").toString()==null ? "name":json.get("phone").toString(), font));
            phoneDataCell.setBorder(PdfPCell.NO_BORDER );
            phoneDataCell.setHorizontalAlignment(PdfPCell.LEFT); // Align the contents at the center
            shopDetails.addCell(phoneDataCell);
            
            PdfPCell emailCell = new PdfPCell(new Paragraph(" email ", font));
            emailCell.setBorder(PdfPCell.NO_BORDER );
            shopDetails.addCell(emailCell);
            
            PdfPCell emailDCell = new PdfPCell(new Paragraph(json.get("email").toString()==null ? "name":json.get("email").toString(), font));
            emailDCell.setBorder(PdfPCell.RIGHT  );
            shopDetails.addCell(emailDCell);
            
            
            PdfPCell emd = new PdfPCell(new Paragraph("  ", font));
            emd.setBorder(PdfPCell.LEFT | PdfPCell.BOTTOM );
            emd.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); // Align the contents at the center
            shopDetails.addCell(emd);
            
            PdfPCell emp = new PdfPCell(new Paragraph(" ", font));
            emp.setBorder(PdfPCell.BOTTOM );
            emp.setHorizontalAlignment(PdfPCell.LEFT); // Align the contents at the center
            shopDetails.addCell(emp);
            
            PdfPCell emk = new PdfPCell(new Paragraph(" date ", font));
            emk.setBorder(PdfPCell.BOTTOM );
            shopDetails.addCell(emk);
            
            PdfPCell emc = new PdfPCell(new Paragraph(String.valueOf(new Date()) , font));
            emc.setBorder(PdfPCell.RIGHT | PdfPCell.BOTTOM );
            shopDetails.addCell(emc);
            
            

            PdfPCell patientCell = new PdfPCell(new Paragraph(" RBC INDICES :", font));
            patientCell.setBorder(PdfPCell.LEFT | PdfPCell.TOP | PdfPCell.BOTTOM);
            patientCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); // Align the contents at the center
            shopDetails.addCell(patientCell);
            
            
            
            PdfPCell patientCell1 = new PdfPCell(new Paragraph(" username ", font));
            patientCell1.setBorder(PdfPCell.LEFT | PdfPCell.BOTTOM );
            patientCell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); // Align the contents at the center
            shopDetails.addCell(patientCell1);
            
            PdfPCell patientCell2 = new PdfPCell(new Paragraph("gender ", font));
            patientCell2.setBorder(PdfPCell.BOTTOM );
            patientCell2.setHorizontalAlignment(PdfPCell.LEFT); // Align the contents at the center
            shopDetails.addCell(patientCell2);
            
            PdfPCell patientCell3 = new PdfPCell(new Paragraph(" email ", font));
            patientCell3.setBorder(PdfPCell.BOTTOM | PdfPCell.RIGHT );
            shopDetails.addCell(patientCell3);
            
            PdfPCell patientCell7 = new PdfPCell(new Paragraph(json.get("email").toString()==null ? "name":json.get("email").toString(), font));
            patientCell7.setBorder(PdfPCell.RIGHT  );
            shopDetails.addCell(patientCell7);
            
            PdfPCell patientCell4 = new PdfPCell(new Paragraph(" phone ", font));
            patientCell4.setBorder(PdfPCell.BOTTOM );
            shopDetails.addCell(patientCell4);
            
            PdfPCell patientCell5 = new PdfPCell(new Paragraph(String.valueOf(new Date()) , font));
            patientCell5.setBorder(PdfPCell.RIGHT | PdfPCell.BOTTOM );
            shopDetails.addCell(patientCell5);
            

            document.add(shopDetails);

            document.close();


        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
	}
}
