<%@page import="com.controller.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGN-UP FORM</title>
<style>
        /* Internal CSS styles */
        fieldset {
            width: 500px;
            margin: auto;
        }
        legend {
            font-weight: bold;
        }
        label {
            display: inline-block;
            width: 100px;
            text-align: right;
            margin-right: 10px;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="tel"],
        input[type="number"],
        input[type="date"] {
            width: 200px;
            padding: 5px;
            margin-bottom: 10px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"],
        input[type="reset"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #0056b3;
        }
</style>

</head>
<body>
   <% HttpSession hs=request.getSession();
	   Admin admin=(Admin)hs.getAttribute("admin");
	   if(admin!=null) {
	%>
	<fieldset>
		<legend>Sign_up</legend>

		<form action="signup">
			<label>User_name:</label>
			<input type="text" name="name"><br><br>
			<label>Email:</label>
			<input type="email" name="email"><br><br>
			<label>Password:</label>
			<input type="password" name="pass"><br><br>
			<label>Phone:</label>
			<input type="tel" name="phone"><br><br>
			<label>Gender:</label>
			<input type="radio" name="gen" value="Male">Male
			<input type="radio" name="gen" value="Female">Female
			<input type="radio" name="gen" value="Others">Others<br><br>
			<label>Age:</label>
			<input type="number" name="age"><br><br>
			<label>DOB:</label>
			<input type="date" name="dob"><br><br>
			<input type="submit" value="Signup">
			<input type="reset" value="Cancel">
		</form>
	</fieldset><br><br>
	<a href="logout"><button>Logout</button></a>
	<% } else {
		response.getWriter().print("<h1>Login First</h1>");
		request.getRequestDispatcher("login.html").include(request, response);
	}
	%>

</body>
</html>