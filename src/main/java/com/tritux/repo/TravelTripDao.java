package com.tritux.repo;
 
import java.util.List;

import com.tritux.domain.TravelTrip;
 
public interface TravelTripDao
{
    public TravelTrip findById(int id);
 
    public List<TravelTrip> findType(boolean typeBusiness);
 
    public List<TravelTrip> findAll();
 
    public void register(TravelTrip travelTrip);
 
    public void delete(int id);
 
    public void update(int id, TravelTrip travelTrip);
}