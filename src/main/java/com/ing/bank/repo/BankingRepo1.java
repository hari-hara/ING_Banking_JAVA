package com.ing.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.bank.model.UserTransaction;

@Repository
public interface BankingRepo1 extends JpaRepository<UserTransaction, Long> {

	@Query("SELECT userTransaction FROM UserTransaction userTransaction  WHERE userTransaction.userName=(:username) order by userTransaction.currentDate desc ")
	public List<UserTransaction> findByUserName(@Param("username") String username);

}
