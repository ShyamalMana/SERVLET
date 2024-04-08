<%@page import="com.controller.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.controller.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE STUDENT DETAILS...</title>
<style>
/* Internal CSS styles */
fieldset {
	width: 300px;
	margin: auto;
	border: 1px solid #ccc;
	padding: 20px;
	border-radius: 5px;
}

legend {
	font-weight: bold;
	color: #333;
}

label {
	display: inline-block;
	width: 100px;
	text-align: right;
	margin-right: 10px;
}

input[type="text"], input[type="email"], input[type="password"], input[type="tel"],
	input[type="number"], input[type="date"] {
	width: 200px;
	padding: 5px;
	margin-bottom: 10px;
	border-radius: 3px;
	border: 1px solid #ccc;
}

input[type="submit"], input[type="reset"] {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	cursor: pointer;
	border-radius: 3px;
}

input[type="submit"]:hover, input[type="reset"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<% HttpSession hs=request.getSession();
	   Admin admin=(Admin)hs.getAttribute("admin");
	   if(admin!=null) {
			int id=Integer.parseInt(request.getParameter("id"));
	   		StudentDao dao=new StudentDao();
	   		Student s=dao.findStudentById(id);
	%>
	<fieldset>
		<legend>Update Record</legend>
		<form action="update">
			<label>Id:</label> <input type="text" name="id"
				value="<%=s.getId() %>" readonly="readonly"><br>
			<br> <label>Username:</label> <input type="text" name="name"
				value="<%=s.getName() %>"><br>
			<br> <label>Email:</label> <input type="email" name="email"
				value="<%=s.getEmail() %>"><br>
			<br> <label>Password:</label> <input type="password" name="pass"
				value="<%=s.getPassword() %>"><br>
			<br> <label>Phone:</label> <input type="tel" name="phone"
				value="<%=s.getPhone() %>"><br>
			<br> <label>Gender:</label> <input type="radio" name="gen"
				value="Male">Male <input type="radio" name="gen"
				value="Female">Female <input type="radio" name="gen"
				value="Others">Others<br>
			<br> <label>Age:</label> <input type="number" name="age"
				value="<%=s.getAge() %>"><br>
			<br> <label>DOB:</label> <input type="date" name="dob"
				value="<%=s.getDob() %>"><br>
			<br> <input type="submit" value="Update"> <input
				type="reset" value="Cancel">
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