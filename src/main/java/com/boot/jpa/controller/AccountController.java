package com.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa.dto.TransferDTO;
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
	
	@GetMapping("/get/{upiId}")
	public ResponseEntity<?> getBankAccount(@PathVariable("upiId") String upiId){
		return ResponseEntity.ok(accountService.getBankAccount(upiId));
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<?> getAllBankAccount(){
		return ResponseEntity.ok(accountService.getAllBankAccount());
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateBankAccount(@RequestBody BankAccount account){
		return ResponseEntity.ok(accountService.updateBankAccount(account));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteBankAccount(@RequestParam String upiId){
		return ResponseEntity.ok(accountService.deleteBankAccount(upiId));
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<?> transfer(@RequestBody TransferDTO transferDTO) throws AccountNotFoundException{
		Boolean isTransferred = transactionService.transferAmount(transferDTO.getFromUPI(), transferDTO.getToUPI(), transferDTO.getAmount());
		return ResponseEntity.ok(isTransferred);
	}
}
