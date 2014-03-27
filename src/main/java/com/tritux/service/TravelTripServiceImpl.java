package com.tritux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tritux.domain.TravelTrip;
import com.tritux.repo.TravelTripDao;

/**
 * 
 * 
 * @author Denden-OUSSAMA
 * 
 */
@Service("travelTripService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TravelTripServiceImpl implements TravelTripService {

	/**
	 * 
	 * Travel trip Data Access Object.
	 */
	private TravelTripDao travelTripDao;

	/**
	 * 
	 * Constructor wiring of the travelTripDao.
	 * 
	 * @param travelTripDao
	 *            inject TravelTripDao.
	 */
	@Autowired
	public TravelTripServiceImpl(TravelTripDao travelTripDao) {
		this.travelTripDao = travelTripDao;
	}

	/**
	 * 
	 * empty constructor.
	 * 
	 */
	public TravelTripServiceImpl() {

	}

	/**
	 * 
	 * add travel trip.
	 * 
	 * @param travelTrip
	 *            trip to add.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void addTravelTrip(TravelTrip travelTrip) {
		travelTripDao.register(travelTrip);
	}

	/**
	 * 
	 * find all travel trips.
	 * 
	 * @return a list of all the {@link TravelTrip}.
	 */
	public List<TravelTrip> findAll() {
		return travelTripDao.findAll();
	}

	/**
	 * 
	 * find travel trip by id.
	 * 
	 * @param id
	 *            travel trip id.
	 * 
	 * @return {@link TravelTrip}.
	 */
	public TravelTrip findById(int id) {
		return travelTripDao.findById(id);
	}

	/**
	 * 
	 * delete a trip.
	 * 
	 * @param id
	 *            id of the travel trip to delete.
	 */
	public void delete(int id) {
		travelTripDao.delete(id);
	}

	/**
	 * 
	 * update a trip.
	 * 
	 * @param id
	 *            id of the travel trip to update.
	 * @param travelTrip
	 *            travel trip to update.
	 */
	public void update(int id, TravelTrip travelTrip) {
		travelTripDao.update(id, travelTrip);
	}
}