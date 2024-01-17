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
		//Optional<ShopDetailsDTO> labData = shopDetailsService.findByIdShopDetails(1l);
		//UserDetailsDTO userData = userDetailsServices.getUserDetailsById(1l);
		//LabMasterDTO report = labReportGenaratorMasterService.labReportGenaratorMaster(1l);
		
		String filepath="D:\\labreportdev\\darshan.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			
			PdfDocument pdfdoc=new PdfDocument(writer);
			pdfdoc.addNewPage();
			
			Document document=new Document(pdfdoc);
			
			
			Table labTable = new Table(UnitValue.createPercentArray(new float[]{10.00f, 50.00f, 40.00f}))
                    .useAllAvailableWidth();  
			//logo starts here
			Image image = new Image(ImageDataFactory.create("D:\\labreportdev\\logo.png"))
                    .setWidth(UnitValue.createPercentValue(100))
                    .setAutoScale(true)
					.setTextAlignment(TextAlignment.CENTER);
			Cell imageCell = new Cell().add((image));
			
            labTable.addCell(imageCell.setTextAlignment(TextAlignment.CENTER));
			//logo ends here
            
            
            //lab name starts here
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

            Cell labNameCell = new Cell().add(labNameParagraph).add("\n").add(labAddressParagraph);
            
            labTable.addCell(labNameCell.setBorder(null).setTextAlignment(TextAlignment.LEFT));

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
            
           
            // Parameters table
            
            Table paramsTable = new Table(UnitValue.createPercentArray(new float[]{30.00f, 30.00f, 30.00f}))
                    .useAllAvailableWidth();
            
         // Add patient information
            Text patientDetails = new Text("YASH")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK)
            		.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell = new Cell().add(new Paragraph(patientDetails));
            
            paramsTable.addCell(patientDetailsCell.setTextAlignment(TextAlignment.LEFT));
            
            Text patientSampleDetails = new Text("Sample collected at")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK)
            		.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell2 = new Cell().add(new Paragraph(patientSampleDetails));
            
            paramsTable.addCell(patientDetailsCell2.setTextAlignment(TextAlignment.LEFT));
            
            Text barcode = new Text("Barcode")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK)
            		.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell3 = new Cell().add(new Paragraph(barcode));
            
            paramsTable.addCell(patientDetailsCell3.setTextAlignment(TextAlignment.LEFT));
            
            //Test name table
            
            Table testNameTable = new Table(UnitValue.createPercentArray(new float[]{100.00f}))
                    .useAllAvailableWidth();
           
            Text testNameText = new Text("COMPLTE BLOOD COUNT(CBC)")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setTextAlignment(TextAlignment.CENTER);

            Cell testNameTextCell = new Cell().add(new Paragraph(testNameText));

            testNameTable.addCell(testNameTextCell.setTextAlignment(TextAlignment.CENTER));
            
            //Test parameter details
            
            Table testDetailsTable = new Table(UnitValue.createPercentArray(new float[]{30.00f, 20.00f, 30.00f,20.00f}))
                    .useAllAvailableWidth();
            
            Text investigationDetails = new Text("Investigation")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell5 = new Cell().add(new Paragraph(investigationDetails));
            
            testDetailsTable.addCell(patientDetailsCell5.setTextAlignment(TextAlignment.LEFT));
            
            Text resultDetails = new Text("Result")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell6 = new Cell().add(new Paragraph(resultDetails));
            
            testDetailsTable.addCell(patientDetailsCell6.setTextAlignment(TextAlignment.LEFT));
            
            Text refValueDetails = new Text("Ref.Value")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell7 = new Cell().add(new Paragraph(refValueDetails));
            
            testDetailsTable.addCell(patientDetailsCell7.setTextAlignment(TextAlignment.LEFT));
            
            
            Text unitDetails = new Text("Unit")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell8 = new Cell().add(new Paragraph(unitDetails));
         
            testDetailsTable.addCell(patientDetailsCell8.setTextAlignment(TextAlignment.LEFT));
            
            //thanks Table starts
            Table thanksFooter = new Table(UnitValue.createPercentArray(new float[]{20.00f, 60.00f, 20.00f}))
                    .useAllAvailableWidth();
            
            Text thanks = new Text("Thanks For Reference")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell9 = new Cell().add(new Paragraph(thanks));
            
            thanksFooter.addCell(patientDetailsCell9.setTextAlignment(TextAlignment.LEFT));

            
            Text endOfReport = new Text("*******End Of Report******")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell patientDetailsCell10 = new Cell().add(new Paragraph(endOfReport));
            
            thanksFooter.addCell(patientDetailsCell10.setTextAlignment(TextAlignment.LEFT));
          //thanks Table ends
            
            //Doctors signature table starts
            Table doctorsSignatureTable = new Table(UnitValue.createPercentArray(new float[]{33.00f, 33.00f, 33.00f}))
                    .useAllAvailableWidth();
            
            Text tecnicianSig = new Text("Medical Lab Tecnician")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            
            Text additionalText = new Text("(DMLT,BMLT)")
                    .setFontColor(com.itextpdf.kernel.color.Color.GRAY)
                    .setFontSize(8);

            Paragraph paragraph = new Paragraph()
                    .add(tecnicianSig)
                    .add("\n") // Add a newline to separate the texts
                    .add(additionalText);
            		
            Cell patientDetailsCell11 = new Cell().add(new Paragraph(tecnicianSig));
            
            doctorsSignatureTable.addCell(patientDetailsCell11.setTextAlignment(TextAlignment.LEFT));
            
            
            Text doctorsSign = new Text("Dr.Payal Shah")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            
            Text additionalText1 = new Text("(MD,Pathologist)")
                    .setFontColor(com.itextpdf.kernel.color.Color.GRAY)
                    .setFontSize(8);

            Paragraph paragraph1 = new Paragraph()
                    .add(doctorsSign)
                    .add("\n") // Add a newline to separate the texts
                    .add(additionalText1);
            		
            Cell patientDetailsCell12 = new Cell().add(new Paragraph(doctorsSign));
            
            doctorsSignatureTable.addCell(patientDetailsCell12.setTextAlignment(TextAlignment.LEFT));
            
            
            Text doctorsSign2 = new Text("Dr.Vimal Shah")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            
            Text additionalText2= new Text("(MD,Pathologist)")
                    .setFontColor(com.itextpdf.kernel.color.Color.GRAY)
                    .setFontSize(8);

            Paragraph paragraph2 = new Paragraph()
                    .add(doctorsSign2)
                    .add("\n") // Add a newline to separate the texts
                    .add(additionalText2);
            		
            Cell patientDetailsCell13 = new Cell().add(new Paragraph(doctorsSign2));
            
            doctorsSignatureTable.addCell(patientDetailsCell13.setTextAlignment(TextAlignment.LEFT));
            //Doctors signature table ends

            
            // Add the table to the document
            document.add(labTable);
            document.add(labContactCell);
            document.add(paramsTable);
            document.add(testNameTable);
            document.add(testDetailsTable);
            document.add(thanksFooter);
            document.add(doctorsSignatureTable);
            
            // Close the document
            document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
