package com.microservice.training.countriesdemo.controller;

import com.microservice.training.countriesdemo.model.Country;
import com.microservice.training.countriesdemo.service.api.ICountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountriesController {

  @Autowired
  ICountriesService countriesService;

  @GetMapping(path = "/api/countries/continent/name/{continentName}")
  public ResponseEntity<List<Country>> findCountryByContinent(@PathVariable String continentName) {
    return new ResponseEntity<List<Country>>(
        countriesService.findCountriesByContinentName(continentName), HttpStatus.OK);
  }
  
  @GetMapping(path = "/api/countries/continent/id/{continentId}")
  public ResponseEntity<List<Country>> findCountryByContinent(@PathVariable Integer continentId) {
    return new ResponseEntity<List<Country>>(
        countriesService.findCountriesByContinentId(continentId), HttpStatus.OK);
  }

}
