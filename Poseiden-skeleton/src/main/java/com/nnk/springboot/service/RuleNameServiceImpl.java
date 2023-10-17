package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameServiceImpl implements RuleNameService{

    @Autowired
    RuleNameRepository ruleNameRepository;

    /**
     * Recherche de l'ensemble des ruleName
     * @return l'ensemble des ruleName
     */
    @Override
    public List<RuleName> findAll() {
        return ruleNameRepository.findAll();
    }

    /**
     * Enregistrement d'une ruleName
     * @param ruleName à sauvegarder
     */
    @Override
    public void save(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    /**
     * Recherche d'une ruleName par son identifiant
     * @param id identifiant de la ruleName à rechercher
     * @return le contenu de la ruleName si trouvé
     */
    @Override
    public RuleName findById(Integer id) {
        return ruleNameRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid Id Rule Name : " + id));
    }

    /**
     * Mise à jour d'une ruleName
     * @param ruleName contenu de la ruleName à sauvegarder
     */
    @Override
    public void update(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    /**
     * Suppression d'une ruleName
     * @param id de la ruleName à supprimer
     */
    @Override
    public void delete(Integer id) {
        RuleName ruleNameToDel = ruleNameRepository.findById(id).orElseThrow(() -> new RuntimeException("Roule Name doen't exist"));
        ruleNameRepository.delete(ruleNameToDel);
    }
}
