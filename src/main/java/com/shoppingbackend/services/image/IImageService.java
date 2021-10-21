package com.shoppingbackend.services.image;

import com.shoppingbackend.models.Image;
import com.shoppingbackend.models.Order;

import java.util.Optional;

public interface IImageService {
    Iterable<Image> findAll();
    Optional<Image> findById(Long id);
    Image save(Image image);
    Image update(Image image);
    void delete(Long id);
}
