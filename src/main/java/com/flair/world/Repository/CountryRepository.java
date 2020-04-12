package com.flair.world.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flair.world.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	Country findByCode(String code);
}
