package com.nova.dataservice.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUserStepDef {
	private String baseUrl = "http://localhost:8082/dataservice/saveUser";
	private HttpEntity<String> entity;
	private HttpHeaders httpHeaders;
	private ResponseEntity<String> response;
	
	@Given("^the client sends a POST request to \"([^\"]*)\"$")
	public void saveUserTestCucu(String url) {
		baseUrl = url;
	}
	
	@Given("^the request body is:$")
	private void theBody(String body) {
		// TODO Auto-generated method stub
		httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-type", "application/json");
		entity = new HttpEntity<>(body, httpHeaders);
	}
	
	@When("^the request is executed$")
	public void theExecuted() {
		RestTemplate restTemplate = new  RestTemplate();
		response = restTemplate.exchange(baseUrl, HttpMethod.POST, entity, String.class);
		
	}
	
	@Then("^the response status code should be (\\d+)$")
	private void theResponseCode(int statusCode) {
		assertEquals(statusCode, response.getStatusCode());
	}
	
	

}
