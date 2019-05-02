package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import tables.Airport;

public class AirportDao implements Dao<Airport> {
	private EntityManagerFactory entityManagerFactory;

	public AirportDao(EntityManagerFactory emfPassed) {
		entityManagerFactory = emfPassed;
	}

	public AirportDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("oraclePersistence");
	}

	public void addRecord(Airport t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Airport(t.getAirportId(), t.getAirportName(), t.getAirportCity(),
				t.getAirportCountry(), t.getAirportIata(), t.getAirportIcao(), t.getAirportLatitude(),
				t.getAirportLongitude(), t.getAirportAltitude(), t.getAirportTimezone(), t.getAirportDst(),
				t.getAirportDbTimezone(), t.getAirportType(), t.getAirportSource()));
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void removeRecord(Airport t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Airport airport = entityManager.find(Airport.class, t.getAirportId());
		entityManager.remove(airport);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void updateRecord(Airport t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(new Airport(t.getAirportId(), t.getAirportName(), t.getAirportCity(), t.getAirportCountry(),
				t.getAirportIata(), t.getAirportIcao(), t.getAirportLatitude(), t.getAirportLongitude(),
				t.getAirportAltitude(), t.getAirportTimezone(), t.getAirportDst(), t.getAirportDbTimezone(),
				t.getAirportType(), t.getAirportSource()));
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Airport getRecordById(Airport t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Airport airport = entityManager.find(Airport.class, t.getAirportId());
		entityManager.close();
		return airport;
	}

	public List<Airport> getRecordByName(String airportName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Airport> airportList = new ArrayList<Airport>();
		TypedQuery<Airport> query = entityManager.createQuery("select a from Airport a where UPPER(a.name) like '%"
				+ airportName.toUpperCase() + "%' order by a.id asc", Airport.class);
		airportList = query.getResultList();
		entityManager.close();
		return airportList;
	}

	public List<Airport> returnAllRecords() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Airport> airportList = new ArrayList<Airport>();
		TypedQuery<Airport> query = entityManager.createQuery("from Airport order by ID asc", Airport.class);
		airportList = query.getResultList();
		entityManager.close();
		return airportList;
	}

	public void closeDao() {
		entityManagerFactory.close();
		System.out.println("entity manager factory closed.");
	}

}
