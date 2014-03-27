package com.tritux.service;

import java.util.List;

import com.tritux.domain.TravelTrip;

/**
 * 
 * TravelTrip Service Interface.
 * 
 * @author Denden-OUSSAMA
 * 
 */
public interface TravelTripService {

	/**
	 * 
	 * add travel trip.
	 * 
	 * @param travelTrip
	 *            trip to add.
	 */
	public void addTravelTrip(TravelTrip travelTrip);

	/**
	 * 
	 * find all travel trips.
	 * 
	 * @return a list of all the {@link TravelTrip}.
	 */
	public List<TravelTrip> findAll();

	/**
	 * 
	 * find travel trip by id.
	 * 
	 * @param id
	 *            travel trip id.
	 * @return {@link TravelTrip}.
	 */
	public TravelTrip findById(int id);

	/**
	 * 
	 * delete a trip.
	 * 
	 * @param id
	 *            id of the travel trip to delete.
	 */
	public void delete(int id);

	/**
	 * 
	 * update a trip.
	 * 
	 * @param id
	 *            id of the travel trip to update.
	 * @param travelTrip
	 *            travel trip to update.
	 */
	public void update(int id, TravelTrip travelTrip);

}