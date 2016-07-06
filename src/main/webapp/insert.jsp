<%@page import="com.techm.cadt.cache.MenuItemRepository"%>
<%@page import="com.techm.cadt.cache.MenuItem"%>
<html>
<body>
<h2>Insert Menu Item</h2>

<!-- http://www.journaldev.com/2980/hibernate-ehcache-second-level-caching-example-tutorial -->

<%
     try{

    	 MenuItem item = new MenuItem();
    	 item.setCost(1000);
    	 item.setDescription("Auto Generate");
    	 item.setIsVeg("True");
    	 item.setItemName("Random Item generate");
    	 
    	 MenuItemRepository repo = (MenuItemRepository)getServletContext().getAttribute("menuItemRepo");
    	 repo.create(item);
    	  
     }catch(Exception ex){
    	 ex.printStackTrace();
     }

%>
<a href="index.jsp">view</a>
</body>
</html>
