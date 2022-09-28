package com.stringMvc.Assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Country {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private String name;
	 private String capital;
	 private Double Population;
     
	 
	 
     public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Country() {
 	
 	}
   
	
	public Country(int id, String name, String capital, Double population) {
		super();
		this.id = id;
		this.name = name;
		this.capital = capital;
		this.Population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Double getPopulation() {
		return Population;
	}
	public void setPopulation(Double population) {
		Population = population;
	}

	
}
