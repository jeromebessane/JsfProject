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
	//table 10 city in europ
	private String tabCity[][]=	{	{"Paris", "France"},
							{"Londres", "Grande-Bretagne"},
							{"Rome", "Italie"},
							{"Berlin", "Allemagne"},
							{"Madird", "Espagne"},
							{"Bruxelles", "Belgique"},
							{"Cardiff", "Pays de Galles"},
							{"Vienne", "Autriche"},
							{"Budapest", "Hongrie"},
							{"Dublin", "Ireland"}};
	
	//add 2 city in BDD in random
	public void init(){	
		int rand = (int) (Math.random()*9);
		City city = new City(tabCity[rand][0],tabCity[rand][1]);	
		manager.persist(city);
		rand = (int) (Math.random()*9);
		city = new City(tabCity[rand][0],tabCity[rand][1]);
		manager.persist(city);
	}
	
	//return list city 
	public List<City> getCity(){
		return manager.createQuery("from City", City.class).getResultList();
	}
	
	//delete list city
	public void clear(){
		manager.createQuery("delete from City").executeUpdate();
	}
}
