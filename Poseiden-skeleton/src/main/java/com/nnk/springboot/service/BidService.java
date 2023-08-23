package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;

import java.util.List;

public interface BidService {
    List<BidList> findAll();

    void save(BidList bid);

    BidList findById(Integer id);

    BidList update(Integer id, BidList bidList);

    void delete(Integer id);
}
