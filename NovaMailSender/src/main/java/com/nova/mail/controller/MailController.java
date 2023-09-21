package com.nova.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.mail.service.MailServiceInter;

@RestController
@CrossOrigin(origins = "*")
public class MailController {

	@Autowired
	MailServiceInter inter;


	@GetMapping(value = "/sendMail")
	public String sendMail() {
		inter.sendMail("raviroogi5@gmail.com", "test", "i Love you boss i need to make this project ASAP thanks for support...!");
		return "done";
	}
}
