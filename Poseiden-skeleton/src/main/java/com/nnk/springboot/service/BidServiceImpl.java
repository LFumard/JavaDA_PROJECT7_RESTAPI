package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class BidServiceImpl implements BidService{

    @Autowired
    BidListRepository bidListRepository;

    /**
     * Recherche l'ensemble des Bids
     * @return Liste des Bids
     */
    public List<BidList> findAll() {
        return bidListRepository.findAll();
    }

    /**
     * Enregistre une nouvelle Bid
     * @param bid à ajouter
     */
    @Override
    public void save(BidList bid) {
        BidList bidListToSave = new BidList();
        bidListToSave.setAccount(bid.getAccount());
        bidListToSave.setType(bid.getType());
        bidListToSave.setBidQuantity(bid.getBidQuantity());
        bidListToSave.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        bidListToSave.setRevisionDate(Timestamp.valueOf(LocalDateTime.now()));
        bidListRepository.save(bidListToSave);
    }

    /**
     * Recherche une Bid par son Id
     * @param id de la Bid à rechercher
     * @return l'enregistrement Bid si existant
     */
    @Override
    public BidList findById(Integer id) {
        return bidListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid BidList Id : " + id));
    }

    /**
     * Mise à jour d'une Bid
     * @param id Identifiant de la Bid à mettre à jour
     * @param bidList Enregistrement Bid à sauvegarder
     * @return la Bid enregistrée
     */
    @Override
    public BidList update(Integer id, BidList bidList) {
        BidList bidListToSave = bidListRepository.findById(id).orElseThrow(() -> new RuntimeException("Bid List doen't exist"));
        bidListToSave.setRevisionDate(Timestamp.valueOf(LocalDateTime.now()));
        return (bidListRepository.save(bidList));
    }

    /**
     * Suppression d'une Bid
     * @param id identifiant de la Bid à supprimer
     */
    @Override
    public void delete(Integer id) {
        BidList bidListToDel = bidListRepository.findById(id).orElseThrow(() -> new RuntimeException("Bid List doen't exist"));
        bidListRepository.delete(bidListToDel);
    }
}
