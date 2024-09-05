package com.hibernate.entity;

import lombok.Data;

@Data
//This is the bean class
public class Locker {
	//Member private field
	private Integer lockerId;
	private String lockerName;
	private String lockerPass;
	private String person;
}
