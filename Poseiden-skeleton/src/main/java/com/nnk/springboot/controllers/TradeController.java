package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
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
public class TradeController {

    private static final Logger logger = LogManager.getLogger("TradeController");
    // TODO: Inject Trade service
    @Autowired
    TradeService tradeService;
    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        // TODO: find all Trade, add to model
        model.addAttribute("trades", tradeService.findAll());
        logger.info("New request Mapping : show all trades");
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {

        logger.info("New request Get Mapping : show form to add new trade");
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new trade : " + result);
            return "trade/add";
        }

        model.addAttribute("trades",tradeService.save(trade));
        logger.info("New request Post Mapping : Add new trade : " + result);
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
        model.addAttribute("trade",tradeService.findById(id));
        logger.info("New request Get Mapping : update trade : " + id);
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR update trade : " + id);
            return "trade/update";
        }

        logger.info("New request Post Mapping : update trade : " + id);
        model.addAttribute("trades", tradeService.update(trade));
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
        model.addAttribute("trades", tradeService.delete(id));
        logger.info("New request Get Mapping : delete trade : " + id);
        return "redirect:/trade/list";
    }
}
