package com.spring.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {

	@GetMapping(value="/getEmployee")
	public String getEmployee() {
		return "Get Mapping";
	}
}
