package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Create a User object
		User user1 = new User();
		user1.setUserName(username);
		user1.setPassword(password);
		
		// Check if the user exists in the list (simple authentication)
        boolean userExists = false;
        for (User user : RegisterController.getUsers()) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                userExists = true;
                break;
            }
        }

		if ("Aran".equals(user1.getUserName()) && "1234".equals(user1.getPassword())) {
			response.sendRedirect("HomeController");
		} else if(userExists){
			{
				request.getRequestDispatcher("HomeController").forward(request, response);
		}
			request.getRequestDispatcher("HomeController").forward(request, response);
		}else {
			response.sendRedirect("error.jsp");
		}

	}

}
