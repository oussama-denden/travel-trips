package com.tritux.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tritux.domain.TravelTrip;
import com.tritux.service.TravelTripService;
 
@Controller
public class WebFormController {
     
    private TravelTripService travelTripService;
 
    @Autowired
    public WebFormController(TravelTripService travelTripService){
        this.travelTripService = travelTripService;
    }
 
    private boolean firstTime = true;
 
    @RequestMapping(value = "/myTravels", method = RequestMethod.GET)
    public String displaySortedTravelTrips(Model model) {
        if(firstTime){
            createDummyTravelTrips();
            firstTime = false;
        }
        model.addAttribute("travelTripList", travelTripService.findAll());
        return "index";
    }
 
    @RequestMapping(value = "/addTravelTripForm", method = RequestMethod.GET)
    public String addTravelTripForm(Model model){
        model.addAttribute("newTravelTrip", new TravelTrip());
        return "addTravelTrip";
    }
 
    @RequestMapping(value = "/addTravelTrip", method = RequestMethod.POST)
    public String registerNewTravelTrip(
            @Valid @ModelAttribute("newTravelTrip") TravelTrip newTravelTrip,
            BindingResult result, Model model) {                
         
        if (!result.hasErrors()) {          
            travelTripService.addTravelTrip(newTravelTrip);
            model.addAttribute("travelTripList", travelTripService.findAll());
            return "redirect:/";
        } else {
            return "addTravelTrip";
 
        }       
    }
 
    @RequestMapping(value="/{tripID}/deleteTravelTrip", method=RequestMethod.GET)
    public String deleteTravelTrip(@PathVariable("tripID") String tripID, Model model){     
 
        travelTripService.delete(Integer.parseInt(tripID));     
        model.addAttribute("travelTripList", travelTripService.findAll());      
        return "redirect:/";
    }
 
    @RequestMapping(value="/{tripID}/editTravelTripForm", method=RequestMethod.GET)
    public String ediTravelTripForm(@PathVariable("tripID") String tripID, Model model){        
        
        TravelTrip tempTravelTrip = travelTripService.findById(Integer.parseInt(tripID));
 
        if(tempTravelTrip == null){
            return "index";
        }
 
        model.addAttribute("editTravelTrip", tempTravelTrip);
 
        return "/editTravelTrip";
    }
 
    @RequestMapping(value="/{tripID}/editTravelTrip", method=RequestMethod.POST)
    public String ediTravelTrip(@PathVariable("tripID") String tripID,
            @Valid @ModelAttribute("editTravelTrip") TravelTrip editTravelTrip,
            BindingResult result, Model model){ 
         
        if (!result.hasErrors()) {
 
            travelTripService.update(Integer.parseInt(tripID), editTravelTrip);
            model.addAttribute("travelTripList", travelTripService.findAll());
            return "redirect:/";
        } else {
            //model.addAttribute("travelTripList", travelTripService.findAll());
            return "editTravelTrip";
 
        }   
    }
 
    @RequestMapping(value="/{tripID}/detailsTravelTrip", method=RequestMethod.GET)
    public String detailsTravelTrip(@PathVariable("tripID") String tripID, Model model){
 
        TravelTrip tempTravelTrip = travelTripService.findById(Integer.parseInt(tripID));
 
        model.addAttribute("detailsTravelTrip", tempTravelTrip);
 
        return "detailsTravelTrip";
    }              
 
    private void createDummyTravelTrips() {
        TravelTrip temp = new TravelTrip();
 
        temp.setCountry("Pakistan");
        temp.setCity("Lahore");
        temp.setFromDate("19/06/2012");
        temp.setToDate("27/06/2012");
        temp.setBusiness(false);
 
        //travelTripDao.register(temp);
        travelTripService.addTravelTrip(temp);
    }
}