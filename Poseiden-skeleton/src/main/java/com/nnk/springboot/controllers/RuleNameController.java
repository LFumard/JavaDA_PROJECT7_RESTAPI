package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RuleNameController {
    private static final Logger logger = LogManager.getLogger("RuleNameController");

    // TODO: Inject RuleName service
    @Autowired
    RuleNameService ruleNameService;
    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        // TODO: find all RuleName, add to model
        model.addAttribute("ruleNames", ruleNameService.findAll());
        logger.info("New request Mapping : show all rules");
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {

        logger.info("New request Get Mapping : show form to add new rule");
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new rule : " + result);
            return "ruleName/add";
        }

        model.addAttribute("ruleName",ruleNameService.save(ruleName));
        logger.info("New request Post Mapping : Add new rule : " + result);
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form
        model.addAttribute("ruleName",ruleNameService.findById(id));
        logger.info("New request Get Mapping : update rule : " + id);
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR update rule : " + id);
            return "ruleName/update";
        }

        logger.info("New request Post Mapping : update rule : " + id);
        model.addAttribute("ruleNames", ruleNameService.update(ruleName));
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list
        model.addAttribute("ruleNames", ruleNameService.delete(id));
        logger.info("New request Get Mapping : delete rule : " + id);
        return "redirect:/ruleName/list";
    }
}
