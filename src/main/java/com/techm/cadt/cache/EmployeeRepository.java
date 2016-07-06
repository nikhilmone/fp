package com.techm.cadt.cache;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

public class EmployeeRepository {

	@PersistenceContext
	private EntityManager em;
	
	public EmployeeRepository(EntityManagerFactory entityManagerFactory){
		em = entityManagerFactory.createEntityManager();
	}	
	
	public List<Employee> findAllOrderedByName() {
		TypedQuery<Employee> query = em.createNamedQuery(Employee.FIND_ALL, Employee.class);
		List<Employee> contacts = query.getResultList();
		return contacts;
	}

	public Employee findById(Long id) {
		return em.find(Employee.class, id);
	}

	public Employee findByEmail(String name) {
		TypedQuery<Employee> query = em.createNamedQuery(Employee.FIND_BY_NAME, Employee.class).setParameter("name",
				name);
		Employee contact = query.getSingleResult();
		return contact;
	}

	public Employee create(Employee contact) throws ConstraintViolationException, ValidationException, Exception {
		System.out.println("ContactRepository.create() - Creating " + contact.getName());
		em.getTransaction().begin();
		em.persist(contact);
		em.flush();
		em.getTransaction().commit();
		System.out.println(contact.getId());
		return contact;
	}

	public Employee update(Employee contact) throws ConstraintViolationException, ValidationException, Exception {
		System.out.println("ContactRepository.update() - Updating " + contact.getName());
		em.merge(contact);
		return contact;
	}

	public Employee delete(Employee contact) throws Exception {
		System.out.println("ContactRepository.delete() - Deleting " + contact.getName());

		if (contact.getId() != 0l) {
			em.remove(em.merge(contact));
		} else {
			System.out.println("ContactRepository.delete() - No ID was found so can't Delete.");
		}

		return contact;
	}

}
