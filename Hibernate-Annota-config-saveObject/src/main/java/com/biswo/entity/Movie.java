package com.biswo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Mark the class as persistence class
@Entity
//Map the class into database table
@Table(name = "MOVIE_INFO")
//Add the LOmbok API-annotation for a simple class all default method available
@Data
@AllArgsConstructor
@NoArgsConstructor
//Dynamic insert for generating sql query according to the value set 
//@DynamicInsert(value=true)
//Dynamic sql query generated and changes only the that column provided filed value
@DynamicUpdate
public class Movie {
	// Declare the field as ID filed so unique identification
	@Id
	// map the filed with database column
	@Column(name = "MID")
	private Integer movieId;
	@Column(name = "MNAME")
	private String movieName;
	@Column(name = "MHERO")
	private String movieHero;
	@Column(name = "MBUJET")
	// Declaring the transient means that filed value not participating in the
	// persistence operation either set the value or not
	//@Transient
	private Double movieBujet;
}
