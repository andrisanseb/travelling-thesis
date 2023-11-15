package com.thesis.controller;

import com.thesis.model.Airport;
import com.thesis.model.Country;
import com.thesis.model.DTO.CountryDTO;
import com.thesis.repository.AirportRepository;
import com.thesis.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {

    private record CountrySingleDTO (String status, CountryDTO data) {}
    private record CountryListDTO (String status, List<CountryDTO> data) {}

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    private ModelMapper modelMapper;


    //GET ENDPOINTS
    @GetMapping
    public List<Country> getAllCountries() {
        return this.countryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable("id") Integer id) {
        return this.countryRepository.findById(id).orElseThrow();
    }

    @GetMapping("/{id}/airports")
    public List<Airport> getAllAirportsOfCountry(@PathVariable("id") Integer id) {
        return this.countryRepository.getReferenceById(id).getAirports();
    }

}
