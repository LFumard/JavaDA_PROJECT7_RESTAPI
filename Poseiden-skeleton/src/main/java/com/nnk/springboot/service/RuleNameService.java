package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;

import java.util.List;

public interface RuleNameService {
    List<RuleName> findAll();

    List<RuleName> save(RuleName ruleName);

    RuleName findById(Integer id);

    List<RuleName> update(RuleName ruleName);

    List<RuleName> delete(Integer id);
}
