<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String hostname= request.getParameter("host");

/**if(hostname == null || "".equals(hostname)){
	out.println("Default ");
	hostname = "172.30.155.13";
}
out.println("hostname = " + hostname);
*/
try{
	Class.forName("org.postgresql.Driver");
	Connection conn = null;
	conn = DriverManager.getConnection("jdbc:postgresql://fp-postgresql:5432/employee","srini", "techm123");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from employee");
	while(rs.next()){
		out.println(rs.getInt(1) + " - " + rs.getString(3));
	}
	conn.close();
}catch(Exception ex){
	out.println(ex.getMessage());
}


%>

</body>
</html>
