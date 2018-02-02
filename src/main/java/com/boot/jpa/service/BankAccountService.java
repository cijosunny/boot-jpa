package com.boot.jpa.service;

import com.boot.jpa.model.BankAccount;

public interface BankAccountService {
	BankAccount saveBankAccount(BankAccount account);
	BankAccount getBankAccount(String upiId);
	BankAccount updateBankAccount(BankAccount account);
	Boolean deleteBankAccount(String upiId);
}
