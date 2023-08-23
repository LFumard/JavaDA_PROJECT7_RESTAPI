package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService{

    @Autowired
    BidListRepository bidListRepository;

    public List<BidList> findAll() {
        return bidListRepository.findAll();
    }

    @Override
    public void save(BidList bid) {
        BidList bidListToSave = new BidList();
        bidListToSave.setAccount(bid.getAccount());
        bidListToSave.setType(bid.getAccount());
        bidListToSave.setBidQuantity(bid.getBidQuantity());
        bidListRepository.save(bidListToSave);
    }

    @Override
    public BidList findById(Integer id) {
        return bidListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid BidList Id : " + id));
    }

    @Override
    public BidList update(Integer id, BidList bidList) {
        BidList bidListToSave = bidListRepository.findById(id).orElseThrow(() -> new RuntimeException("Bid List doen't exist"));
        return (bidListRepository.save(bidList));
    }

    @Override
    public void delete(Integer id) {
        BidList bidListToDel = bidListRepository.findById(id).orElseThrow(() -> new RuntimeException("Bid List doen't exist"));
        bidListRepository.delete(bidListToDel);
    }
}
