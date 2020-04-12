package com.flair.world.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flair.world.Repository.CountryRepository;
import com.flair.world.exception.support.CodeNotFoundException;
import com.flair.world.model.Country;

@RestController
@RequestMapping("")
public class CountryController {

	@Autowired
	private CountryRepository _CountryRepository;

	@GetMapping(value = "/{code}")
	public Country findByCode(@PathVariable final String code) {
		//
		Country country =_CountryRepository.findByCode(code);
		
		if (country == null)
			throw new CodeNotFoundException("INVALID_COUNTRY_CODE");
		
		return country;
	}
}
