package com.thesis.controller;


import com.thesis.model.Airport;
import com.thesis.model.Country;
import com.thesis.model.DTO.AirportDTO;
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
@RequestMapping("airports")
public class AirportController {

    private record AirportSingleDTO (String status, AirportDTO data) {}
    private record AirportListDTO (String status, List<AirportDTO> data) {}

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    private ModelMapper modelMapper;


    //ENDPOINTS

    //GET

    @GetMapping
    public List<Airport> getAllCountries() {
        return this.airportRepository.findAll();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable("id") Integer id) {
        return this.airportRepository.findById(id).orElseThrow();
    }




}
