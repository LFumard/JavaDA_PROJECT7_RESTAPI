package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> findAll();

    List<Rating> save(Rating rating);

    Rating findById(Integer id);

    Rating update(Integer id, Rating rating);

    List<Rating> delete(Integer id);
}
