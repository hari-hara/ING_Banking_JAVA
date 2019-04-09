package com.ing.bank.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@EnableSwagger2
@RestController
@RequestMapping("/bank")


public class BankingController {

	
	@GetMapping("/version")
	public String version() {
		return "10.10.10";
		
	}
	
	
}
