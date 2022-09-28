package com.stringMvc.Assignment.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stringMvc.Assignment.model.Country;
import com.stringMvc.Assignment.repo.Country_Repo;

@Service
public class Country_Service {
	
	@Autowired
	Country_Repo Repo;
	
	// save 
	public void addNew(Country c) {
		try {
		Repo.saveAndFlush(c);
		}catch (NullPointerException e ) {
			System.out.println(e);
		}
	}
	
	// search
	public Country searchbyId(int id) {
		return Repo.findById(id).get();
	}
	
	// show
	public java.util.List<Country> showAll(){
		return Repo.findAll();
		
	}
	
	// delete
	public void delbyid(int id) {
		Repo.deleteById(id);
	}
}
