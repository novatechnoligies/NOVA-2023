package com.nova.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NovaMailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovaMailSenderApplication.class, args);
	}

}
