<%@page import="com.dto.Studentdto"%>
<%@page import="com.dao.Studentdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
int id=Integer.parseInt(request.getParameter("id"));
Studentdao sd=new Studentdao();
Studentdto s=sd.findStudentbyId(id);
%>

<h1>UPDATE THE RECORD</h1>
<form action="update">
ID:<input type="text" name="id" value="<%=s.getId()%>" readonly="readonly"><br><br>
name:<input type="text" name="name"value="<%=s.getName()%>"><br><br>
email:<input type="email"name="email"value="<%=s.getEmail()%>"><br><br>
password:<input type="text" name="pass" value="<%=s.getPassword()%>"><br><br>
phone:<input type="tel" name="number"value="<%=s.getPhno()%>"><br><br>
<input type="radio"value="male" name="gen">Male<br><br>
<input type="radio"value="female" name="gen">Fe-Male<br><br>
age:<input type="text" name="age"value="<%=s.getAge()%>"><br><br>
DOB:<input type="date" name="dob"value="<%=s.getDob()%>"><br><br>
<input type="submit" value="update">
<input type="reset" value="cancel">
</form>
</body>
</html>