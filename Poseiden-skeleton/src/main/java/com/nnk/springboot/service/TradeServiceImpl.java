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

    @Override
    public List<Trade> findAll() {
        return tradeRepository.findAll();
    }

    @Override
    public List<Trade> save(Trade trade) {
        Trade tradeToSave = new Trade();
        tradeToSave.setRevisionDate(Timestamp.valueOf(LocalDateTime.now()));
        tradeToSave.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        tradeToSave.setTradeDate(Timestamp.valueOf(LocalDateTime.now()));
        tradeRepository.save(trade);
        return tradeRepository.findAll();
    }

    @Override
    public Trade findById(Integer id) {
        return tradeRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid Id Trade : " + id));
    }

    @Override
    public List<Trade> update(Trade trade) {
        trade.setRevisionDate(Timestamp.valueOf(LocalDateTime.now()));
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
