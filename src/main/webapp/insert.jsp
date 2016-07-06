<%@page import="com.techm.cadt.cache.EmployeeRepository"%>
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
    	 long id = System.currentTimeMillis();
    	 //newEmp.setId(id);
    	 newEmp.setName("FName-" + id);
    	 newEmp.setSalary(5000);
    	 
    	 EmployeeRepository repo = (EmployeeRepository)getServletContext().getAttribute("employeeRepo");
    	 repo.create(newEmp);
    	  
     }catch(Exception ex){
    	 ex.printStackTrace();
     }

%>
<a href="index.jsp">view</a>
</body>
</html>
