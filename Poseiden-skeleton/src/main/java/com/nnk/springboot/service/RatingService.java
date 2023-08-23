package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    List<Rating> findAll();

    List<Rating> save(Rating rating);

    Optional<Rating> findById(Integer id);

    Rating update(Integer id, Rating rating);

    List<Rating> delete(Integer id);
}
