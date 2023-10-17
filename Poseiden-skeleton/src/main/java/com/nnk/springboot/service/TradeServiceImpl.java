package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService{

    @Autowired
    TradeRepository tradeRepository;

    /**
     * Recherche l'ensemble des trade
     * @return l'ensemble des trades trouvés sous forme de Liste
     */
    @Override
    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    /**
     * Sauvegarde une trade
     * @param trade contenu de la trade à sauvegarder
     */
    @Override
    public void save(Trade trade) {
        Trade tradeToSave = new Trade();
        tradeToSave.setRevisionDate(Timestamp.valueOf(LocalDateTime.now()));
        tradeToSave.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        tradeToSave.setTradeDate(Timestamp.valueOf(LocalDateTime.now()));
        tradeRepository.save(trade);
    }

    /**
     * Recherche d'une trade par son identifiant
     * @param id de la trade à rechercher
     * @return contenu de la trade attendu si trouvé
     */
    @Override
    public Trade findById(Integer id) {
        return tradeRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid Id Trade : " + id));
    }

    /**
     * Mise à jour d'une trade
     * @param trade contenu de la trade à sauvegarder
     */
    @Override
    public void update(Trade trade) {
        trade.setRevisionDate(Timestamp.valueOf(LocalDateTime.now()));
        tradeRepository.save(trade);
    }

    /**
     * Suppression d'une trade
     * @param id identifiant de la trade à supprimer
     */
    @Override
    public void delete(Integer id) {
        Trade tradeToDel = tradeRepository.findById(id).orElseThrow(() -> new RuntimeException("Trade doen't exist"));
        tradeRepository.delete(tradeToDel);
    }
}
