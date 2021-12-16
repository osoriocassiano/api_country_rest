package com.osorio.country.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osorio.country.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	Optional<Country> findCountryById(Long id);
	

	void deleteCountryById(Long id);


}
