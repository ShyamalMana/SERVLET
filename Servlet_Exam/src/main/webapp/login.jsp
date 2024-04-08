<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<style>
  body {
    background-color: #f0f2f5;
    font-family: Arial, sans-serif;
  }

  fieldset {
    width: 350px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  }

  legend {
    font-size: 24px;
    font-weight: bold;
    color: #1877f2;
    margin-bottom: 20px;
  }

  label {
    display: block;
    font-size: 16px;
    font-weight: bold;
    color: #333;
    margin-bottom: 5px;
  }

  input[type="text"],
  input[type="password"] {
    width: calc(100% - 10px);
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
  }

  input[type="submit"],
  input[type="reset"] {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    font-weight: bold;
    color: #fff;
    background-color: #1877f2;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }

  input[type="submit"]:hover,
  input[type="reset"]:hover {
    background-color: #0e63b6;
  }

  input[type="reset"] {
    margin-top: 10px;
    background-color: #e4e6eb;
    color: #333;
  }

  input[type="reset"]:hover {
    background-color: #dcdfe3;
  }
</style>
</head>
<body>

	<fieldset>
		<legend>Login</legend>
		<form action="login">
			<label>Username:</label><input type="text" name="name">
			<label>Password:</label><input type="password" name="pass">
			<input type="submit" value="Login">
			<input type="reset" value="Cancel">
		</form>
	</fieldset>

</body>
</html>