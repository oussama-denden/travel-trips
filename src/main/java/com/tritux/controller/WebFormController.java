package com.tritux.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tritux.domain.TravelTrip;
import com.tritux.service.TravelTripService;

/**
 * Web controller responsible of intercepting incoming requests and sending back
 * responses.
 * 
 * @author Denden-OUSSAMA
 * 
 */
@Controller
public class WebFormController {

	/**
	 * Travel Trip service responsible for business operations.
	 */
	private TravelTripService travelTripService;

	/**
	 * constructor injection of the travel service.
	 * 
	 * @param travelTripService
	 *            trip travel service to be injected.
	 */
	@Autowired
	public WebFormController(TravelTripService travelTripService) {
		this.travelTripService = travelTripService;
	}

	/**
	 * fetch all travels trips and show them.
	 * 
	 * @param model
	 *            model.
	 * @return page name.
	 */
	@RequestMapping(value = "/myTravels", method = RequestMethod.GET)
	public String displaySortedTravelTrips(Model model) {
		model.addAttribute("travelTripList", travelTripService.findAll());
		return "index";
	}

	/**
	 * fetch all travels trips and show them.
	 * 
	 * @param model
	 *            model.
	 * @return page name.
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> exportTravelTrips(Model model) {
		List<TravelTrip> travelTrips = travelTripService.findAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (travelTrips == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NO_CONTENT);
		}
		Logger.getLogger(WebFormController.class.toString()).log(Level.INFO,
				"Exporting " + travelTrips.size() + " travel trips ");
		return new ResponseEntity<String>(TravelTrip.toJsonArray(travelTrips),
				headers, HttpStatus.OK);
	}

	/**
	 * show a form to add a new trip.
	 * 
	 * @param model
	 *            model.
	 * @return the add travel trip page.
	 */
	@RequestMapping(value = "/addTravelTripForm", method = RequestMethod.GET)
	public String addTravelTripForm(Model model) {
		model.addAttribute("newTravelTrip", new TravelTrip());
		return "addTravelTrip";
	}

	/**
	 * add a new travel trip.
	 * 
	 * @param newTravelTrip
	 *            travel trip retreived from the request.
	 * @param result
	 *            result.
	 * @param model
	 *            model.
	 * @return forward to the home page if every thing is ok else redirect to
	 *         the same page.
	 */
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

	/**
	 * delete a travel trip.
	 * 
	 * @param tripID
	 *            the id of the travel trip to be deleted.
	 * @param model
	 *            model.
	 * @return redirect to the home page.
	 */
	@RequestMapping(value = "/{tripID}/deleteTravelTrip", method = RequestMethod.GET)
	public String deleteTravelTrip(@PathVariable("tripID") String tripID,
			Model model) {

		travelTripService.delete(Integer.parseInt(tripID));
		model.addAttribute("travelTripList", travelTripService.findAll());
		return "redirect:/";
	}

	/**
	 * edit a travel trip.
	 * 
	 * @param tripID
	 *            id of the trip to be deleted.
	 * @param model
	 *            model.
	 * @return if trip doesn't exist return to index else open edit interface.
	 */
	@RequestMapping(value = "/{tripID}/editTravelTripForm", method = RequestMethod.GET)
	public String ediTravelTripForm(@PathVariable("tripID") String tripID,
			Model model) {

		TravelTrip tempTravelTrip = travelTripService.findById(Integer
				.parseInt(tripID));

		if (tempTravelTrip == null) {
			return "index";
		}

		model.addAttribute("editTravelTrip", tempTravelTrip);

		return "/editTravelTrip";
	}

	/**
	 * 
	 * update the travel trip.
	 * 
	 * @param tripID
	 *            the id of the travel trip to be updated.
	 * @param editTravelTrip
	 *            contain the value that will be used to update the travel trip.
	 * @param result
	 *            result.
	 * @param model
	 *            model.
	 * @return in case of error return stay in the same page. else return to
	 *         home page.
	 */
	@RequestMapping(value = "/{tripID}/editTravelTrip", method = RequestMethod.POST)
	public String ediTravelTrip(@PathVariable("tripID") String tripID,
			@Valid @ModelAttribute("editTravelTrip") TravelTrip editTravelTrip,
			BindingResult result, Model model) {

		if (!result.hasErrors()) {

			travelTripService.update(Integer.parseInt(tripID), editTravelTrip);
			model.addAttribute("travelTripList", travelTripService.findAll());
			return "redirect:/";
		} else {
			// model.addAttribute("travelTripList",
			// travelTripService.findAll());
			return "editTravelTrip";

		}
	}

	/**
	 * check the detail of a travel trip.
	 * 
	 * @param tripID
	 *            the id of trip.
	 * @param model
	 *            model.
	 * @return open the trip detail page.
	 */
	@RequestMapping(value = "/{tripID}/detailsTravelTrip", method = RequestMethod.GET)
	public String detailsTravelTrip(@PathVariable("tripID") String tripID,
			Model model) {

		TravelTrip tempTravelTrip = travelTripService.findById(Integer
				.parseInt(tripID));

		model.addAttribute("detailsTravelTrip", tempTravelTrip);

		return "detailsTravelTrip";
	}
}