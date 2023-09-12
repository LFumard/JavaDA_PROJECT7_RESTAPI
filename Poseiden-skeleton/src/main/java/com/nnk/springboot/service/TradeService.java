package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;

import java.util.List;

public interface TradeService {
    List<Trade> findAll();

    List<Trade> save(Trade trade);

    Trade findById(Integer id);

    List<Trade> update(Trade trade);

    List<Trade> delete(Integer id);
}
