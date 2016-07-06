package com.techm.cadt.cache;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

public class MenuItemRepository {

	@PersistenceContext
	private EntityManager em;
	
	public MenuItemRepository(EntityManagerFactory entityManagerFactory){
		em = entityManagerFactory.createEntityManager();
	}	
	
	public List<MenuItem> findAll() {
		TypedQuery<MenuItem> query = em.createNamedQuery(MenuItem.FIND_ALL, MenuItem.class);
		List<MenuItem> contacts = query.getResultList();
		return contacts;
	}

	public MenuItem findById(Long id) {
		return em.find(MenuItem.class, id);
	}

	public MenuItem findByMenuName(String name) {
		TypedQuery<MenuItem> query = em.createNamedQuery(MenuItem.FIND_BY_NAME, MenuItem.class).setParameter("name",
				name);
		MenuItem contact = query.getSingleResult();
		return contact;
	}

	public MenuItem create(MenuItem menu) throws ConstraintViolationException, ValidationException, Exception {
		System.out.println("ContactRepository.create() - Creating " + menu.getItemName());
		em.getTransaction().begin();
		em.persist(menu);
		em.flush();
		em.getTransaction().commit();
		System.out.println(menu.getId());
		return menu;
	}

	public MenuItem update(MenuItem menu) throws ConstraintViolationException, ValidationException, Exception {
		System.out.println("ContactRepository.update() - Updating " + menu.getItemName());
		em.merge(menu);
		return menu;
	}

	public MenuItem delete(MenuItem menu) throws Exception {
		System.out.println("ContactRepository.delete() - Deleting " + menu.getItemName());

		if (menu.getId() != 0l) {
			em.remove(em.merge(menu));
		} else {
			System.out.println("ContactRepository.delete() - No ID was found so can't Delete.");
		}

		return menu;
	}

}
