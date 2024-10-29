package com.biswo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ProgrammerProjectInfo {
	@NonNull
	private ProgrammerId programmerId;
	@NonNull
	private String programmerName;
	@NonNull
	private String projectName;
	@NonNull
	private Double salary;
	@NonNull
	private Double budget;
	private Integer updationCount;
}
