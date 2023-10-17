package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepository ratingRepository;

    /**
     * Recherche l'ensemble des rating
     * @return l'ensemble des rating
     */
    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    /**
     * Sauvegarde un rating
     * @param rating contenu du rating à sauvegarder
     */
    @Override
    public void save(Rating rating) {
        ratingRepository.save(rating);
    }

    /**
     * Recherche d'un rating par son identifiant
     * @param id identifiant du rating à rechercher
     * @return rating attendu si trouvé
     */
    @Override
    public Rating findById(Integer id) {
        return ratingRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid Id Rating : " + id));
    }

    /**
     * Mise à jour d'un rating
     * @param id identifiant du rating à mettre à jour
     * @param rating contenu du rating à suavegarder
     * @return le contenu du rating sauvegardé
     */
    @Override
    public Rating update(Integer id, Rating rating) {
        Rating ratingToSave = ratingRepository.findById(id).orElseThrow(() -> new RuntimeException("Rating doen't exist"));
        return ratingRepository.save(rating);
    }

    /**
     * Suppression d'un rating
     * @param id identifiant du rating à supprimer
     */
    @Override
    public void delete(Integer id) {
        Rating ratingToSave = ratingRepository.findById(id).orElseThrow(() -> new RuntimeException("Rating doen't exist"));
        ratingRepository.delete(ratingToSave);
    }
}
