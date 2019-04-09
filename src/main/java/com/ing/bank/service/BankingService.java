package com.ing.bank.service;

import com.ing.bank.model.BankUser;

public interface BankingService {

	//public void saveTransaction(UserTransaction e);
	
	public BankUser findByUserName(String name,String pwd);
}
