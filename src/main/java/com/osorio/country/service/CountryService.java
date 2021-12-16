package com.osorio.country.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.osorio.country.entity.Country;
import com.osorio.country.exception.CountryNotFoundException;
import com.osorio.country.repository.CountryRepository;

@Service
@Transactional
public class CountryService {
	private final CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public Country addCountry(Country country) {
		return this.countryRepository.save(country);
	}
	
	public List<Country> getAllCountries() {
		return this.countryRepository.findAll();
	}
	
	public List<Country> getAllCountriesByProprety(String property) {
		
//		if(property == "name") {
//			return this.countryRepository.findAllByOrderNameAsc();
//		}
//		
//		return this.countryRepository.findAll();
		return this.countryRepository.findAll(Sort.by(Sort.Direction.ASC, property));
	}
	
	public Optional<Country> findCountryById(Long id) {
		//return this.countryRepository.findCountryById(id).orElseThrow(() -> new CountryNotFoundException("Pais nao enccontrado pelo id"));
		return this.countryRepository.findCountryById(id);
	}
	
	public Country updateCountry(Country country) {
		return this.countryRepository.save(country);
	}
	
	public void deleteCountry(Long id) {
		countryRepository.deleteCountryById(id);
	}
	
}
