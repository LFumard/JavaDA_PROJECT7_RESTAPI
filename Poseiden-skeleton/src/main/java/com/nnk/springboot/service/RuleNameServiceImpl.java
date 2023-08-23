package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleNameServiceImpl implements RuleNameService{

    @Autowired
    RuleNameRepository ruleNameRepository;

    @Override
    public List<RuleName> findAll() {
        return ruleNameRepository.findAll();
    }

    @Override
    public List<RuleName> save(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
        return ruleNameRepository.findAll();
    }

    @Override
    public Optional<RuleName> findById(Integer id) {
        return ruleNameRepository.findById(id);
    }

    @Override
    public List<RuleName> update(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
        return ruleNameRepository.findAll();
    }

    @Override
    public List<RuleName> delete(Integer id) {
        RuleName ruleNameToDel = ruleNameRepository.findById(id).orElseThrow(() -> new RuntimeException("Roule Name doen't exist"));
        ruleNameRepository.delete(ruleNameToDel);
        return ruleNameRepository.findAll();
    }
}
