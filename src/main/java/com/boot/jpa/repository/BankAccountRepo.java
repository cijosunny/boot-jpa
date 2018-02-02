package com.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.BankAccount;

public interface BankAccountRepo extends JpaRepository<BankAccount, String>{

}
