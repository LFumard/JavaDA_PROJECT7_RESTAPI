package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;

import java.util.List;

public interface RuleNameService {
    List<RuleName> findAll();

    void save(RuleName ruleName);

    RuleName findById(Integer id);

    void update(RuleName ruleName);

    void delete(Integer id);
}
