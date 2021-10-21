package com.shoppingbackend.services.city;

import com.shoppingbackend.models.City;
import com.shoppingbackend.models.Image;

import java.util.Optional;

public interface ICityService {
    Iterable<City> findAll();
    Optional<City> findById(Long id);
    City save(City city);
    City update(City city);
    void delete(Long id);
}
