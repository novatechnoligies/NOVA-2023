package com.nova.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NovaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovaGatewayApplication.class, args);
	}
	@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("DATA-SERVICE", r -> r.path("/DATA-SERVICE/**")
                        .uri("http://DATA-SERVICE"))
                .route("user-service", r -> r.path("/users/**")
                        .uri("http://user-service"))
                .build();
    }

}
