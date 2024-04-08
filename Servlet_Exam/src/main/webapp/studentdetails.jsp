<%@page import="com.controller.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.controller.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
	padding: 5px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

button {
	padding: 5px 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}

a {
	text-decoration: none;
	color: black;
}
</style>

</head>
<body>
	<% HttpSession hs=request.getSession();
	   Admin admin=(Admin)hs.getAttribute("admin");
	   if(admin!=null) 
	   {
			StudentDao dao=new StudentDao();
	   		List<Student> list=dao.findAllStudentDetails();
	%>

	<table border="1px solid black" cellpadding="5px" cellspacing="5px"
		width="100%">
		<tr>
			<th>S.No</th>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Phone</th>
			<th>Gender</th>
			<th>Age</th>
			<th>DOB</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>


		<% int sid=1;
			   for (Student s:list) { %>

		<tr>
			<td><%=sid++ %></td>
			<td><%=s.getId() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getEmail() %></td>
			<td><%=s.getPassword() %></td>
			<td><%=s.getPhone() %></td>
			<td><%=s.getGender() %></td>
			<td><%=s.getAge() %></td>
			<td><%=s.getDob() %></td>
			<td><a href="update.jsp?id=<%=s.getId() %>"><button>UPDATE</button></a></td>
			<td><a href="delete?id=<%=s.getId() %>"><button>DELETE</button></a></td>

		</tr>
		<% } %>



	</table>
	<br>
	<br>

	<a href="signup.jsp"><button>Add Student</button></a>
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