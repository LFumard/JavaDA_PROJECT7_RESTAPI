package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
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
public class RatingController {

    private static final Logger logger = LogManager.getLogger("RatingController");
    // TODO: Inject Rating service
    @Autowired
    RatingService ratingService;

    /**
     * Affiche la list template rating
     * @param model Class Model
     * @return la list template rating
     */
    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        // TODO: find all Rating, add to model
        model.addAttribute("rating", ratingService.findAll());
        logger.info("New request Mapping : show all rating");
        return "rating/list";
    }

    /**
     * Affiche la form template rating
     * @param rating Class rating
     * @return la template d'ajout de rating
     */
    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {

        logger.info("New request Get Mapping : show form to add new rating");
        return "rating/add";
    }

    /**
     * Ajout d'un nouveau rating
     * @param rating à ajouter
     * @param result état du rating à ajouter
     * @param model Class Model
     * @return la list rating si le rating est correct, la form template rating sinon
     */
    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new Rating : " + rating);
            return "rating/add";
        }
        ratingService.save(rating);
        model.addAttribute("rating",ratingService.findAll());
        logger.info("New request Post Mapping : Add new Rating : " + result);
        return "redirect:/rating/list";
    }

    /**
     * Affichage d'un rating pour modification
     * @param id du rating à modifier
     * @param model Class Model
     * @return la template de modification de rating
     */
    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
        model.addAttribute("rating",ratingService.findById(id));
        logger.info("New request Get Mapping : update Rating : " + id);
        return "rating/update";
    }

    /**
     * Mise à jour d'un rating
     * @param id du rating à modifier
     * @param rating contenu du nouveau rating
     * @param result état du rating à modifier
     * @param model Class Model
     * @return la template List rating si le rating en paramètre est valide, la form rating sinon
     */
    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR update Rating : " + id);
            return "rating/update";
        }

        logger.info("New request Post Mapping : update Rating : " + id);
        model.addAttribute("rating", ratingService.update(id, rating));
        return "redirect:/rating/list";
    }

    /**
     * Suppression d'un rating
     * @param id du rating à supprimer
     * @param model Class Model
     * @return la template list des rating
     */
    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        ratingService.delete(id);
        model.addAttribute("rating", ratingService.findAll());
        logger.info("New request Get Mapping : delete Rating : " + id);
        return "redirect:/rating/list";
    }
}
