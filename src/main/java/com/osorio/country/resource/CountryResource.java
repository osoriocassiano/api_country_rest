package com.osorio.country.resource;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.http.HTTPBinding;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osorio.country.entity.Country;
import com.osorio.country.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryResource {
	private final CountryService countryService;

	public CountryResource(CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Country>> getAll() {
		List<Country> countries = this.countryService.getAllCountries();
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
	
	@GetMapping("/all/{property}")
	public ResponseEntity<List<Country>> getAllOrderByProperty(@PathVariable("property") String property) {
		List<Country> countries = this.countryService.getAllCountriesByProprety(property);
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> getCountryById(@PathVariable("id") Long id) {
		Optional<Country> country = this.countryService.findCountryById(id);
		//return new ResponseEntity<>(country, HttpStatus.OK);
		if(this.countryService.findCountryById(id).isPresent()) {
			return new ResponseEntity<>(country, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		Country newCountry = this.countryService.addCountry(country);
		return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
		Country updateCountry = this.countryService.updateCountry(country);
		return new ResponseEntity<>(updateCountry, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id) {
		this.countryService.deleteCountry(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
