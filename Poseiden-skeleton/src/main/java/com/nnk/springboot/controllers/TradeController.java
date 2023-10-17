package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
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
public class TradeController {

    private static final Logger logger = LogManager.getLogger("TradeController");
    // TODO: Inject Trade service
    @Autowired
    TradeService tradeService;

    /**
     * Affiche la list template trade
     * @param model Class Model
     * @return la list template trade
     */
    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        // TODO: find all Trade, add to model
        model.addAttribute("trades", tradeService.findAll());
        logger.info("New request Mapping : show all trades");
        return "trade/list";
    }

    /**
     * Affiche la form template trade
     * @param trade Class trade
     * @return la template d'ajout de trade
     */
    @GetMapping("/trade/add")
    public String addTrade(Trade trade) {

        logger.info("New request Get Mapping : show form to add new trade");
        return "trade/add";
    }

    /**
     * Ajout d'un nouveau trade
     * @param trade à ajouter
     * @param result état du trade à ajouter
     * @param model Class Model
     * @return la list trade si le trade est correct, la form template trade sinon
     */
    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new trade : " + result);
            return "trade/add";
        }
        tradeService.save(trade);
        model.addAttribute("trades",tradeService.findAll());
        logger.info("New request Post Mapping : Add new trade : " + result);
        return "redirect:/trade/list";
    }

    /**
     * Affichage d'un trade pour modification
     * @param id du trade à modifier
     * @param model Class Model
     * @return la template de modification de trade
     */
    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
        model.addAttribute("trade",tradeService.findById(id));
        logger.info("New request Get Mapping : update trade : " + id);
        return "trade/update";
    }

    /**
     * Mise à jour d'un trade
     * @param id du trade à modifier
     * @param trade contenu du nouveau trade
     * @param result état du trade à modifier
     * @param model Class Model
     * @return la template List trade si le trade en paramètre est valide, la form trade sinon
     */
    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR update trade : " + id);
            return "trade/update";
        }

        logger.info("New request Post Mapping : update trade : " + id);
        tradeService.update(trade);
        model.addAttribute("trades", tradeService.findAll());
        return "redirect:/trade/list";
    }

    /**
     * Suppression d'un trade
     * @param id du trade à supprimer
     * @param model Class Model
     * @return la template list des trade
     */
    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        tradeService.delete(id);
        model.addAttribute("trades", tradeService.findAll());
        logger.info("New request Get Mapping : delete trade : " + id);
        return "redirect:/trade/list";
    }
}
