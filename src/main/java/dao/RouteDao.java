package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import tables.Route;

public class RouteDao implements Dao<Route> {
	private EntityManagerFactory entityManagerFactory;

	public RouteDao(EntityManagerFactory emfPassed) {
		entityManagerFactory = emfPassed;
	}

	public RouteDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("oraclePersistence");
	}

	public void addRecord(Route t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Route(t.getAirlineIata(), t.getAirlineId(), t.getSourceAirportIata(),
				t.getSourceAirportId(), t.getDestinationAirportIata(), t.getDestinationAirportId(),
				t.getRouteCodeshare(), t.getRouteStops(), t.getRoutePlaneType()));
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void removeRecord(Route t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Route route = entityManager.find(Route.class, t.getRouteId());
		entityManager.remove(route);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void updateRecord(Route t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(new Route(t.getAirlineIata(), t.getAirlineId(), t.getSourceAirportIata(),
				t.getSourceAirportId(), t.getDestinationAirportIata(), t.getDestinationAirportId(),
				t.getRouteCodeshare(), t.getRouteStops(), t.getRoutePlaneType()));
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Route getRecordById(Route t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Route route = entityManager.find(Route.class, t.getRouteId());
		entityManager.close();
		return route;
	}
	
	@Override
	public List<Route> getRecordByName(String airportIata) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Route> routeList = new ArrayList<Route>();
		TypedQuery<Route> query = entityManager.createQuery("from Route r where UPPER(r.soureAirportIata) like '%"
				+ airportIata.toUpperCase() + "%' order by r.routeId asc", Route.class);
		routeList = query.getResultList();
		entityManager.close();
		return routeList;
	}

	public List<Route> returnAllRecords() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Route> routeList = new ArrayList<Route>();
		TypedQuery<Route> query = entityManager.createQuery("from Route order by routeId asc", Route.class);
		routeList = query.getResultList();
		entityManager.close();
		return routeList;
	}

	public void closeDao() {
		entityManagerFactory.close();
		System.out.println("entity manager factory closed.");
	}

}
