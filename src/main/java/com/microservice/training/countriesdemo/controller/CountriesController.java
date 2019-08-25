package com.microservice.training.countriesdemo.controller;

import com.microservice.training.countriesdemo.model.entity.CountryEntity;
import com.microservice.training.countriesdemo.service.api.ICountriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountriesController {

  @Autowired
  ICountriesService countriesService;

  @GetMapping(path = "/api/countries/continent/name/{continentName}")
  public ResponseEntity<List<CountryEntity>> findCountryByContinent(@PathVariable String continentName) {
    return new ResponseEntity<List<CountryEntity>>(
        countriesService.findCountriesByContinentName(continentName), HttpStatus.OK);
  }
  
  @GetMapping(path = "/api/countries/continent/id/{continentId}")
  public ResponseEntity<List<CountryEntity>> findCountryByContinent(@PathVariable Integer continentId) {
    return new ResponseEntity<List<CountryEntity>>(
        countriesService.findCountriesByContinentId(continentId), HttpStatus.OK);
  }
  
  @GetMapping(path = "/api/countries/country/id/{countryId}")
  public ResponseEntity<CountryEntity> findCountryByCountryId(@PathVariable Integer countryId) {
    return new ResponseEntity<CountryEntity>(
        countriesService.findByCountryId(countryId), HttpStatus.OK);
  }
  
  
  @PostMapping(path = "/api/countries/country/")
  public ResponseEntity<CountryEntity> saveCountry(@RequestBody CountryEntity country) {
    return new ResponseEntity<CountryEntity>(
        countriesService.SaveNewCountry(country), HttpStatus.OK);
  }
  

}
