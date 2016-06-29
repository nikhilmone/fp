package com.techm.cadt.cache;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAEntityManager<T> {

	private static EntityManagerFactory entityManagerFactory = null;

	public JPAEntityManager() {
	}

	public static void initialize() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "com.techm.cadt.employee.persistence" );
	}

	public T save(T t) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
		return t;
	}
	
	public T query(T t,Long id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.find(t.getClass(),id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return t;
	}
	
	public List<T> queryLast(T t,String table,int maxResults) {

		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery( "SELECT t FROM " + table +"  t ");
		query.setFirstResult(0);
		query.setMaxResults(maxResults);		
		List<T> list = (List<T>)query.getResultList();
		entityManager.close();

		return list;
	}
	
	public List query(String queryString){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery(queryString);		
    	List list = query.getResultList();
    	entityManager.close();
    	return list;
	}

	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
}
