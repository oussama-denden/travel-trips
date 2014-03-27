package com.tritux.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tritux.domain.TravelTrip;

/**
 * Test case for the travel trip service.
 * 
 * @author Denden-OUSSAMA
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext.xml" })
public class TravelServiceTest {

	/**
	 * inject travel service.
	 */
	@Autowired
	private TravelTripService travelTripService;

	/**
	 * test case for the add trip method.
	 */
	@Test
	public void testAddTravelTrip() {
		TravelTrip trip = createDummyTravelTrips();

		Assert.assertTrue(trip.getId() == 0);

		travelTripService.addTravelTrip(trip);
		Assert.assertTrue(trip.getId() > 0);
		travelTripService.delete(trip.getId());
	}

	/**
	 * test case for the service's find all method.
	 */
	@Test
	public void testFindAll() {
		TravelTrip t1 = createDummyTravelTrips();
		TravelTrip t2 = createDummyTravelTrips();
		TravelTrip t3 = createDummyTravelTrips();

		travelTripService.addTravelTrip(t1);
		travelTripService.addTravelTrip(t2);
		travelTripService.addTravelTrip(t3);

		List<TravelTrip> travelTrips = travelTripService.findAll();
		Assert.assertTrue(travelTrips.size() >= 3);

		travelTripService.delete(t1.getId());
		travelTripService.delete(t2.getId());
		travelTripService.delete(t3.getId());
	}

	/**
	 * test case for the service's findById method.
	 * 
	 */
	@Test
	public void testFindById() {
		TravelTrip trip = createDummyTravelTrips();
		travelTripService.addTravelTrip(trip);

		Assert.assertTrue(trip.getId() > 0);

		TravelTrip tt = travelTripService.findById(trip.getId());
		Assert.assertNotNull(tt);
		Assert.assertTrue(tt.getId() == trip.getId());
		travelTripService.delete(trip.getId());
	}

	/**
	 * test case for the service's delete method.
	 */
	@Test
	public void testDelete() {
		TravelTrip trip = createDummyTravelTrips();
		travelTripService.addTravelTrip(trip);

		Assert.assertTrue(trip.getId() > 0);

		travelTripService.delete(trip.getId());
		TravelTrip tt = travelTripService.findById(trip.getId());
		Assert.assertNull(tt);
	}

	/**
	 * test case for the service's update method.
	 */
	@Test
	public void testUpdate() {
		TravelTrip trip = createDummyTravelTrips();
		travelTripService.addTravelTrip(trip);

		Assert.assertTrue(trip.getId() > 0);

		TravelTrip travelTripTemp = trip;
		travelTripTemp.setCountry("new country");
		travelTripTemp.setCity("new city");
		travelTripTemp.setBusiness(true);

		travelTripService.update(trip.getId(), travelTripTemp);

		trip = travelTripService.findById(trip.getId());

		Assert.assertTrue(trip != null);
		Assert.assertTrue(trip.getId() > 0);

		Assert.assertTrue(trip.getCountry().equals(travelTripTemp.getCountry()));
		Assert.assertTrue(trip.getCity().equals(travelTripTemp.getCity()));
		Assert.assertTrue(trip.isBusiness() == travelTripTemp.isBusiness());
		travelTripService.delete(trip.getId());
	}

	/**
	 * create a dummy travel trip entity.
	 * 
	 * @return {@link TravelTrip}
	 */
	private TravelTrip createDummyTravelTrips() {
		TravelTrip temp = new TravelTrip();

		temp.setCountry("Pakistan");
		temp.setCity("Lahore");
		temp.setFromDate("19/06/2012");
		temp.setToDate("27/06/2012");
		temp.setBusiness(false);

		return temp;
	}

}
