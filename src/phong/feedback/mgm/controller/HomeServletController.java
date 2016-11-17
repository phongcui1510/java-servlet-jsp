package phong.feedback.mgm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import phong.feedback.mgm.dao.UserDAO;
import phong.feedback.mgm.model.User;

/**
 * Servlet implementation class LoginController
 */
public class HomeServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UserDAO userDao = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDao.findUserByUsernameAndPassword(username, password);
		HttpSession session = request.getSession(true);	    
		session.setAttribute("user", username);
		
		if (user.getRole().equalsIgnoreCase("ADMIN")) {
			request.getRequestDispatcher("home.jsp").forward(request,response);
		}
	}

}
