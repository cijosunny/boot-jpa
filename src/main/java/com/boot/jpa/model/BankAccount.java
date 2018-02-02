package com.boot.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {
	@Id
	private String upiId;
	private Double balance;
	
	public String getUpiId() {
		return upiId;
	}
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
