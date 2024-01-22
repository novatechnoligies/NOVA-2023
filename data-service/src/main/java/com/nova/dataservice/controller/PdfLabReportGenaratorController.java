package com.nova.dataservice.controller;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
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
import com.itextpdf.layout.property.VerticalAlignment;
import com.nova.dataservice.DTO.LabMasterDTO;
import com.nova.dataservice.DTO.LabMasterHeading;
import com.nova.dataservice.DTO.LabParametersDto;
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
		Optional<ShopDetailsDTO> labData = shopDetailsService.findByIdShopDetails(4l);
		UserDetailsDTO userData = userDetailsServices.getUserDetailsById(1l);
		LabMasterDTO report = labReportGenaratorMasterService.labReportGenaratorMaster(1l);
		
		String filepath="D:\\labreportdev\\darshan.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			
			PdfDocument pdfdoc=new PdfDocument(writer);
			pdfdoc.addNewPage();
			
			Document document=new Document(pdfdoc);
			
			
			Table labTable = new Table(UnitValue.createPercentArray(new float[]{10.00f, 60.00f, 30.00f}))
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
            if (labData.isPresent()) {
				ShopDetailsDTO shopDetailsDTO = labData.get();
				
				String labNameStr = shopDetailsDTO.getShopName();
				
			
           // String labNameStr = "APOLO LAB KODIGEHALLI";
            int indexOfSpace = labNameStr.indexOf(" ");
            
            if (indexOfSpace >= 0) {
            	String firstWord = labNameStr.substring(0, indexOfSpace);
                String remainingText = labNameStr.substring(indexOfSpace + 1);

                // Add the first word in black
                Text firstWordText = new Text(firstWord)
                        .setBold()
                        .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                        .setFontSize(20.0f);

                // Add the remaining text in red
                Text remainingTextElement = new Text(remainingText)
                        .setBold()
                        .setFontColor(com.itextpdf.kernel.color.Color.RED)
                        .setFontSize(20.0f);

                // Create a paragraph with both text elements
                Paragraph labNameParagraph = new Paragraph().add(firstWordText).add(remainingTextElement);
                
                Paragraph labVisionParagraph = new Paragraph("Accurate | Caring | Instant")
                        .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                        .setFontSize(15.0f);
                
                Cell labNameCell = new Cell().add(labNameParagraph).add(labVisionParagraph);
                
                labTable.addCell(labNameCell.setPaddingLeft(20).setTextAlignment(TextAlignment.LEFT));
			}else {
				Paragraph labNameParagraph = new Paragraph(labNameStr)
		                .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
		                .setFontSize(20.0f);

		        Paragraph labVisionParagraph = new Paragraph("Accurate | Caring | Instant")
		                .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
		                .setFontSize(15.0f);

		        Cell labNameCell = new Cell().add(labNameParagraph).add(labVisionParagraph);

		        labTable.addCell(labNameCell.setPaddingLeft(20).setTextAlignment(TextAlignment.LEFT));
		    }
			
            
            }else {
            	String defaultLabName = "N/A";
                Paragraph defaultLabNameParagraph = new Paragraph(defaultLabName)
                        .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                        .setFontSize(20.0f);

                Paragraph defaultLabVisionParagraph = new Paragraph("Accurate | Caring | Instant")
                        .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                        .setFontSize(15.0f);

                Cell defaultLabNameCell = new Cell().add(defaultLabNameParagraph).add(defaultLabVisionParagraph);

                labTable.addCell(defaultLabNameCell.setPaddingLeft(20).setTextAlignment(TextAlignment.LEFT));
            
			}
            //Lab name ends here
            
            //phone icon,phoneNumber and email icon,emailId starts here
            
            if (labData.isPresent()) {
                ShopDetailsDTO shopDetailsDTO = labData.get();

                // Retrieve email and phone number from ShopDetailsDTO
                String email = shopDetailsDTO.getEmail();
                String phoneNumber = shopDetailsDTO.getPhone();
            
            
            Image phoneIcon = new Image(ImageDataFactory.create("D:\\labreportdev\\phone.png"))
                    .scaleToFit(10, 10)
                    .setMarginTop(10);
            
            Image emailIcon = new Image(ImageDataFactory.create("D:\\labreportdev\\email.png"))
                    .scaleToFit(10, 10);
                    
            Text emailId = new Text(email)
                    .setFontSize(8)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            
            Text phone = new Text(phoneNumber)
                    .setFontSize(8)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            
            Paragraph phoneDetailsParagraph = new Paragraph()
                    .add(phoneIcon)
                    .add("  ")
                    .add(phone)
                    .add("\n")
                    .add(emailIcon)
                    .add("  ")
                    .add(emailId);
            
            Cell phoneCell = new Cell().add(phoneDetailsParagraph);
            phoneCell.setTextAlignment(TextAlignment.LEFT);
            
            labTable.addCell(phoneCell.setPaddingLeft(10).setTextAlignment(TextAlignment.LEFT));
            
            }else {
            	String defaultEmail = "default@example.com";
                String defaultPhoneNumber = "N/A";

                Image phoneIcon = new Image(ImageDataFactory.create("D:\\labreportdev\\phone.png"))
                        .scaleToFit(10, 10)
                        .setMarginTop(10);

                Image emailIcon = new Image(ImageDataFactory.create("D:\\labreportdev\\email.png"))
                        .scaleToFit(10, 10);

                Text emaiId = new Text(defaultEmail)
                        .setFontSize(8)
                        .setFontColor(com.itextpdf.kernel.color.Color.BLACK);

                Text phoneNumber = new Text(defaultPhoneNumber)
                        .setFontSize(8)
                        .setFontColor(com.itextpdf.kernel.color.Color.BLACK);

                Paragraph phoneDetailsParagraph = new Paragraph()
                        .add(phoneIcon)
                        .add("  ")
                        .add(phoneNumber)
                        .add("\n")
                        .add(emailIcon)
                        .add("  ")
                        .add(emaiId);

                Cell phoneCell = new Cell().add(phoneDetailsParagraph);
                phoneCell.setTextAlignment(TextAlignment.LEFT);

                labTable.addCell(phoneCell.setPaddingLeft(10).setTextAlignment(TextAlignment.LEFT));
			}
            
          //phone icon,phoneNumber and email icon,emailId ends here
            
            ///lab address Table starts here
            
            Table labAddressTable = new Table(UnitValue.createPercentArray(new float[]{100f}))
                    .useAllAvailableWidth();
            
            
            if (labData.isPresent()) {
				ShopDetailsDTO shopDetailsDTO = labData.get();
				
				String labAddress = shopDetailsDTO.getShopAddress();
            
            Text labAddressDetails = new Text(labAddress)
            		.setFontSize(10)
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);

            Cell labAddressCell = new Cell().add(new Paragraph(labAddressDetails));

            labAddressTable.addCell(labAddressCell.setTextAlignment(TextAlignment.LEFT).setPaddingLeft(70));
            }else {
            	String labAddress = ("N/A");
                
                Text labAddressDetails = new Text(labAddress)
                		.setFontSize(10)
                		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);

                Cell labAddressCell = new Cell().add(new Paragraph(labAddressDetails));

                labAddressTable.addCell(labAddressCell.setTextAlignment(TextAlignment.LEFT).setPaddingLeft(70));
               
			}
            //lab address Table ends here
            
            Table paramsTable = new Table(UnitValue.createPercentArray(new float[]{21.00f,19.00f ,30.00f, 30.00f}))
                    .useAllAvailableWidth();
            
            if (userData != null) {
				String patientName = userData.getUsername();
				String gender = userData.getGender();
				String phone = userData.getPhone();
				String age = userData.getAge();
				
         // Add patient information starts
            Text patientNameDetails = new Text(patientName)
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLUE)
            		.setTextAlignment(TextAlignment.LEFT);
            
			
			  Text ageDetails = new Text(age)
					  .setFontColor(com.itextpdf.kernel.color.Color.BLACK) 
					  .setFontSize(10);
			 
            Text genderDetails = new Text(gender)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(10);

			/*
			 * Text pid = new Text("PID : 555")
			 * .setFontColor(com.itextpdf.kernel.color.Color.BLACK) .setFontSize(10);
			 */
            Text phoneDetails = new Text(phone)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(10); 
                    
            Paragraph patientDetailsParagraph = new Paragraph()
                    .add(patientNameDetails)
                    .add("\n") 
                    .add(ageDetails)
                    .add("\n") 
                    .add(genderDetails)
                    .add("\n") 
                    //.add(pid);
                    .add(phoneDetails);
                    
            Cell patientDetailsCell = new Cell().add(patientDetailsParagraph);
            
            paramsTable.addCell(patientDetailsCell.setTextAlignment(TextAlignment.LEFT));
            }else {
            	String patientName = ("N/A");
				String gender = ("N/A");
				String phone = ("N/A");
				
			Text patientNameDetails = new Text(patientName)
	            		.setBold()
	            		.setFontColor(com.itextpdf.kernel.color.Color.BLUE)
	            		.setTextAlignment(TextAlignment.LEFT);
			
			 Text genderDetails = new Text(gender)
	                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
	                    .setFontSize(10);
			 
			 Text phoneDetails = new Text(phone)
	                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
	                    .setFontSize(10); 
	                    
	            Paragraph patientDetailsParagraph = new Paragraph()
	                    .add(patientNameDetails)
	                    .add("\n") 
	                   // .add(age)
	                    //.add("\n") 
	                    .add(genderDetails)
	                    .add("\n") 
	                    //.add(pid);
	                    .add(phoneDetails);
	                    
	            Cell patientDetailsCell = new Cell().add(patientDetailsParagraph);
	            
	            paramsTable.addCell(patientDetailsCell.setTextAlignment(TextAlignment.LEFT));
	          
			}
         // Add patient information ends
            
           // QR code scanner starts here
            Image qrCodeImage = new Image(ImageDataFactory.create("D:\\labreportdev\\qrcode.png"))
            		//.setWidth(UnitValue.createPercentValue(30))
                    .setAutoScale(true)
					.setTextAlignment(TextAlignment.CENTER); // Adjust the size as needed
            
            Cell qrCodeCell = new Cell();
            qrCodeCell.add(qrCodeImage);
            qrCodeCell.setWidth(UnitValue.createPercentValue(8));
            qrCodeCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
            
            paramsTable.addCell(qrCodeCell.setTextAlignment(TextAlignment.CENTER));
            
         // QR code scanner starts here
            
            //patientSampleDetailsCell starts
            
            if (labData.isPresent()) {
            	ShopDetailsDTO shopDetailsDTO = labData.get();
    				
    			String labAddress = shopDetailsDTO.getShopAddress();
			
            
            Text patientSampleDetails = new Text("Sample Collected At:")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLUE)
            		.setTextAlignment(TextAlignment.LEFT);
            
            Text addressDetails = new Text(labAddress)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(10);
            
            Text refDetails = new Text("Ref.By: Dr.Harish")
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(10);
            
            Paragraph patientSampleDetailsParagraph = new Paragraph()
                    .add(patientSampleDetails)
                    .add("\n") 
                    .add(addressDetails)
                    .add("\n") 
                    .add(refDetails);
            
            Cell patientSampleDetailsCell = new Cell().add(patientSampleDetailsParagraph);
            
            paramsTable.addCell(patientSampleDetailsCell.setTextAlignment(TextAlignment.LEFT));
            } else {
            	
            	String labAddress = ("N/A");
    			
                
                Text patientSampleDetails = new Text("Sample Collected At:")
                		.setBold()
                		.setFontColor(com.itextpdf.kernel.color.Color.BLUE)
                		.setTextAlignment(TextAlignment.LEFT);
                
                Text addressDetails = new Text(labAddress)
                        .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                        .setFontSize(10);
                
                Text refDetails = new Text("Ref.By: Dr.Harish")
                        .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                        .setFontSize(10);
                
                Paragraph patientSampleDetailsParagraph = new Paragraph()
                        .add(patientSampleDetails)
                        .add("\n") 
                        .add(addressDetails)
                        .add("\n") 
                        .add(refDetails);
                  
                Cell patientSampleDetailsCell = new Cell().add(patientSampleDetailsParagraph);
                
                paramsTable.addCell(patientSampleDetailsCell.setTextAlignment(TextAlignment.LEFT));
			}
            //barcode image starts
            
         // Create a horizontal table for the barcode image
			
            Image barCodeImage = new Image(ImageDataFactory.create("D:\\labreportdev\\barcode.gif"))
                    .scaleToFit(80, 80)
                    .setMarginLeft(50);

            Text registeredPrefix = new Text("Registered On: ")
            		.setBold()
                    .setFontSize(8)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK);

            Text registeredTime = new Text("02:31 PM 02 DEC 23")
                    .setFontSize(8)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK);

            Text collectedPrefix = new Text("Collected On: ")
            		.setBold()
                    .setFontSize(8)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK);

            Text collectedTime = new Text("03:11 PM 02 DEC 23")
                    .setFontSize(8)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK);

            Text reportedPrefix = new Text("Reported On: ")
            		.setBold()
                    .setFontSize(8)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK);

            Text reportedTime = new Text("04:35 PM 02 DEC 23")
                    .setFontSize(8)
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK);

            Paragraph detailsParagraph = new Paragraph()
                    .add(barCodeImage)
                    .add("\n")
                    .add(registeredPrefix).add(registeredTime)
                    .add("\n")
                    .add(collectedPrefix).add(collectedTime)
                    .add("\n")
                    .add(reportedPrefix).add(reportedTime);

            Cell detailsCell = new Cell().add(detailsParagraph);
            paramsTable.addCell(detailsCell).setTextAlignment(TextAlignment.LEFT);
  
            //barcode image ends here
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
            
            Table testDetailsTable = new Table(UnitValue.createPercentArray(new float[]{45.00f, 15.00f, 20.00f,20.00f}))
                    .useAllAvailableWidth();
            
            Text investigationDetails = new Text("Investigation")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell investigationDetailsCell = new Cell().add(new Paragraph(investigationDetails));
            
            testDetailsTable.addCell(investigationDetailsCell.setTextAlignment(TextAlignment.CENTER));
            
            Text resultDetails = new Text("Result")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell resultDetailsCell = new Cell().add(new Paragraph(resultDetails));
            
            testDetailsTable.addCell(resultDetailsCell.setTextAlignment(TextAlignment.CENTER));
            
            Text refValueDetails = new Text("Ref.Value")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell refValueDetailsCell = new Cell().add(new Paragraph(refValueDetails));
            
            testDetailsTable.addCell(refValueDetailsCell.setTextAlignment(TextAlignment.CENTER));
            
            
            Text unitDetails = new Text("Unit")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            		//.setTextAlignment(TextAlignment.LEFT);
            
            Cell unitDetailsCell = new Cell().add(new Paragraph(unitDetails));
         
            testDetailsTable.addCell(unitDetailsCell.setTextAlignment(TextAlignment.CENTER));
            
           List<LabMasterHeading> headerList = report.getLabMasterHeadings();
           
           Table labMasterHeadingTableMain = new Table(UnitValue.createPercentArray(new float[]{100.00f}))
                   .useAllAvailableWidth();;
           
           for (LabMasterHeading labMasterHeading : headerList) {
        	   
        	   testDetailsTable.addCell(new Paragraph(labMasterHeading.getTestHeading()).setBold());
               testDetailsTable.addCell(new Paragraph(""));
               testDetailsTable.addCell(new Paragraph(""));
               testDetailsTable.addCell(new Paragraph(""));
               
              List<LabParametersDto> parameterDtoList = labMasterHeading.getLabParametersDtos();
              for (LabParametersDto parameterDto : parameterDtoList) {
		
            	  testDetailsTable.addCell(new Paragraph(parameterDto.getParameterName()).setFontSize(10));
                  testDetailsTable.addCell(new Paragraph(parameterDto.getMaxValu()).setFontSize(10));
                  testDetailsTable.addCell(new Paragraph(parameterDto.getUnit()).setFontSize(10));
                  testDetailsTable.addCell(new Paragraph(parameterDto.getMinValue() + " to " + parameterDto.getMaxValu()).setFontSize(10));
			}
              
		}
            
            //thanks Table starts
            Table thanksFooter = new Table(UnitValue.createPercentArray(new float[]{30.00f, 70.00f}))
                    .useAllAvailableWidth()
                    .setBorder(Border.NO_BORDER);
            
            Text thanks = new Text("Thanks For Reference")
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK)
            		.setFontSize(8);
            
            Cell thanksDetaisCell = new Cell().add(new Paragraph(thanks));
            
            thanksFooter.addCell(thanksDetaisCell.setTextAlignment(TextAlignment.LEFT));
            
            Text endOfReport = new Text("*******End Of Report******")
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK)
            		.setFontSize(8);
            		
            Cell endOfReportCell = new Cell().add(new Paragraph(endOfReport));
            endOfReportCell.setPaddingLeft(70);
            endOfReportCell.setMarginBottom(70);
            
            thanksFooter.addCell(endOfReportCell.setTextAlignment(TextAlignment.LEFT));
          //thanks Table ends
            
            //Doctors signature table starts
            Table doctorsSignatureTable = new Table(UnitValue.createPercentArray(new float[]{33.00f, 33.00f, 33.00f}))
                    .useAllAvailableWidth();
            
            Text tecnicianSig = new Text("Medical Lab Tecnician")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            
            Text additionalText = new Text("(DMLT,BMLT)")
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(8);
                    
            Paragraph technicianParagraph = new Paragraph()
                    .add(tecnicianSig)
                    .add("\n") // Add a newline to separate the texts
                    .add(additionalText)
                    .setMarginBottom(5);
            		
            Cell technicianSignatureCell = new Cell().add(technicianParagraph);
            
            doctorsSignatureTable.addCell(technicianSignatureCell.setTextAlignment(TextAlignment.CENTER));
            
            Text doctorsSign = new Text("Dr.Payal Shah")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            
            Text doctorAdditionalText = new Text("(MD,Pathologist)")
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(8);

            Paragraph firstDoctorparagraph = new Paragraph()
                    .add(doctorsSign)
                    .add("\n") // Add a newline to separate the texts
                    .add(doctorAdditionalText)
                    .setMarginBottom(5);
            		
            Cell doctorSignatureCell = new Cell().add(firstDoctorparagraph);
            
            doctorsSignatureTable.addCell(doctorSignatureCell.setTextAlignment(TextAlignment.CENTER));
            
            Text secondDoctorsSign = new Text("Dr.Vimal Shah")
            		.setBold()
            		.setFontColor(com.itextpdf.kernel.color.Color.BLACK);
            
            Text secondAdditionalText= new Text("(MD,Pathologist)")
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)
                    .setFontSize(8);

            Paragraph secondDoctorParagraph = new Paragraph()
                    .add(secondDoctorsSign)
                    .add("\n") // Add a newline to separate the texts
                    .add(secondAdditionalText)
                    .setMarginBottom(5);
            		
            Cell secondDoctorSigCell = new Cell().add(secondDoctorParagraph);
            
            doctorsSignatureTable.addCell(secondDoctorSigCell.setTextAlignment(TextAlignment.CENTER));
            //Doctors signature table ends

            // Add the table to the document
            document.add(labTable);
            document.add(labAddressTable);
            document.add(paramsTable);
            document.add(testNameTable);
            document.add(testDetailsTable);
           // document.add(labMasterHeadingTableMain);
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
