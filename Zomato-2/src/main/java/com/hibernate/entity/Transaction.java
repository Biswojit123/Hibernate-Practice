package com.hibernate.entity;

//Bean class
public class Transaction {
	//Private Member 
	private String transctionId;
	private Double amount;
	private Long accountNumber;
	
	//Getter And Setter
	
	public Double getAmount() {
		return amount;
	}
	public String getTransctionId() { 
		return transctionId;
	}
	public void setTransctionId(String transctionId) {
		this.transctionId = transctionId;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "Transaction [transctionId=" + transctionId + ", amount=" + amount + ", accountNumber=" + accountNumber
				+ "]";
	}
	
}
