package com.stringMvc.Assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stringMvc.Assignment.model.Country;

public interface Country_Repo extends JpaRepository<Country,Integer> {

}
