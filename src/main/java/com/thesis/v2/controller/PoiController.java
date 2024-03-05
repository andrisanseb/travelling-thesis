package com.thesis.v2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/pois")
public class PoiController {

    @GetMapping
    public ResponseEntity<String> getPois() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.opentripmap.com/0.1/en/places/radius?radius=10000&lon=19&lat=45&format=json&apikey=5ae2e3f221c38a28845f05b6b7b0db61efd41bbd2e165328783d1473";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }
}