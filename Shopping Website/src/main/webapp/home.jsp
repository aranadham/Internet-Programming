<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="model.Product"%>
<%@ page import="java.util.*" %>
<!-- 
	Name: Aran Adham Ali
	Matrix Code: QU202SECJ005
	-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>

    <h1 id="title">Products</h1>
    <div id="row">
        <%
            // Assuming productList is available in request attribute
            List<Product> productList = (List<Product>) request.getAttribute("productList");
            // checking for product availability....
            if (productList != null && !productList.isEmpty()) {
                for (Product product : productList) {
        %>

        <form action="HomeController" method="post">
            <div class="container">
                <div class="item item-1"><img alt="" src="images/<%= product.getImage() %>" height="100px" width="100px"></div>
                <div class="item item-2"><p><%= product.getName() %></p></div>

                <!-- Add hidden input fields to store the product info -->
                <input type="hidden" name="productImage" value="<%= product.getImage() %>">
                <input type="hidden" name="productName" value="<%= product.getName() %>">
                <input type="hidden" name="productDesc" value="<%= product.getDescription() %>">
                <input type="hidden" name="productPrice" value="<%= product.getPrice() %>">
                <div class="item item-3"><button name="action" type="submit" value="add">Add to Cart</button></div>
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

    <!-- Cart Section -->
<div id="cart">
    <h2>Your Cart</h2>
    <form action="HomeController" method="post">
        <ul>
            <!-- Loop through cart items and display them -->
            <%
                List<Product> cartItems = (List<Product>) application.getAttribute("cartItems");
                double total = 0.0;
                if (cartItems != null && !cartItems.isEmpty()) {
                    for (int i = 0; i < cartItems.size(); i++) {
                        Product cartItem = cartItems.get(i);
                        total += cartItem.getPrice();
            %>
            <li>
                <%= cartItem.getName() %> - $<%= cartItem.getPrice() %>
                <input type="hidden" name="removeIndex" value="<%= i %>">
                <button type="submit" name="action" value="remove">Remove</button>
            </li>
            <%
                    }
                }
            %>
        </ul>
    </form>
    <p>Total: $<%= total %></p>
</div>

</body>
</html>
