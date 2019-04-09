package com.ing.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bank.model.UserTransaction;



	
	@Repository
	public interface BankingRepo extends JpaRepository<UserTransaction, Long> {

}