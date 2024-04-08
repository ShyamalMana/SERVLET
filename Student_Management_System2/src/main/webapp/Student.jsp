<%@page import="com.dto.Studentdto"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Studentdao"%>
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
Studentdao sd=new Studentdao();
List<Studentdto> listofstudent =sd.findall_students();
%>
<table border="2px solid blue" cellpadding="5px" cellspacing="5px" width="100%">
<tr>
	<th>ID</th>
	<th>SID</th>
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
  for(Studentdto s:listofstudent){
 %>
 <tr>
 	<td><%=id++%></td>
 	<td><%=s.getId()%></td>
 	<td><%=s.getName()%></td>
 	<td><%=s.getEmail()%></td>
 	<td><%=s.getPassword()%></td>
 	<td><%=s.getPhno()%></td>
 	<td><%=s.getGender()%></td>
 	<td><%=s.getAge()%></td>
 	<td><%=s.getDob()%></td>
 	 <td><a href="update.jsp?id=<%=s.getId()%>"><button>UPDATE</button></a></td>
 	 <td><a href="delete?id=<%=s.getId()%>"><button>DELETE</button></a></td>
 	
 </tr>
<% }%>
</table>
<a href="Signup.jsp"><button>ADD STUDENT</button></a>

</body>
</html>