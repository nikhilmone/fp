<%@page import="com.techm.cadt.cache.EmployeeRepository"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page import="com.techm.cadt.cache.Employee"%>
<html>
<head>
<title>View</title>
</head>
<body>
	<h2>View Employee</h2>
	<%
		try {
			EmployeeRepository repo = (EmployeeRepository)getServletContext().getAttribute("employeeRepo");
			List<Employee> list = repo.findAllOrderedByName();
			for (Employee emp : list) {
				out.println(emp.toString() + "<BR>");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	%>
	<a href="insert.jsp">insert</a>
</body>
</html>
