<%@page import="com.dto.Flight"%>
<%@page import="com.dao.Flightdao"%>
<%@page import="com.controller.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Flight</title>
</head>
<body>
<% HttpSession hs=request.getSession();
	   Admin admin=(Admin)hs.getAttribute("Air India");
	   if(admin!=null) {
			int id=Integer.parseInt(request.getParameter("id"));
	   		Flightdao fd=new Flightdao();
	   	 Flight	f=fd.findById(id);
	   		
	%>
	<fieldset>
		<legend>Update Record</legend>
		<form action="update_x">
			<label>Id:</label> <input type="text" name="id"
				value="<%=f.getFid() %>" readonly="readonly"><br>
			<br> <label>FlightName:</label> <input type="text" name="name"
				value="<%=f.getFname() %>"><br>
				<br> <label>flightnumber:</label> <input type="text" name="fn"
				value="<%=f.getFnum()%>"><br>
				<br> <label>FROM PLACE:</label> <input type="text" name="fp"
				value="<%=f.getFromdest()%>"><br>
				<br> <label>DESTINATION PLACE:</label> <input type="text" name="dp"
				value="<%=f.getTodest()%>"><br>
			<br> <label>DATE:</label> <input type="date" name="dob"
				value="<%=f.getDate()%>"><br>
				<br> <label>price:</label> <input type="number" name="price"
				value="<%=f.getPrice()%>"><br>
			<br> <input type="submit" value="Update"> 
			<input type="reset" value="Cancel">
		</form> 
	</fieldset>
	<br>
	<br>
	<a href="logout"><button>Logout</button></a>
	<% } else {
		response.getWriter().print("<h1>Login First</h1>");
		request.getRequestDispatcher("login.html").include(request, response);
	}	
	%>
</body>
</html>