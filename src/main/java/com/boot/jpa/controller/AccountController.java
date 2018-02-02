package com.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa.exception.AccountNotFoundException;
import com.boot.jpa.model.BankAccount;
import com.boot.jpa.service.BankAccountService;
import com.boot.jpa.service.TransactionService;
@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private BankAccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBankAccount(@RequestBody BankAccount account){
		return ResponseEntity.ok(accountService.saveBankAccount(account));
	}
	@GetMapping("/transfer")
	public ResponseEntity<?> transfer(@RequestParam("fromUPI") String fromUPI, @RequestParam("toUPI") String toUPI,
			@RequestParam("amount") Double amount) throws AccountNotFoundException{
		Boolean isTransferred = transactionService.transferAmount(fromUPI, toUPI, amount);
		return ResponseEntity.ok(isTransferred);
	}
}
