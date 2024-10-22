package com.biswo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Account {
	private Integer accountNum;
	private String holderName;
	private Double balance;
	private String type;
}
