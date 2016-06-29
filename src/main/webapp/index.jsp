<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page import="com.techm.cadt.cache.Employee"%>
<html>
<body>
<h2>View Employee</h2>


<%
     try{
    	 		 
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory( "com.techm.cadt.employee.persistence" );
    			 
    	 EntityManager entityManager = emf.createEntityManager();
    	 entityManager.getTransaction().begin();  
    	 
    	 Query query = entityManager.createQuery( "SELECT t FROM Employee t ");  
    	 List<Employee> list = (List<Employee>)query.getResultList();
    	 for(Employee emp : list){
    		 out.prinltn(emp.toString() + "<BR>");
    	 }
    	 entityManager.close();
    	 
     }catch(Exception ex){
    	 ex.printStackTrace();
     }

%>
<a href="insert.jsp">insert</a>
</body>
</html>
