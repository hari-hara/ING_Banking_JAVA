package com.ing.bank.controller;

import javax.validation.Valid;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
	
		//System.out.println("testing in login "+user.getAccountno()+user.getRole());
		if(null != user) {
		responseObject = new LoginResponse();
		responseObject.setMessage("login successful");
		responseObject.setRole(user.getRole());
		}else {
			responseObject.setMessage("login failed");
		}
		return responseObject;
	}
	
	@PostMapping("/user")
	public LoginResponse createCustomer(@Valid @RequestBody BankUser bankUser) {
		LoginResponse responseObject = new LoginResponse();
		
		UserTransaction userTransaction = new UserTransaction();
		userTransaction.setCredit(bankUser.getTotalAmount());
		userTransaction.setTotalAmount(bankUser.getTotalAmount());
		userTransaction.setCurrentDate(LocalDateTime.now());
		BankUser customerInfo = new BankUser();
		//customerInfo.setUserTransaction(userTransaction);
		customerInfo.setUsername(bankUser.getUsername());
		customerInfo.setRole("cust");
		customerInfo.setPwd("123456");
		customerInfo.setAccounttype("SAVINGS");
		
	
		//{"message" : "User Created successfully/ unable to create user", "accountNo" : "1234" , "userName" : "xyz"}

		BankUser customerSavedInfo = bankingService.saveCustomerInfo(customerInfo);
		if(null != customerSavedInfo) {
			userTransaction.setAccountno(customerSavedInfo.getAccountno());
			userTransaction.setUserName(customerSavedInfo.getUsername());
			UserTransaction userTransactionn = bankingService.saveCustomerTransaction(userTransaction);
		}
		responseObject.setMessage("User Created successfully");
		responseObject.setAccountno(customerSavedInfo.getAccountno()+"");
		responseObject.setUserName(customerInfo.getUsername());
		return responseObject;
	}
}
