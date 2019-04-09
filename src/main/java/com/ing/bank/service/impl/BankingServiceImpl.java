package com.ing.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.model.BankUser;
import com.ing.bank.model.UserTransaction;
import com.ing.bank.repo.BankingRepository;
import com.ing.bank.repo.BankingTrasactionRepository;
import com.ing.bank.service.BankingService;

@Service
public class BankingServiceImpl implements BankingService {

	/*
	 * @Autowired BankingRepo bankRepo;
	 */

	@Autowired
	BankingRepository bankingRepository;
	
	@Autowired
	BankingTrasactionRepository bankingTransactionRepository;

	/*
	 * @Override public void saveTransaction(UserTransaction e) {
	 * 
	 * bankRepo.save(e); }
	 */

	@Override
	public BankUser findByUserName(String userName, String pwd) {
		return bankingRepository.findByUserName(userName, pwd);
	}

	@Override
	public BankUser saveCustomerInfo(BankUser bankUserInfo) {

		BankUser bankUser = bankingRepository.save(bankUserInfo);
		
		return bankUser;
	}
	
	@Override
	public UserTransaction saveCustomerTransaction(UserTransaction userTransaction) {

		UserTransaction userTransactionn = bankingTransactionRepository.save(userTransaction);
		
		return userTransactionn;
	}
}
