package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.BarCodeGenerateForLabEntity;
import com.nova.dataservice.service.BarCodeGenerateForLabService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
@EnableAutoConfiguration

public class BarCodeGenerateForLabController {

	private BarCodeGenerateForLabService qrCodeService;


	@Autowired
	BarCodeGenerateForLabService barCodeGenerateForLabService;
	
	
	@PostMapping("/BarCodeGenerateForLab")
    public ResponseEntity<Object> BarCodeGenerateForLab(@RequestBody BarCodeGenerateForLabEntity data) {
		 barCodeGenerateForLabService.BarCodeGenerateForLab(data,"C:\\Users\\Admin\\Documents\\dumps\\example.pdf");

            return ResponseEntity.ok().header("Content-Type", "image/png").body("success");
    }
}
