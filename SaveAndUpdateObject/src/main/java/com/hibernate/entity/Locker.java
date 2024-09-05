package com.hibernate.entity;

import lombok.Data;

@Data
//This is the bean class
//here final class implement the interface to perform the lazy operation because the it not perform the lazy operation
public final class Locker implements IProduct {
	//Member private field
	private Integer lockerId;
	private String lockerName;
	private String lockerPass;
	private String person;
}
