package com.biswo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Mark the class as persistence class
@Entity
//Map the class into database table
@Table(name="MOVIE_INFO")
//Add the LOmbok API-annotation for a simple class all default method available
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	//Declare the field as ID filed so unique identification
	@Id
	//map the filed with database column
	@Column(name="MID")
	private Integer movieId;
	@Column(name="MNAME")
	private String movieName;
	@Column(name="MHERO")
	private String movieHero;
	@Column(name="MBUJET")
	private Double movieBujet;
}
