<%@page import="com.controller.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP FORM</title>
<style type="text/css">
/* Style for the heading */
h1 {
  font-family: Arial, sans-serif;
  color: #333;
  text-align: center;
  margin-top: 50px;
  font-size: 28px;
  text-transform: uppercase;
}

/* Style for the form */
form {
  width: 300px;
  margin: 0 auto;
  font-family: Arial, sans-serif;
  animation: fadeIn 1s ease-in-out;
}

/* Style for input fields */
input[type="text"],
input[type="email"],
input[type="password"],
input[type="tel"],
input[type="date"] {
  width: calc(100% - 22px);
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  animation: slideIn 1s ease-in-out;
}

/* Style for radio buttons */
input[type="radio"] {
  margin-right: 5px;
}

/* Style for submit and reset buttons */
input[type="submit"],
input[type="reset"] {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 20px;
  transition: background-color 0.3s ease-in-out;
  animation: slideIn 1s ease-in-out;
}

input[type="submit"]:hover,
input[type="reset"]:hover {
  background-color: #0056b3;
}

/* Keyframe animations */
@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

@keyframes slideIn {
  from {
    transform: translateY(-20px);
    opacity: 0;
  }
  to {
    transform: translateY(0);
    opacity: 1;
  }
}

</style>
</head>
<body>
<%
HttpSession hs=request.getSession();
 Admin a=(Admin)hs.getAttribute("admin");
 if(a!=null)
 {

 %>
<h1>EMPLOYEE Sign_up Page</h1>
	<form action="signup">
		name:<input type="text" name="name"><br>
		<br> email:<input type="email" name="email"><br>
		<br> password:<input type="password" name="pass"><br>
		<br> phone:<input type="tel" name="number"><br>
		<br> <label>Gender:</label> <input type="radio" name="gen"
			value="Male">Male <input type="radio" name="gen"
			value="Female">Female <input type="radio" name="gen"
			value="Others">Others<br> age:<input type="text"
			name="age"><br>
		<br> DOB:<input type="date" name="dob"><br>
		<br> <input type="submit" value="submit"> 
		
		<input type="reset" value="cancel">
	</form>
	<%}
 else{
	 response.getWriter().print("<h1 style=\"color: white;\">LOGIN FIRST THEN ENTER</h1>");
	 request.getRequestDispatcher("login.jsp").include(request, response);
	 
 }
 %>
</body>
</html>