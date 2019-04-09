package com.ing.bank.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_transaction")
public class UserTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	@Column(name = "accountno")
	private int accountno;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "debit")
	private double debit;

	@Column(name = "credit")
	private double credit;

	@Column(name = "current_datatime")
	private LocalDateTime currentDate;

	public LocalDateTime getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDateTime currentDate) {
		this.currentDate = currentDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

}
