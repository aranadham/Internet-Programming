package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Initialize cartItems attribute if not present in the application scope
        ServletContext application = getServletContext();
        List<Product> cartItems = (List<Product>) application.getAttribute("cartItems");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
            application.setAttribute("cartItems", cartItems);
        }

        request.setAttribute("productList", addProducts());
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Code for adding to the cart
            String productImage = request.getParameter("productImage");
            String productName = request.getParameter("productName");
            String productDesc = request.getParameter("productDesc");
            double productPrice = Double.parseDouble(request.getParameter("productPrice"));

            // Retrieve the current cart items from the application scope
            ServletContext application = getServletContext();
            List<Product> cartItems = (List<Product>) application.getAttribute("cartItems");

            // If the cart is null, create a new list
            if (cartItems == null) {
                cartItems = new ArrayList<>();
                application.setAttribute("cartItems", cartItems);
            }

            // Create a new Product object
            Product product = new Product();
            product.setImage(productImage);
            product.setName(productName);
            product.setDescription(productDesc);
            product.setPrice(productPrice);

            // Add the product to the cart
            cartItems.add(product);

            // Update the cartItems attribute in the application scope
            application.setAttribute("cartItems", cartItems);
        } else if ("remove".equals(action)) {
            // Code for removing from the cart
            int removeIndex = Integer.parseInt(request.getParameter("removeIndex"));

            // Retrieve the current cart items from the application scope
            ServletContext application = getServletContext();
            List<Product> cartItems = (List<Product>) application.getAttribute("cartItems");

            // If the cart is not null and the index is valid, remove the item
            if (cartItems != null && removeIndex >= 0 && removeIndex < cartItems.size()) {
                cartItems.remove(removeIndex);
                application.setAttribute("cartItems", cartItems);
            }
        }

        // Refresh the page
        doGet(request, response);
    }

    private List<Product> addProducts() {
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setName("Internet Programming");
        product1.setDescription("The Book is for Internet Programming Course");
        product1.setPrice(19.99);
        product1.setImage("img1.jpg");

        Product product2 = new Product();
        product2.setName("Network Programming");
        product2.setDescription("The Book is for Networking Programming Course");
        product2.setPrice(29.99);
        product2.setImage("img2.jpg");

        productList.add(product1);
        productList.add(product2);

        return productList;
    }
}


