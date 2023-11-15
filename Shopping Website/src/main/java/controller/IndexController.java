package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("productList", addProducts());

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productName = request.getParameter("productName");


		List<Product> productList = addProducts(); 
		Product selectedProduct = null;

		for (Product product : productList) {
			if (product.getName().equals(productName)) {
				selectedProduct = product;
				break;
			}
		}

		
		request.setAttribute("selectedProduct", selectedProduct);

		
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	
	private List<Product> addProducts() {
		List<Product> productList = new ArrayList<>();

		Product product1 = new Product();
		product1.setName("Internet Programming");
		product1.setDescription("The Book is for Internet Programming Course");
		product1.setPrice(19.99);
		product1.setImage("img1.jpg");

		Product product2 = new Product();
		product2.setName("Networking Programming");
		product2.setDescription("The Book is for Networking Programming Course");
		product2.setPrice(29.99);
		product2.setImage("img2.jpg");

		productList.add(product1);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);
		productList.add(product2);

		return productList;
	}
}
