package phong.feedback.mgm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import phong.feedback.mgm.dao.UserDAO;
import phong.feedback.mgm.model.User;

/**
 * Servlet implementation class LoginController
 */
public class HomeServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UserDAO userDao = new UserDAO();
	
	private static final Logger logger = Logger.getLogger (HomeServletController.class);
       
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
		String url = request.getRequestURL().toString();
		if (url.contains("home")) {
			response.sendRedirect("home.jsp");
		} else if (url.contains("login")) {
			String error = request.getParameter("errorMsg");
			if (error != null && !error.equalsIgnoreCase("")) {
				request.setAttribute("errorMsg", error);
			}
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		} else if (url.contains("logout")) {
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("home.jsp");
			logger.info("Logout successfully");
		}
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
		
		if (user != null) {
			HttpSession session = request.getSession(true);	    
			session.setAttribute("currentUser", user);
			if (user.getRole().equalsIgnoreCase("ADMIN")) {
				response.sendRedirect(request.getContextPath() + "/admin/user/list");
//			request.send("/admin/user/list").forward(request,response);
//				request.getRequestDispatcher("/login.jsp").forward(request,response);
			} else if (user.getRole().equalsIgnoreCase("User")) {
				response.sendRedirect(request.getContextPath() + "/student/feedback/create");
			}
		} else {
			request.setAttribute("errorMsg", "Username or Password wrong");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}

}
