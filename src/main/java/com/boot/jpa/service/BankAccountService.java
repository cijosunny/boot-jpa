package com.boot.jpa.service;

import java.util.List;

import com.boot.jpa.model.BankAccount;

public interface BankAccountService {
	BankAccount saveBankAccount(BankAccount account);
	BankAccount getBankAccount(String upiId);
	List<BankAccount> getAllBankAccount();
	BankAccount updateBankAccount(BankAccount account);
	Boolean deleteBankAccount(String upiId);
}
