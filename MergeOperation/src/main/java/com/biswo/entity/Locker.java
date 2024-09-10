package com.biswo.entity;

import lombok.Data;

@Data
public class Locker {
	private Integer lockerId;
	private String lockerName;
	private String lockerPass;
	private String person;
}
