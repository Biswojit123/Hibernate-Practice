package com.biswo.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Stuck {
	//Auto generated id value
	private Integer stuckId;
	@NonNull
	private String stuckName;
	@NonNull
	private Double price;
	@NonNull
	private String exchange;
	//Here maintain the last update or Insertion time of record
	private Timestamp lastUpdate;//that use for time stamping
}
