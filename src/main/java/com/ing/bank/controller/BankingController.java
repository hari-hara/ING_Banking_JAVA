package com.ing.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.model.BankUser;
import com.ing.bank.model.LoginResponse;
import com.ing.bank.model.UserTransaction;
import com.ing.bank.service.BankingService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@EnableSwagger2
@RestController
@RequestMapping("/bank")


public class BankingController {

	@Autowired
	BankingService bankingService;
	
	@GetMapping("/version")
	public String version() {
		return "10.10.10";
		
	}
	
	/*@PostMapping("/transaction")
	public void postTransaction(@Valid @RequestBody UserTransaction us) {
		bankingService.saveTransaction(us);
		
	}*/
	
	@PostMapping("/login")
	public LoginResponse userLogin(@Valid @RequestBody BankUser bankUser) {
		LoginResponse responseObject = new LoginResponse();
		BankUser user = bankingService.findByUserName(bankUser.getUsername(),bankUser.getPwd());
	
		System.out.println("testing in login "+user.getAccountno()+user.getRole());
		if(null != user) {
		responseObject = new LoginResponse();
		responseObject.setMessage("login successful");
		responseObject.setRole(user.getRole());
		}else {
			responseObject.setMessage("login failed");
		}
		return responseObject;
	}
}
