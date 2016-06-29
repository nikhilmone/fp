<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page import="com.techm.cadt.cache.Employee"%>
<html>
<body>
<h2>Insert Employee</h2>

<!-- http://www.journaldev.com/2980/hibernate-ehcache-second-level-caching-example-tutorial -->

<%
     try{

    	 Employee newEmp  = new Employee();    	 
    	 newEmp.setName("" + System.currentTimeMillis());
    	 newEmp.setSalary(5000);
         
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory( "com.techm.cadt.employee.persistence" );
		 
    	 EntityManager entityManager = emf.createEntityManager();
    	 entityManager.getTransaction().begin();  
    	 
    	 entityManager.persist(newEmp);
    	 
    	 Query query = entityManager.createQuery( "SELECT t FROM Employee t ");  
    	 List<Employee> list = (List<Employee>)query.getResultList();
    	 for(Employee emp : list){
    		 out.println(emp.toString() + "<BR>");
    	 }
    	 entityManager.getTransaction().commit();
    	 entityManager.close();
    	 
     }catch(Exception ex){
    	 
     }

%>
<a href="view.jsp">view</a>
</body>
</html>
