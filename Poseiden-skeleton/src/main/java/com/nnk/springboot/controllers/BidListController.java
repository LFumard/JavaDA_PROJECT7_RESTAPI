package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidService;
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
public class BidListController {

    private static final Logger logger = LogManager.getLogger("BidListController");
    // TODO: Inject Bid service
    @Autowired
    BidService bidService;

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        // TODO: call service find all bids to show to the view
        logger.info("New request Mapping : show all Bids");
        model.addAttribute("bidList", bidService.findAll());
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        logger.info("New request Get Mapping : show form to add new bid");
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return bid list
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR add new bid : " + bid);
            return "bidList/add";
        }

        bidService.save(bid);
        //model.addAttribute("bisList",bidListRepository.findAll());
        model.addAttribute("bidList",bidService.findAll());
        logger.info("New request Post Mapping : Add new bid : " + bid);
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Bid by Id and to model then show to the form
        //model.addAttribute("bisList",bidListRepository.findById(id));
        model.addAttribute("bidList",bidService.findById(id));
        logger.info("New request Get Mapping : update bid : " + id);
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Bid and return list Bid
        if(result.hasErrors()) {
            logger.error("New request Post Mapping : ERROR update bid : " + id);
            return "bidList/update";
        }
        logger.info("New request Post Mapping : update bid : " + id);
        /*String idString = Integer.toString(id);
        int idInt = Integer.parseInt(idString);

        //bidList.setBidListId(Byte.valueOf((byte) idInt));
        bidList.setBidListId(idInt);
        bidListRepository.save(bidList);

        model.addAttribute("bidList", bidListRepository.findAll());*/
        bidService.update(id, bidList);
        model.addAttribute("bidList", bidService.findAll());
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Bid by Id and delete the bid, return to Bid list
        //Optional<BidList> bidList = bidListRepository.findById(id);

        //byte strId = Byte.parseByte(Integer.toString(id));
        //bidListRepository.delete(bidList.get());

        bidService.delete(id);
        logger.info("New request Get Mapping : delete bid : " + id);
        return "redirect:/bidList/list";
    }
}
