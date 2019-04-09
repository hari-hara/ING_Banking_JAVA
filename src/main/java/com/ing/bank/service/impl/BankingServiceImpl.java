package com.ing.bank.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.model.BankUser;
import com.ing.bank.repo.BankingRepository;
import com.ing.bank.service.BankingService;

@Service
public class BankingServiceImpl implements BankingService{

	/*@Autowired
	BankingRepo bankRepo;*/
	
	@Autowired
	BankingRepository bankingRepository;

	/*@Override
	public void saveTransaction(UserTransaction e) {
		
		bankRepo.save(e);
	}*/
	
	@Override
	public BankUser findByUserName(String userName,String pwd) {
		return bankingRepository.findByUserName(userName,pwd);
	}
	
	}
