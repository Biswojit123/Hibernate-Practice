package com.biswo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="STUCK_ANNO")
public class Stuck {
	//Auto generated id value
	@Id
	@GeneratedValue
	private Integer stuckId;
	@NonNull
	@Column(length=20)
	private String stuckName;
	@NonNull
	@Column
	private Double price;
	@Column(length=20)
	@NonNull
	private String exchange;
	@UpdateTimestamp
	private Timestamp lastUpdateTime;//it store the last update time of current record(This is the time Stamp concept)
	@CreationTimestamp
	private Timestamp lucnchTime;//It store the fist creation time when the actual record is store(This is the time Stamp concept)
	@Version
	private Integer updationCount;//It maintain the how many time record is update (This is the Version Concept)
}
