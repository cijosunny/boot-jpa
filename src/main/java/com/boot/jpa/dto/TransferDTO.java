package com.boot.jpa.dto;

public class TransferDTO {
	private String fromUPI;
	private String toUPI;
	private Double amount;
	
	public String getFromUPI() {
		return fromUPI;
	}
	public void setFromUPI(String fromUPI) {
		this.fromUPI = fromUPI;
	}
	public String getToUPI() {
		return toUPI;
	}
	public void setToUPI(String toUPI) {
		this.toUPI = toUPI;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
