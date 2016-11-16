package phong.feedback.mgm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

/**
 * Servlet implementation class AdminServletController
 */
public class AdminServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
//	private static final Logger logger = Logger.getLogger (AdminServletController.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String url = request.getRequestURL().toString();
//		logger.info("Phong:" + url);
		response.sendRedirect(request.getContextPath() + "/pages/admin/userCreate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
