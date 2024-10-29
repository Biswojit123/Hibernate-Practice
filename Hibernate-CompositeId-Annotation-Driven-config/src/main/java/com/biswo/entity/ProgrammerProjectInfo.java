package com.biswo.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
@Table(name="PROGRAM_PROJ_INFO")
public class ProgrammerProjectInfo {
	@NonNull
	@EmbeddedId
	private ProgrammerId programmerId;
	@Column(name="PROGRAMMER_NAME" ,length=20)
	@NonNull
	private String programmerName;
	@Column(name="PROJECT_NAME")
	@NonNull
	private String projectName;
	@Column(name="SALARY")
	@NonNull
	private Double salary;
	@Column(name="BUDGET")
	@NonNull
	private Double budget;
	@Version
	private Integer updationCount;
	@CreationTimestamp
	private Timestamp lunchTime;
	@UpdateTimestamp
	private Timestamp lastUpdateTime;
}
