package com.tritux.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tritux.domain.TravelTrip;

/**
 * Bean responsible for persisting travel trip data.
 * 
 * @author Denden-OUSSAMA
 * 
 */
@Repository("travelTripDao")
@Transactional
public class TravelTripDaoImpl implements TravelTripDao {

	/**
	 * 
	 * Entity Manger.
	 */
	private EntityManager em;

	/***
	 * 
	 * get Entity Manager.
	 * 
	 * @return an entity manager.
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * 
	 * injecting an entity manger.
	 * 
	 * @param em
	 *            entity manager to inject.
	 */
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * 
	 * find travel trip by id.
	 * 
	 * @param id
	 *            travel trip id.
	 * @return {@link TravelTrip}.
	 */
	public TravelTrip findById(int id) {
		return em.find(TravelTrip.class, id);
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
		TravelTrip travelTripTemp = findById(id);
		travelTripTemp.setCountry(travelTrip.getCountry());
		travelTripTemp.setCity(travelTrip.getCity());
		travelTripTemp.setFromDate(travelTrip.getFromDate());
		travelTripTemp.setToDate(travelTrip.getToDate());
		travelTripTemp.setBusiness(travelTrip.isBusiness());

		em.persist(travelTripTemp);
	}

	/**
	 * 
	 * delete a trip.
	 * 
	 * @param id
	 *            id of the travel trip to delete.
	 */
	public void delete(int id) {
		TravelTrip travelTripTemp = findById(id);
		em.remove(travelTripTemp);
	}

	/**
	 * 
	 * Find trip by type business or leisure.
	 * 
	 * @param typeBusiness
	 *            the type of the trip.
	 * @return return the list of travel trip.
	 */
	@SuppressWarnings("unchecked")
	public List<TravelTrip> findType(boolean typeBusiness) {
		Query travelTripByType = em
				.createNamedQuery("TravelTrip.findByTripType");
		travelTripByType.setParameter("business", typeBusiness);
		return travelTripByType.getResultList();
	}

	/**
	 * 
	 * find all travel trips.
	 * 
	 * @return a list of all the {@link TravelTrip}.
	 */
	public List<TravelTrip> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TravelTrip> criteria = cb.createQuery(TravelTrip.class);
		Root<TravelTrip> travelTrip = criteria.from(TravelTrip.class);

		criteria.select(travelTrip).orderBy(cb.asc(travelTrip.get("country")));
		return em.createQuery(criteria).getResultList();
	}

	/**
	 * 
	 * persist a travel trip.
	 * 
	 * @param travelTrip
	 *            trip to add.
	 */
	public void register(TravelTrip travelTrip) {
		em.persist(travelTrip);
		return;
	}
}