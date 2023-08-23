package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeServiceImpl implements TradeService{

    @Autowired
    TradeRepository tradeRepository;

    @Override
    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    @Override
    public List<Trade> save(Trade trade) {
        tradeRepository.save(trade);
        return tradeRepository.findAll();
    }

    @Override
    public Optional<Trade> findById(Integer id) {
        return tradeRepository.findById(id);
    }

    @Override
    public List<Trade> update(Trade trade) {
        tradeRepository.save(trade);
        return tradeRepository.findAll();
    }

    @Override
    public List<Trade> delete(Integer id) {
        Trade tradeToDel = tradeRepository.findById(id).orElseThrow(() -> new RuntimeException("Trade doen't exist"));
        tradeRepository.delete(tradeToDel);
        return tradeRepository.findAll();
    }
}
