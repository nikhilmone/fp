<%@page import="com.techm.cadt.cache.MenuItem"%>
<%@page import="com.techm.cadt.cache.MenuItemRepository"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>FP Menu</title>
</head>
<body>
	<h2>FP Menu</h2>
	<%
		try {
			MenuItemRepository repo = (MenuItemRepository)getServletContext().getAttribute("menuItemRepo");
			List<MenuItem> list = repo.findAll();
			for (MenuItem menu : list) {
				out.println(menu.toString() + "<BR>");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	%>
	<a href="insert.jsp">insert</a>
</body>
</html>
