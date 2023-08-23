package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeService {
    List<Trade> findAll();

    List<Trade> save(Trade trade);

    Optional<Trade> findById(Integer id);

    List<Trade> update(Trade trade);

    List<Trade> delete(Integer id);
}
