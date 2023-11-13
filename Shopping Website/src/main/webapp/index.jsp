<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Product" %>
    <%@page import="java.util.*" %>
    <!-- 
	Name: Aran Adham Ali
	Matrix Code: QU202SECJ005
	-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>

	<h1 id="title">Product List</h1>
	<div id="row">
	<%
	// Assuming productList is available in request attribute
	List<Product> productList = (List<Product>)request.getAttribute("productList");
	// checking for product availability....
	if (productList != null && !productList.isEmpty()) {
		for (Product product : productList) {
	%>
	
		<form action="IndexController" method="post">
		<div class="container">
			<div class="item item-1"><img alt="" src="images/<%= product.getImage() %>" height="100px" width="100px"></div>
			<div class="item item-2"><p><%=product.getName()%></p></div>
			<div class="item item-3"><button type="submit">View More</button></div>		
			<!-- Add a hidden input field to store the product name -->
			<input type="hidden" name="productName"
				value="<%=product.getName()%>">
		</div>
		</form>
	
	<%
	}
	} else {
	%>
	<p>No products available.</p>
	<%
	}
	%>
	</div>
	<a class="login" href="login.jsp">New Here! Please Login</a>
	
</body>
</html>