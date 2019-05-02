package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import tables.Plane;

public class PlaneDao implements Dao<Plane> {
	private EntityManagerFactory entityManagerFactory;

	public PlaneDao(EntityManagerFactory emfPassed) {
		entityManagerFactory = emfPassed;
	}

	public PlaneDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("oraclePersistence");
	}

	public void addRecord(Plane t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Plane(t.getPlaneName(), t.getPlaneIata(), t.getPlaneIcao()));
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void removeRecord(Plane t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Plane plane = entityManager.find(Plane.class, t.getPlaneId());
		entityManager.remove(plane);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void updateRecord(Plane t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(new Plane(t.getPlaneName(), t.getPlaneIata(), t.getPlaneIcao()));;
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Plane getRecordById(Plane t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Plane plane = entityManager.find(Plane.class, t.getPlaneId());
		entityManager.close();
		return plane;
	}

	public List<Plane> getRecordByName(String planeName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Plane> planeList = new ArrayList<Plane>();
		TypedQuery<Plane> query = entityManager.createQuery("from Plane p where UPPER(p.name) like '%"
				+ planeName.toUpperCase() + "%' order by p.id asc", Plane.class);
		planeList = query.getResultList();
		entityManager.close();
		return planeList;
	}

	public List<Plane> returnAllRecords() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Plane> planeList = new ArrayList<Plane>();
		TypedQuery<Plane> query = entityManager.createQuery("from Plane order by ID asc", Plane.class);
		planeList = query.getResultList();
		entityManager.close();
		return planeList;
	}

	public void closeDao() {
		entityManagerFactory.close();
		System.out.println("entity manager factory closed.");
	}

}
