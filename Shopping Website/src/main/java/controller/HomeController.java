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
import javax.servlet.http.HttpSession;

import model.Product;
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
        List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");

        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cartItems", cartItems);
        }

        request.setAttribute("productList", addProducts());
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
           
            String productImage = request.getParameter("productImage");
            String productName = request.getParameter("productName");
            String productDesc = request.getParameter("productDesc");
            double productPrice = Double.parseDouble(request.getParameter("productPrice"));


            HttpSession session = request.getSession(false);
            List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");

        
            if (cartItems == null) {
                cartItems = new ArrayList<>();
                session.setAttribute("cartItems", cartItems);
            }


            Product product = new Product();
            product.setImage(productImage);
            product.setName(productName);
            product.setDescription(productDesc);
            product.setPrice(productPrice);

            cartItems.add(product);
            session.setAttribute("cartItems", cartItems);
        } else if ("remove".equals(action)) {
            int removeIndex = Integer.parseInt(request.getParameter("removeIndex"));

            HttpSession session = request.getSession(false);
            List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");
            if (cartItems != null && removeIndex >= 0 && removeIndex < cartItems.size()) {
                cartItems.remove(removeIndex);
                session.setAttribute("cartItems", cartItems);
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


