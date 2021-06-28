package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	private static void testGetAllCountries() {

 
		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		 
	}

	private static void getAllCountriesTest(String code) throws CountryNotFoundException {

		 
		Country country = countryService.findCountryByCode(code);

		LOGGER.debug("Country:{}", country);



	}

	public static void testAddCountry() {
	 
		Country country = new Country("cs", "cognizant");
		countryService.addCountry(country);

    }

	private static void updateCountryTest(String code, String name) throws CountryNotFoundException {

	 
		countryService.updateCountry(code, name);
 

	}

	private static void deleteCountryTest(String code) {

	 

		countryService.deleteCountry(code);
 

	}
	
	//day 2 handson
	private static void findCountryTest(String text) {
		 

		List<Country> country = (List<Country>) countryService.findCountry(text);

		LOGGER.debug("Country:{}", country);

		 
	}

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testGetAllCountries();
		getAllCountriesTest("IN");
		testAddCountry();
		getAllCountriesTest("cs");
		updateCountryTest("cs", "cognizant_manasa");
		deleteCountryTest("cs");
		findCountryTest("ou");

	}

}
