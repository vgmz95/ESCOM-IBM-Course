package com.microservice.training.countriesdemo.service.api;
import com.microservice.training.countriesdemo.model.entity.CountryEntity;

import java.util.List;

public interface ICountriesService {

  List<CountryEntity> findCountriesByContinentName(String continentName);
  CountryEntity findByCountryId(Integer countryId);  
  List<CountryEntity> findCountriesByContinentId(Integer continentId);
  CountryEntity SaveNewCountry(CountryEntity country);  
  
}
