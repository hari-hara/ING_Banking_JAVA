package com.ing.bank.service;

import com.ing.bank.model.BankUser;
import com.ing.bank.model.UserSummary;
import com.ing.bank.model.UserTransaction;

public interface BankingService {

	//public void saveTransaction(UserTransaction e);
	
	public BankUser findByUserName(String name,String pwd);
	
	public BankUser saveCustomerInfo(BankUser bankUser);
	
	public UserTransaction saveCustomerTransaction(UserTransaction userTransaction);
	
	public UserSummary getUserSummary(String userName);
}
