package com.flair.world.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the country_language database table.
 * 
 */
@Entity
@Table(name="country_language")
@NamedQuery(name="CountryLanguage.findAll", query="SELECT c FROM CountryLanguage c")
public class CountryLanguage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Id
	@Column(name="country_code", insertable=false, updatable=false)
	private String countryCode;
	
	@Id
	@Column(name="language", insertable=false, updatable=false)
	private String language;
	
	@JsonIgnore
	@Column(name="is_official")
	private Boolean isOfficial;
	
	@JsonIgnore
	private float percentage;

	//bi-directional many-to-one association to Country
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;

	public CountryLanguage() {
	}

	public String getCountryCode() {
		return this.countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Boolean getIsOfficial() {
		return this.isOfficial;
	}

	public void setIsOfficial(Boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

	public float getPercentage() {
		return this.percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CountryLanguage)) {
			return false;
		}
		CountryLanguage castOther = (CountryLanguage)other;
		return 
			this.countryCode.equals(castOther.countryCode)
			&& this.language.equals(castOther.language);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.countryCode.hashCode();
		hash = hash * prime + this.language.hashCode();
		
		return hash;
	}
}
