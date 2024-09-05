package com.swiggy.entity;

//Bean object
public class Product {
	//Private member
	private Integer productId;
	private String name;
	private String description;
	private Double price;
	private Integer qty;
	
	
	
	public Product() {
		super();
		System.out.println("Product object created successfully");
	}
	//Getter and Setter method
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
}
