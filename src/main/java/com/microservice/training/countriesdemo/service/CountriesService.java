package com.microservice.training.countriesdemo.service;

import com.microservice.training.countriesdemo.errorhandling.InvalidContinentException;
import com.microservice.training.countriesdemo.errorhandling.InvalidCountryException;
import com.microservice.training.countriesdemo.model.Continent;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.repository.api.CountryJpaRepository;
import com.microservice.training.countriesdemo.service.api.ICountriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountriesService implements ICountriesService {

	@Autowired
	CountryJpaRepository countriesRepository;

	@Override
	public List<CountryEntity> findCountriesByContinentName(String continentName) {
		Continent continent = Continent.continentByName(continentName);
		switch (continent) {
		case EUROPE:
			return countriesRepository.findByContinent(continent.getContinentName());
		case ASIA:
			return countriesRepository.findByContinent(continent.getContinentName());
		case AFRICA:
			return countriesRepository.findByContinent(continent.getContinentName());
		case NORTH_AMERICA:
			return countriesRepository.findByContinent(continent.getContinentName());
		default:
			throw new InvalidContinentException("Continent: " + continentName + " does not exist.");
		}
	}

	@Override
	public CountryEntity findByCountryId(Integer countryId) {
		Optional<CountryEntity> countryOpt = countriesRepository.findById(countryId);
		if (countryOpt.isPresent()) {
			return countryOpt.get();
		} else {
			throw new InvalidCountryException("Country with id: " + countryId + " does not exist.");
		}
	}
	
	@Override
	public CountryEntity SaveNewCountry(CountryEntity country) {
		Continent continent = Continent.continentByName(country.getContinent());
		switch (continent) {
		case EUROPE:
			countriesRepository.save(country);
			break;
		case ASIA:
			countriesRepository.save(country);
			break;
		case AFRICA:
			countriesRepository.save(country);
			break;
		case NORTH_AMERICA:
			countriesRepository.save(country);
			break;
		default:
			throw new InvalidContinentException("Continent: " + country.getContinent() + " does not exist.");
		}
		return country;	
		
	}
	
	public List<CountryEntity> findCountriesByContinentId(Integer continentId) {
		throw new UnsupportedOperationException("");
		/*
		 * Continent continent = Continent.continentById(continentId); switch
		 * (continent) { case EUROPE: return
		 * countriesRepository.findAllEuropeCountries(); case ASIA: return
		 * countriesRepository.findAllAsiaCountries(); case AFRICA: return
		 * countriesRepository.findAllAfricaCountries(); case NORTH_AMERICA: return
		 * countriesRepository.findAllNorthAmericaCountries(); default: throw new
		 * InvalidContinentException("Continent id: " + continentId +
		 * " does not exist."); }
		 */
	}



}
