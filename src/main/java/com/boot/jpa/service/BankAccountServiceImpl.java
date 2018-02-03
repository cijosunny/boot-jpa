package com.boot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jpa.model.BankAccount;
import com.boot.jpa.repository.BankAccountRepo;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountRepo bankRepo;

	@Override
	public BankAccount saveBankAccount(BankAccount account) {
		return bankRepo.save(account);
	}

	@Override
	public BankAccount getBankAccount(String upiId) {
		return bankRepo.findOne(upiId);
	}

	@Override
	public BankAccount updateBankAccount(BankAccount account) {
		return bankRepo.save(account);
	}

	@Override
	public Boolean deleteBankAccount(String upiId) {
		bankRepo.delete(upiId);
		return Boolean.TRUE;
	}

	@Override
	public List<BankAccount> getAllBankAccount() {
		return bankRepo.findAll();
	}
	
}
