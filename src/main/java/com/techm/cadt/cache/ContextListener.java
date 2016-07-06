package com.techm.cadt.cache;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		try {
			MenuItemRepository menuItemRepo = new MenuItemRepository(emf);
			context.setAttribute("menuItemRepo", menuItemRepo);
		} catch (Exception ex) {
			System.out.println("Couldn’t create menu repository database bean: " + ex.getMessage());
		}
	}
	
	
	public void contextDestroyed(ServletContextEvent event) {
		
	}
}