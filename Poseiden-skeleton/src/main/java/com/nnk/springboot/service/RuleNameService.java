package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;

import java.util.List;
import java.util.Optional;

public interface RuleNameService {
    List<RuleName> findAll();

    List<RuleName> save(RuleName ruleName);

    Optional<RuleName> findById(Integer id);

    List<RuleName> update(RuleName ruleName);

    List<RuleName> delete(Integer id);
}
