package com.nova.dataservice.controller;

import java.io.FileNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.nova.dataservice.DTO.LabMasterDTO;
import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.service.LabReportGenaratorMasterService;
import com.nova.dataservice.service.ShopDetailsService;
import com.nova.dataservice.service.UserDetailsServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class PdfLabReportGenaratorController {
	
	@Autowired
	LabReportGenaratorMasterService labReportGenaratorMasterService;
	
	@Autowired
	ShopDetailsService shopDetailsService;
	
	@Autowired
	UserDetailsServices userDetailsServices;
	
	@GetMapping(value = "createPdfReportAndSave")
	public void createPdfReportAndSave(Long appointmentId, Long testId, String result) {
		Optional<ShopDetailsDTO> labData = shopDetailsService.findByIdShopDetails(1l);
		UserDetailsDTO userData = userDetailsServices.getUserDetailsById(1l);
		LabMasterDTO report = labReportGenaratorMasterService.labReportGenaratorMaster(1l);
		
		String filepath="D:\\labreportdev\\darshan.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			
			PdfDocument pdfdoc=new PdfDocument(writer);
			pdfdoc.addNewPage();
			
			Document document=new Document(pdfdoc);
			
//			Paragraph headerParagraph = new Paragraph()
//                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)  
//                    .setFontSize(12)  
//                    .setBold();
			
			
			Table labTable = new Table(UnitValue.createPercentArray(new float[]{10.00f, 70.00f, 20.00f}))
                    .useAllAvailableWidth();  
			
            Text column1Text = new Text("Column 1")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLUE);

            Cell cell1 = new Cell().add(new Paragraph(column1Text));


            labTable.addCell(cell1.setBorder(null));
            
            Text labName = new Text("   APOLO LAB KODIGEHALLI")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(10.0f);
            Cell labNameCell = new Cell().add(new Paragraph(labName));
            		
            labTable.addCell(labNameCell.setBorder(null).setTextAlignment(TextAlignment.CENTER));
            
            labTable.addCell(new Cell().add("Column 3").setBorder(null));

           
            // Add the table to the document
            //document.add(labTable);
            
            
            Table patientTable = new Table(UnitValue.createPercentArray(new float[]{30.00f, 30.00f, 30.00f}))
                    .useAllAvailableWidth();  
			
            Text paname = new Text("Name: "+"Santosh")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLUE);

            Cell patNameCell = new Cell().add(new Paragraph(paname));


            patientTable.addCell(patNameCell.setBorderLeft(null).setBorderTop(null).setBorderBottom(null));
            
            Text ptAddress = new Text("Address:"+ "APOLO LAB KODIGEHALLI")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(10.0f);
            Cell ptAddressCell = new Cell().add(new Paragraph(ptAddress));
            		
            patientTable.addCell(ptAddressCell.setBorder(null));
            
            patientTable.addCell(new Cell().add("email: "+"san@nova-tech.in").setBorder(null));

            Table testNameTable = new Table(UnitValue.createPercentArray(new float[]{100.00f}))
                    .useAllAvailableWidth(); 
           
            Text testNameText = new Text("COMPLTE BLOOD COUNT(CBC)")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setTextAlignment(TextAlignment.CENTER);

            Cell testNameTextCell = new Cell().add(new Paragraph(testNameText));


            testNameTable.addCell(testNameTextCell.setTextAlignment(TextAlignment.CENTER));
            
            // Add the table to the document
            document.add(labTable);
            document.add(patientTable);
            document.add(testNameTable);
            

            // Close the document
            document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
