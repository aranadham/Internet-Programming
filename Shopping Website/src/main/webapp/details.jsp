<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Product"%>
<!-- Name:Aran Adham ALi
	Matrix Code: QU202SECJ005
	-->
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<link rel="stylesheet" href="css/detail.css">
</head>
<body>
	<div id="container">
		<h1 id="title">Product Details</h1>
	
	<%
		Product product = (Product) request.getAttribute("selectedProduct");
	
			if (product != null){
		
	%>
		<div id="image"><img src="images/<%= product.getImage() %>" height="150px" width="150px"></div>
		<p>Name: <%= product.getName() %></p>
		<p>description: <%= product.getDescription() %></p>
		<p>Price: <%= product.getPrice() %></p>
	
	
	<% }else{ %>
		<p> No Product Found</p>
	<%
		}
	%>
	</div>
</body>
</html>