package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepository ratingRepository;
    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> save(Rating rating) {
        ratingRepository.save(rating);
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> findById(Integer id) {
        return ratingRepository.findById(id);
    }

    @Override
    public Rating update(Integer id, Rating rating) {
        Rating ratingToSave = ratingRepository.findById(id).orElseThrow(() -> new RuntimeException("Rating doen't exist"));
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> delete(Integer id) {
        Rating ratingToSave = ratingRepository.findById(id).orElseThrow(() -> new RuntimeException("Rating doen't exist"));
        ratingRepository.delete(ratingToSave);
        return ratingRepository.findAll();
    }
}
