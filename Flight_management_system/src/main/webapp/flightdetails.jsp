<%@page import="com.controller.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>flight Details</title>
</head>
<body>
<%
HttpSession hs=request.getSession();
 Admin a=(Admin)hs.getAttribute("Air India");
 if(a!=null)
 {

 %>
<form action="signup" method="get">
  <label for="flightName">Flight Name:</label><br>
  <input type="text" id="flightName" name="flightName"><br>
  <label for="flightNumber">Flight Number:</label><br>
  <input type="text" id="flightNumber" name="flightNumber"><br>
  <label for="fromDestination">From:</label><br>
  <input type="text" id="fromDestination" name="fromDestination"><br>
  <label for="toDestination">To:</label><br>
  <input type="text" id="toDestination" name="toDestination"><br>
  <label for="date">Date:</label><br>
  <input type="date" id="date" name="date"><br>
  <label for="price">Price:</label><br>
  <input type="number" id="price" name="price"><br><br>
  <input type="submit" value="Signup">
    <input type="reset" value="cancel">
    <%}
 else{
	 response.getWriter().print("<h1 style=\"color: white;\">LOGIN FIRST THEN ENTER</h1>");
	 request.getRequestDispatcher("login.jsp").include(request, response);
	 
 }
 %>
</form>
</body>
</html>