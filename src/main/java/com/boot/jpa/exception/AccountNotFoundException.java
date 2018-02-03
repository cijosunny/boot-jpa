package com.boot.jpa.exception;

public class AccountNotFoundException extends Exception {
	public AccountNotFoundException() {
		super("Account Not Found Exception");
	}
}
