package com.nova.mail.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nova.mail.service.MailServiceInter;

@Service
public class MailService implements MailServiceInter{


	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String toAdd, String sub, String body) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(toAdd);
		mailMessage.setSubject(sub);
		mailMessage.setText(body);
		javaMailSender.send(mailMessage);
		
	}
}
