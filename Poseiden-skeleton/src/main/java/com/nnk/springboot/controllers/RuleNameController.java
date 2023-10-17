package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SessionAttributes("userInfo")
@Controller
public class RuleNameController {
    private static final Logger logger = LogManager.getLogger("RuleNameController");

    // TODO: Inject RuleName service
    @Autowired
    RuleNameService ruleNameService;

    /**
     * Affiche la list template ruleName
     * @param model Class Model
     * @return la ruleName template
     */
    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        // TODO: find all RuleName, add to model
        model.addAttribute("ruleNames", ruleNameService.findAll());
        logger.info("New request Mapping : show all rules");
        return "ruleName/list";
    }

    /**
     * Affiche la form template ruleName
     * @param ruleName Class ruleName
     * @return la template d'ajout de ruleName
     */
    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName ruleName) {

        logger.info("New request Get Mapping : show form to add new rule");
        return "ruleName/add";
    }

    /**
     * Ajout d'une nouvelle ruleName
     * @param ruleName à ajouter
     * @param result état de la ruleName à ajouter
     * @param model Class Model
     * @return la list template si la ruleName est correct, la form template ruleName sinon
     */
    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new rule : " + result);
            return "ruleName/add";
        }
        ruleNameService.save(ruleName);
        model.addAttribute("ruleName",ruleNameService.findAll());
        logger.info("New request Post Mapping : Add new rule : " + result);
        return "redirect:/ruleName/list";
    }

    /**
     * Affichage d'une ruleName pour modification
     * @param id de la ruleName à modifier
     * @param model Class Model
     * @return la template de modification de ruleName
     */
    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form
        model.addAttribute("ruleName",ruleNameService.findById(id));
        logger.info("New request Get Mapping : update rule : " + id);
        return "ruleName/update";
    }

    /**
     * Mise à jour d'une ruleName
     * @param id de la ruleName à modifier
     * @param ruleName contenu de la nouvelle Bid
     * @param result état de la ruleName à modifier
     * @param model Class Model
     * @return la template List ruleName si la ruleName en paramètre est valide, la form ruleName sinon
     */
    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR update rule : " + id);
            return "ruleName/update";
        }

        logger.info("New request Post Mapping : update rule : " + id);
        ruleNameService.update(ruleName);
        model.addAttribute("ruleNames", ruleNameService.findAll());
        return "redirect:/ruleName/list";
    }

    /**
     * Suppression d'une ruleName
     * @param id de la ruleName à supprimer
     * @param model Class Model
     * @return la template list des ruleName
     */
    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        ruleNameService.delete(id);
        model.addAttribute("ruleNames", ruleNameService.findAll());
        logger.info("New request Get Mapping : delete rule : " + id);
        return "redirect:/ruleName/list";
    }
}
