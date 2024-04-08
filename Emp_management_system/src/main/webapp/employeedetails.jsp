<%@page import="com.controller.Admin"%>
<%@page import="com.dto.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Employee_dao"%>
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
HttpSession hs=request.getSession();

Admin a=(Admin)hs.getAttribute("admin");
if(a!=null)
{
   Employee_dao ed=new Employee_dao();
  List<Employee> listofemployee =ed.FindALL_Employee();
%>
<table border="2px solid blue" cellpadding="5px" cellspacing="5px" width="100%">
<tr>
	<th>ID</th>
	<th>EID</th>
	<th>NAME</th>
	<th>EMAIL</th>
	<th>PASSWORD</th>
	<th>PHONE NUMBER</th>
	<th>GENDER</th>
	<th>AGE</th>
	<th>DOB</th>
	<th>UPDATE</th>
	<th>DELETE</th>
	

</tr>
<%
int id=1;
  for(Employee e:listofemployee){
 %>
 <tr>
 	<td><%=id++%></td>
 	<td><%=e.getId()%></td>
 	<td><%=e.getName()%></td>
 	<td><%=e.getEmail()%></td>
 	<td><%=e.getPassword()%></td>
 	<td><%=e.getPhone()%></td>
 	<td><%=e.getGender()%></td>
 	<td><%=e.getAge()%></td>
 	<td><%=e.getDate()%></td>
 	 <td><a href="update.jsp?id=<%=e.getId()%>"><button>UPDATE</button></a></td>
 	 <td><a href="delete?id=<%=e.getId()%>"><button>DELETE</button></a></td>
 	
 </tr>
<% }%>
</table>
<a href="signup.jsp"><button>ADD STUDENT</button></a>
<a href="logout"> <button>Logout</button> </a>
<%}
 else{
	 response.getWriter().print("<h1 style=\"color: white;\">LOGIN FIRST THEN ENTER</h1>");
	 request.getRequestDispatcher("login.jsp").include(request, response);
	 
 }
 %>
</body>
</html>