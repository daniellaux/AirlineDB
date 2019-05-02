package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import tables.Airline;

public class AirlineDao implements Dao<Airline> {
	private EntityManagerFactory entityManagerFactory;
	
	public AirlineDao(EntityManagerFactory emfPassed) {
		entityManagerFactory = emfPassed;
	}

	public AirlineDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("oraclePersistence");
	}

	public void addRecord(Airline t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Airline(t.getId(), t.getName(), t.getAlias(), t.getIataCode(), t.getIcaoCode(),
				t.getCallsign(), t.getCountry(), t.getOperationalStatus()));
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void removeRecord(Airline t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Airline airline = entityManager.find(Airline.class, t.getId());
		entityManager.remove(airline);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void updateRecord(Airline t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(new Airline(t.getId(), t.getName(), t.getAlias(), t.getIataCode(), t.getIcaoCode(),
				t.getCallsign(), t.getCountry(), t.getOperationalStatus()));
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	
	@Override
	public Airline getRecordById(Airline t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();		
		Airline airline = entityManager.find(Airline.class, t.getId());
		entityManager.close();
		return airline;
	}
	public List<Airline> getRecordByName(String airlineName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Airline> airlineList = new ArrayList<Airline>();
		TypedQuery<Airline> query =  entityManager.createQuery("select a from Airline a where UPPER(a.name) like '%"+airlineName.toUpperCase()+"%' order by a.id asc", Airline.class);
		airlineList = query.getResultList();
		entityManager.close();
		return airlineList;
	}

	public List<Airline> returnAllRecords() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Airline> airlineList = new ArrayList<Airline>();
		TypedQuery<Airline> query =  entityManager.createQuery("from Airline order by ID asc", Airline.class);
		airlineList = query.getResultList();
		entityManager.close();
		return airlineList;		
	}
	public void closeDao() {	
		entityManagerFactory.close();
		System.out.println("entity manager factory closed.");
	}




}
