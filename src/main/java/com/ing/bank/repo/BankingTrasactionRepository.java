package com.ing.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.bank.model.BankUser;
import com.ing.bank.model.UserTransaction;

@Repository
public interface BankingTrasactionRepository extends JpaRepository<UserTransaction, Integer>{
	
}
