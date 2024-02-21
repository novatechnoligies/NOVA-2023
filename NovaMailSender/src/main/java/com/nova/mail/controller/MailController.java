package com.nova.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.mail.service.MailServiceInter;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "mailservice")
public class MailController {

	@Autowired
	MailServiceInter inter;


	@GetMapping(value = "/sendMail")
	public String sendMail(String tomail,String otp) {
		inter.sendMail(tomail, "test", "i Love you boss i need to make this project ASAP thanks for support...!"+otp);
		return "done";
	}
	
	
	@GetMapping(value = "/sendAppointDetails")
	public String sendAppointDetails(String tomail, String slotId, String date) {
		inter.sendMail(tomail, "test", "booked appoint from you org to the nova lab with ...!"+slotId+" on Date "+date+"Dont  iss opprtunity Thanks to nova");
		return "done";
	}
}
