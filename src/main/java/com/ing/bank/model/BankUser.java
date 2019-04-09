package com.ing.bank.model;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="bank_user")
public class BankUser{
	

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int accountno;
	
	@Column(name="username", nullable=false)
	private String username;
	
	@Column(name="pwd", nullable=false)
	private String pwd;

	@Column(name="role", nullable=false)
	private String role;
	
	@Column(name="accounttype", nullable=false)
	private String accounttype;
	
	/*@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="accountno")
	private UserTransaction userTransaction;
	
	public UserTransaction getUserTransaction() {
		return userTransaction;
	}

	public void setUserTransaction(UserTransaction userTransaction) {
		this.userTransaction = userTransaction;
	}*/
	
	@Transient
	@Column(name="created_on", nullable=false)
	private LocalDateTime created_on;
	
	@Transient
	private double totalAmount;
	
	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
