package com.shoppingbackend.controller;

import com.shoppingbackend.models.City;
import com.shoppingbackend.services.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {
    @Autowired
    private ICityService cityService;

    @GetMapping("")
    private ResponseEntity<Iterable<City>> findAllCities(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }
}
