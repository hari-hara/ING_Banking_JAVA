package com.ing.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ing.bank.model.UserTransaction;
import com.ing.bank.service.BankingService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@EnableSwagger2
@RestController
@RequestMapping("/bank")


public class BankingController {

	@Autowired
	BankingService bnkService;
	
	@GetMapping("/version")
	public String version() {
		return "10.10.10";
		
	}
	
	@PostMapping("/transaction")
	public void postTransaction(@Valid @RequestBody UserTransaction us) {
		bnkService.saveTransaction(us);
		
	}
}
