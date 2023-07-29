package com.nova.Owner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OwnerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnerAppApplication.class, args);
	}

}
