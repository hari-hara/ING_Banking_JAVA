package com.ing.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.bank.model.BankUser;

@Repository
public interface BankingRepository extends JpaRepository<BankUser, Integer>{
	
	@Query("SELECT bankUser FROM BankUser bankUser  WHERE bankUser.username=(:username) and bankUser.pwd=(:pwd)")
	public BankUser findByUserName(@Param("username") String username,@Param("pwd") String pwd);
}
