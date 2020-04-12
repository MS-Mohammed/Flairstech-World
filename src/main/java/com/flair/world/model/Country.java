package com.flair.world.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;
	
	private String continent;
	
	@Column(name="life_expectancy")
	private float lifeExpectancy;
	
	private String name;

	private Integer population;

	//bi-directional many-to-one association to CountryLanguage
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="country")
	private List<CountryLanguage> countryLanguages;

	public Country() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getContinent() {
		return this.continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public float getLifeExpectancy() {
		return this.lifeExpectancy;
	}

	public void setLifeExpectancy(float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulation() {
		return this.population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public List<CountryLanguage> getCountryLanguages() {
		return this.countryLanguages;
	}

	public void setCountryLanguages(List<CountryLanguage> countryLanguages) {
		this.countryLanguages = countryLanguages;
	}
}