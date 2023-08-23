package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
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
public class CurveController {
    // TODO: Inject Curve Point service

    private static final Logger logger = LogManager.getLogger("CurveController");

/*    @Autowired
    CurvePointRepository curvePointRepository;*/

    @Autowired
    CurvePointService curvePointService;
    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        // TODO: find all Curve Point, add to model
        //model.addAttribute("curvePoints", curvePointRepository.findAll());
        model.addAttribute("curvePoints", curvePointService.findAll());
        logger.info("New request Mapping : show all Curve Point");
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {

        logger.info("New request Get Mapping : show form to add new Curve Point");
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new Curve Point : " + curvePoint);
            //return "curvePoint/list";
            return "curvePoint/add";
        }

        curvePointService.save(curvePoint);
        model.addAttribute("bidList",curvePointService.findAll());
        logger.info("New request Post Mapping : Add new Cure Point : " + curvePoint);
        //return "curvePoint/add";
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form
        model.addAttribute("curvePoint",curvePointService.findById(id));
        logger.info("New request Get Mapping : update Cure Point : " + id);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR update Cure Point : " + id);
            return "curvePoint/update";
        }

        //curvePoint.setId((byte) idInt);
        logger.info("New request Post Mapping : update Cure Point : " + id);
        model.addAttribute("bidList", curvePointService.update(id, curvePoint));
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
        curvePointService.delete(id);
        logger.info("New request Get Mapping : delete Curve Point : " + id);
        return "redirect:/curvePoint/list";
    }
}
