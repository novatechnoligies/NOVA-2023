package com.nova.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.mail.service.MailServiceInter;

@RestController
public class MailController {

	@Autowired
	MailServiceInter inter;


	@GetMapping(value = "/sendMail")
	public String sendMail() {
		inter.sendMail("santoshhadapad2307@gmail.com", "test", "body");
		return "done";
	}
}
