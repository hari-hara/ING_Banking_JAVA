package com.ing.bank.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.model.UserTransaction;
import com.ing.bank.repo.BankingRepo;
import com.ing.bank.service.BankingService;

@Service
public class BankingServiceImpl implements BankingService{

	@Autowired
	BankingRepo bankRepo;

	@Override
	public void saveTransaction(UserTransaction e) {
		
		bankRepo.save(e);
	}
	
	}
