package com.nova.dataservice.controller;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Optional;

import javax.swing.text.StyleConstants.ColorConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
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
import com.nova.dataservice.utils.QRCodeGenerator;

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
			
			
			Table labTable = new Table(UnitValue.createPercentArray(new float[]{10.00f, 60.00f, 30.00f}))
                    .useAllAvailableWidth();  
			
			Image image = new Image(ImageDataFactory.create("D:\\labreportdev\\logo.png"))
                    .setWidth(UnitValue.createPercentValue(100))
                    .setAutoScale(true);
            labTable.addCell(new Cell().add(image).setBorder(null));
			
//            Text column1Text = new Text("Column 1")
//                    .setBold()
//                    .setFontColor(com.itextpdf.kernel.color.Color.BLUE);
//
//            Cell cell1 = new Cell().add(new Paragraph(column1Text));
//
//
//            labTable.addCell(cell1.setBorder(null));
            
            
            String labNameStr = "APOLO LAB KODIGEHALLI";
            int indexOfSpace = labNameStr.indexOf(" ");
            String firstWord = labNameStr.substring(0, indexOfSpace);
            String remainingText = labNameStr.substring(indexOfSpace + 1);

            // Add the first word in black
            Text firstWordText = new Text(firstWord)
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(10.0f);

            // Add the remaining text in red
            Text remainingTextElement = new Text(remainingText)
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.RED)
                    .setFontSize(10.0f);

            // Create a paragraph with both text elements
            Paragraph labNameParagraph = new Paragraph().add(firstWordText).add(remainingTextElement);

            Paragraph labAddressParagraph = new Paragraph("123 Main Street City, Country ZIP Code")
                    .setFontColor(com.itextpdf.kernel.color.Color.RED)
                    .setFontSize(8.0f);

            // Create a cell with the combined text and address
            Cell labNameCell = new Cell().add(labNameParagraph).add("\n").add(labAddressParagraph);
            labTable.addCell(labNameCell.setBorder(null).setTextAlignment(TextAlignment.LEFT));


//            labTable.addCell(new Cell().add("Column 3").setBorder(null));
//
//            
//            labTable.addCell(new Cell().add("Column 3").setBorder(null));
            
            Cell labContactCell = new Cell();
            
            Image emailIcon = new Image(ImageDataFactory.create("D:\\labreportdev\\logo.png"))
                    .scaleToFit(10, 10);
            Paragraph emailParagraph = new Paragraph("example@example.com");

            labContactCell.add(emailIcon).add(emailParagraph);

            // Add some text after the email icon

            // Add phone icon
            Image phoneIcon = new Image(ImageDataFactory.create("D:\\labreportdev\\logo.png"))
                    .scaleToFit(10, 10);
            Paragraph phoneParagraph = new Paragraph("123456789");
            //phoneParagraph.add("\n"); // Add a new line if needed
            labContactCell.add(phoneIcon);
           
            labTable.addCell(labContactCell.setBorder(null));
            // Add the table to the document
            //document.add(labTable);
            
            
            Table patientTable = new Table(UnitValue.createPercentArray(new float[]{30.00f, 30.00f, 30.00f}))
                    .useAllAvailableWidth();  
			
            Text paname = new Text("Name: "+"Santosh")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLUE);

            Cell patNameCell = new Cell().add(new Paragraph(paname));

	         // Add QR code to third column
	         String qrCodeData = "mailto:san@nova-tech.in"; // Example data for an email address
	         Image qrCodeImage =QRCodeGenerator.generateQRCodeImage(qrCodeData, Color.BLACK, Color.WHITE);
	         Cell qrCodeCell = new Cell().add(qrCodeImage.setTextAlignment(TextAlignment.CENTER));
	
	         // Add the contents of patNameCell and qrCodeCell into a new cell
	         Cell combinedCell = new Cell().add(patNameCell).add(qrCodeCell)
	                 .setBorderLeft(null).setBorderTop(null).setBorderBottom(null);
	
	         // Add the combined cell to the patientTable
	         patientTable.addCell(combinedCell);

            Text ptAddress = new Text("Address:"+ "APOLO LAB KODIGEHALLI")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(10.0f);
            Cell ptAddressCell = new Cell().add(new Paragraph(ptAddress));
            		
            patientTable.addCell(ptAddressCell.setBorderLeft(null).setBorderTop(null).setBorderBottom(null));
            
           
            
            patientTable.addCell(new Cell().add("email: "+"san@nova-tech.in").setBorder(null));

            Table testNameTable = new Table(UnitValue.createPercentArray(new float[]{100.00f}))
                    .useAllAvailableWidth(); 
           
            Text testNameText = new Text("COMPLTE BLOOD COUNT(CBC)")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setTextAlignment(TextAlignment.CENTER);

            Cell testNameTextCell = new Cell().add(new Paragraph(testNameText));


            testNameTable.addCell(testNameTextCell.setTextAlignment(TextAlignment.CENTER));
            
            
            // Parameters table
            
            Table paramsTable = new Table(UnitValue.createPercentArray(new float[]{10.00f, 60.00f, 30.00f}))
                    .useAllAvailableWidth();  
			
			
            
            // Add the table to the document
            document.add(labTable);
            document.add(patientTable);
            document.add(testNameTable);
            document.add(paramsTable);
            

            // Close the document
            document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
//	private static Image generateQRCodeImage(String data, Color foregroundColor, Color backgroundColor) {
//        BarcodeQRCode qrCode = new BarcodeQRCode(data);
//        qrCode.setForegroundColor(foregroundColor);
//        qrCode.setBackgroundColor(backgroundColor);
//
//        return new Image(qrCode.createFormXObject(foregroundColor, backgroundColor));
//    }
	

}
