package com.tritux.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tritux.domain.TravelTrip;
import com.tritux.repo.TravelTripDao;
 
@Service("travelTripService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TravelTripServiceImpl implements TravelTripService{
 
    private TravelTripDao travelTripDao;
 
    @Autowired
    public TravelTripServiceImpl(TravelTripDao travelTripDao){
        this.travelTripDao = travelTripDao;
    }
 
    public TravelTripServiceImpl(){
 
    }
 
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void addTravelTrip(TravelTrip travelTrip) {
        travelTripDao.register(travelTrip);
    }
 
    public List<TravelTrip> findAll(){
        return travelTripDao.findAll();
    }
 
    public TravelTrip findById(int id){
        return travelTripDao.findById(id);
    }
 
    public void delete(int id){
        travelTripDao.delete(id);
    }
 
    public void update(int id, TravelTrip travelTrip){
        travelTripDao.update(id, travelTrip);
    }
}