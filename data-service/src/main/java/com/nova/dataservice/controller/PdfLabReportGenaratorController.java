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
			
			Paragraph headerParagraph = new Paragraph()
                    .setFontColor(com.itextpdf.kernel.color.Color.BLACK)  // Set the font color
                    .setFontSize(12)  // Set the font size
                    .setBold();
			
			
			Table table = new Table(UnitValue.createPercentArray(new float[]{10.33f, 70.33f, 20.33f}))
                    .useAllAvailableWidth();  
			
			 // Create a cell with colored text for "Column 1"
            Text column1Text = new Text("Column 1")
                    .setBold()
                    .setFontColor(com.itextpdf.kernel.color.Color.RED);

            // Create a cell with an empty border
            Cell cell1 = new Cell().add(new Paragraph(column1Text));


            // Add content to the table
            table.addCell(cell1);
            table.addCell(new Cell().add("Column 2").setBorder(null));
            table.addCell(new Cell().add("Column 3").setBorder(null));

           
            // Add the table to the document
            document.add(table);

            // Close the document
            document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
