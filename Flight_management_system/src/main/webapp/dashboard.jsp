<%@page import="com.dto.Flight"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Flightdao"%>
<%@page import="com.controller.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLIGHT DASHBOARD</title>
</head>
<body>
<%
HttpSession hs=request.getSession();

Admin a=(Admin)hs.getAttribute("Air India");
if(a!=null)
{
   Flightdao fd=new Flightdao();
   List<Flight> f=fd.FinfAll_flight();
%>
<table border="2px solid blue" cellpadding="5px" cellspacing="5px" width="100%">
<tr>
	<th>ID</th>
	<th>fID</th>
	<th>FNAME</th>
	<th>FNUMBER</th>
	<th>F_SOURCE</th>
	<th>F_DESTINATION</th>
	<th>PRICE</th>
	<th>DATE</th>
	<th>UPDATE</th>
	<th>DELETE</th>
	

</tr>
<%
int id=1;
  for(Flight flight:f){
 %>
 <tr>
 	<td><%=id++%></td>
 	<td><%=flight.getFid()%></td>
 	<td><%=flight.getFname()%></td>
 	<td><%=flight.getFnum()%></td>
 	<td><%=flight.getFromdest()%></td>
 	<td><%=flight.getTodest()%></td>
 	<td><%=flight.getPrice()%></td>
 	<td><%=flight.getDate()%></td>
 	 <td><a href="update.jsp?id=<%=flight.getFid()%>"><button>UPDATE</button></a></td>
 	 <td><a href="delete?id=<%=flight.getFid()%>"><button>DELETE</button></a></td>
 	
 </tr>
<% }%>
</table>
<a href="flightdetails.jsp"><button>ADD FLIGHT</button></a>
<a href="logout"> <button>Logout</button> </a>
<%}
 else{
	 response.getWriter().print("<h1 style=\"color: white;\">LOGIN FIRST THEN ENTER</h1>");
	 request.getRequestDispatcher("login.jsp").include(request, response);
	 
 }
 %>

</body>
</html>