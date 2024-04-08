<%@page import="com.dto.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Employee_Signup_dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Employee_Signup_dao sd=new Employee_Signup_dao() ;
List<Employee> listofemployee =sd.findall_employee();
%>
<table border="2px solid blue" cellpadding="5px" cellspacing="5px" width="100%">
<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>EMAIL</th>
	<th>PASSWORD</th>
	<th>PHONE NUMBER</th>
	<th>GENDER</th>
	<th>AGE</th>
	<th>DOB</th>

</tr>
<%
  for(Employee s:listofemployee){
 %>
 <tr>
 	<td><%=s.getId()%></td>
 	<td><%=s.getName()%></td>
 	<td><%=s.getEmail()%></td>
 	<td><%=s.getPassword()%></td>
 	<td><%=s.getPhno()%></td>
 	<td><%=s.getGender()%></td>
 	<td><%=s.getAge()%></td>
 	<td><%=s.getDob()%></td>
 	
 </tr>
<% }%>
</table>
</body>
</html>