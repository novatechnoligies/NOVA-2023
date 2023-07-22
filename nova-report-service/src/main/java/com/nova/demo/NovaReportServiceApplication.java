package com.nova.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
@Configuration
public class NovaReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovaReportServiceApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
