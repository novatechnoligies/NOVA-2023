package com.nova.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ClassPathResource;

import com.nova.demo.pojo.PdfGenerator;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class PdfController {

	
	 @Autowired
	 private PdfGenerator pdfGenerator;

	 @GetMapping(value = "/createPdf")
	 public void createPdf() {
		 pdfGenerator.generatePdf();
	}
	 


	    @GetMapping("/download")
	    public ResponseEntity<Resource> downloadFile() throws IOException {
	        Resource resource = new ClassPathResource("example.pdf");

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.setContentDispositionFormData("attachment", "example.pdf");
 
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .body(new InputStreamResource(resource.getInputStream()));
	    }
}
