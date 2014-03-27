package com.tritux.repo;

import java.util.List;

import com.tritux.domain.TravelTrip;

/**
 * 
 * TravelTrip DAO Interface.
 * 
 * @author Denden-OUSSAMA
 * 
 */
public interface TravelTripDao {

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
	 * Find trip by type business or leisure.
	 * 
	 * @param typeBusiness
	 *            the type of the trip.
	 * @return return the list of travel trip.
	 */
	public List<TravelTrip> findType(boolean typeBusiness);

	/**
	 * 
	 * find all travel trips.
	 * 
	 * @return a list of all the {@link TravelTrip}.
	 */
	public List<TravelTrip> findAll();

	/**
	 * 
	 * persist a travel trip.
	 * 
	 * @param travelTrip
	 *            trip to add.
	 */
	public void register(TravelTrip travelTrip);

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