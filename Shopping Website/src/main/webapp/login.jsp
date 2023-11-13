<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- 
	Name: Aran Adham Ali
	Matrix Code: QU202SECJ005
	-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div id="container">
		<h1>Welcome to QIU Online Book Store</h1>
		<form name="login" action="LoginController" method="post" id="form">

			<label>User Name:</label> <input type="text" name="username" required />
			
			<label>Password:</label> <input type="password" name="password" required />
			
			<input type="submit" value="Login" />
		</form>
		
		
		<div id="links">
				<a href="register.jsp">New Here! Register</a>
				<a href="IndexController">Index</a>
		</div>
	</div>
</body>
</html>