package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@SessionAttributes("userInfo")
public class BidListController {

    private static final Logger logger = LogManager.getLogger("BidListController");
    // TODO: Inject Bid service
    @Autowired
    BidService bidService;

    /**
     * Affiche la list template BidList
     * @param model Class Model
     * @return la BidList template
     */
    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        // TODO: call service find all bids to show to the view
        logger.info("New request Mapping : show all Bids");
        model.addAttribute("bidList", bidService.findAll());
        return "bidList/list";
    }

    /**
     * Affiche la form template Bid
     * @param bid Class Bid
     * @return la template d'ajout de Bid
     */
    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        logger.info("New request Get Mapping : show form to add new bid");
        return "bidList/add";
    }

    /**
     * Ajout d'une nouvelle Bid
     * @param bid à ajouter
     * @param result état de la bind à ajouter
     * @param model Class Model
     * @return la list template si la Bind est correct, la form template Bid sinon
     */
    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return bid list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new bid : " + bid);
            return "bidList/add";
        }

        bidService.save(bid);
        model.addAttribute("bidList",bidService.findAll());
        logger.info("New request Post Mapping : Add new bid : " + bid);
        return "redirect:/bidList/list";
    }

    /**
     * Affichage d'une Bid pour modification
     * @param id de la Bid à modifier
     * @param model Class Model
     * @return la template de modification de Bid
     */
    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Bid by Id and to model then show to the form
        model.addAttribute("bidList",bidService.findById(id));
        logger.info("New request Get Mapping : update bid : " + id);
        return "bidList/update";
    }

    /**
     * Mise à jour d'une Bid
     * @param id de la Bid à modifier
     * @param bidList contenu de la nouvelle Bid
     * @param result état de la Bid à modifier
     * @param model Class Model
     * @return la template List Bid si la bid en paramètre est valide, la formBid sinon
     */
    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Bid and return list Bid
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR update bid : " + id);
            return "bidList/update";
        }
        logger.info("New request Post Mapping : update bid : " + id);
        bidService.update(id, bidList);
        model.addAttribute("bidList", bidService.findAll());
        return "redirect:/bidList/list";
    }

    /**
     * Suppression d'une Bid
     * @param id de la Bid à supprimer
     * @param model Class Model
     * @return la template list des Bid
     */
    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {

        bidService.delete(id);
        logger.info("New request Get Mapping : delete bid : " + id);
        return "redirect:/bidList/list";
    }
}
