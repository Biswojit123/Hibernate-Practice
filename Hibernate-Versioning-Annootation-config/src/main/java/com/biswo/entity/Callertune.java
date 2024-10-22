package com.biswo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
@Table(name="CALLERTUNE_ANNO")
public class Callertune {
	@Id
	@GeneratedValue
	private Integer callerId;
	@Column(length=30)
	private String movieName;
	@Column(length=30)
	private String tune;
	@Version
	private Integer updationCount;
}
