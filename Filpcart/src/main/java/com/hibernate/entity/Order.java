package com.hibernate.entity;

public class Order {
	//private member
	//It is the good approach to set the value as Wrapper type
	private Integer orderId;
	private String orderType;
	private Double amount;
	private String qty;
	
	//Getter and Setter
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	//To string method print the details of object
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderType=" + orderType + ", amount=" + amount + ", qty=" + qty + "]";
	}
	
}
