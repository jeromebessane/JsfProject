package org.ema;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
public class CityView {
	
	@PersistenceContext
    private EntityManager manager;
	
	public void init(){
		City city = new City();
		city.setName("test");
		city.setCountry("test");
		
		manager.persist(city);
	}
	
	public List<City> getCity(){
		return manager.createQuery("from City", City.class).getResultList();
	}
}
