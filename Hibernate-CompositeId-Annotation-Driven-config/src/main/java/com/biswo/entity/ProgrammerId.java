package com.biswo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProgrammerId implements Serializable {
	@Column(name="PROGRAM_ID")
	private Integer programId;
	@Column(name="PROJECT_ID")
	private Integer projectId;
}
