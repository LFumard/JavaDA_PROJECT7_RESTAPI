package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
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
public class RatingController {

    private static final Logger logger = LogManager.getLogger("RatingController");
    // TODO: Inject Rating service
    @Autowired
    RatingService ratingService;

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        // TODO: find all Rating, add to model
        model.addAttribute("rating", ratingService.findAll());
        logger.info("New request Mapping : show all rating");
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {

        logger.info("New request Get Mapping : show form to add new rating");
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new Rating : " + rating);
            return "rating/add";
        }

        model.addAttribute("rating",ratingService.save(rating));
        logger.info("New request Post Mapping : Add new Rating : " + result);
        //return "rating/add";
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
        model.addAttribute("rating",ratingService.findById(id));
        logger.info("New request Get Mapping : update Rating : " + id);
        return "rating/update";
    }

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

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
        model.addAttribute("rating", ratingService.delete(id));
        logger.info("New request Get Mapping : delete Rating : " + id);
        return "redirect:/rating/list";
    }
}
