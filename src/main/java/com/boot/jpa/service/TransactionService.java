package com.boot.jpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jpa.exception.AccountNotFoundException;
import com.boot.jpa.model.BankAccount;

@Service
@Transactional(rollbackOn = Exception.class)
public class TransactionService {
	@Autowired
	private BankAccountService accountService;
	
//	@Transactional(rollbackOn = Exception.class)
//	@Transactional(rollbackOn = AccountNotFoundException.class)
	public Boolean transferAmount(String fromUPI, String toUPI, Double amount) throws AccountNotFoundException{
		debit(fromUPI, amount);
		credit(toUPI, amount);
		return Boolean.TRUE;
	}
	
//	@Transactional(rollbackOn = AccountNotFoundException.class)
	public Boolean debit(String upiId, Double amount) throws AccountNotFoundException{
		BankAccount account = accountService.getBankAccount(upiId);
		if(account == null){
			throw new AccountNotFoundException();
		}
		account.setBalance(account.getBalance()-amount);
		accountService.updateBankAccount(account);
		return Boolean.TRUE;
	}
	
//	@Transactional(rollbackOn = AccountNotFoundException.class)
	public Boolean credit(String upiId, Double amount) throws AccountNotFoundException{
		BankAccount account = accountService.getBankAccount(upiId);
		if(account == null){
			throw new AccountNotFoundException();
		}
		account.setBalance(account.getBalance()+amount);
		accountService.updateBankAccount(account);
		return Boolean.TRUE;
	}
}
