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
 
@Repository("travelTripDao")
@Transactional
public class TravelTripDaoImpl  implements TravelTripDao {
 
    private EntityManager em;
 
    public EntityManager getEm() {
        return em;
    }
 
    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }   
 
    public TravelTrip findById(int id){
        return em.find(TravelTrip.class, id);
    }
 
    public void update(int id, TravelTrip travelTrip){
        TravelTrip travelTripTemp = findById(id);       
        travelTripTemp.setCountry(travelTrip.getCountry());
        travelTripTemp.setCity(travelTrip.getCity());
        travelTripTemp.setFromDate(travelTrip.getFromDate());
        travelTripTemp.setToDate(travelTrip.getToDate());
        travelTripTemp.setBusiness(travelTrip.isBusiness());
 
        em.persist(travelTripTemp);
    }
 
    public void delete(int id){
        TravelTrip travelTripTemp = findById(id);       
        em.remove(travelTripTemp);
    }
 
    public List<TravelTrip> findType(boolean typeBusiness){
        Query travelTripByType = em.createNamedQuery("TravelTrip.findByTripType");
        travelTripByType.setParameter("business", typeBusiness);        
        return travelTripByType.getResultList();
    }
 
    public List<TravelTrip> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TravelTrip> criteria = cb.createQuery(TravelTrip.class);
        Root<TravelTrip> travelTrip = criteria.from(TravelTrip.class);
 
        criteria.select(travelTrip).orderBy(cb.asc(travelTrip.get("country")));
        return em.createQuery(criteria).getResultList();
    }
 
    public void register(TravelTrip travelTrip){        
        em.persist(travelTrip);
        return;         
    }
}