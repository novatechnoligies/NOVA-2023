package com.nova.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackmethodController {

	@GetMapping("/dataServiceFallBack")
	public String  dataService() {
		return "data service is taking longer than expected" + "please try again later";
	}
	
	@GetMapping("/novareportserviceFallBack")
	public String  novareportservice() {
		return "data service is taking longer than expected" + "please try again later";
	}
}
