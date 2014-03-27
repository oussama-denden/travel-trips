package com.tritux.service;
import java.util.List;

import com.tritux.domain.TravelTrip;
 
public interface TravelTripService {
 
    public void addTravelTrip(TravelTrip travelTrip);
 
    public List<TravelTrip> findAll();
 
    public TravelTrip findById(int id);
 
    public void delete(int id);
 
    public void update(int id, TravelTrip travelTrip);
 
}