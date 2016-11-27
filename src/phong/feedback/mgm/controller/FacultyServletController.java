package phong.feedback.mgm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import phong.feedback.mgm.dao.FeedbackDAO;
import phong.feedback.mgm.model.Feedback;
import phong.feedback.mgm.model.User;

public class FacultyServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1952857795781873050L;

	private static final Logger logger = Logger.getLogger (FacultyServletController.class);
	
	private FeedbackDAO feedbackDao = new FeedbackDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		logger.info("Full url: " + url);
		logger.info("Method: " + method);
		String[] str = url.split("/faculty/");
		logger.info("Extracted url: " + str[0] + "   " + str[1]);
		String[] partialUrl = str[1].split("/");
		if (partialUrl[0].equalsIgnoreCase("feedbackList")) {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("currentUser");
			List<Feedback> feedbacks = feedbackDao.getFeedbackByFaculty(user.getId());
			request.setAttribute("feedbacks", feedbacks);
			request.getRequestDispatcher("/pages/faculty/feedbackList.jsp").forward(request,response);
		} else if (partialUrl[0].equalsIgnoreCase("feedback")) {
			if (partialUrl[1].equalsIgnoreCase("view") && method.equalsIgnoreCase("get")) {
				String id = request.getParameter("feedback");
				Feedback feedback = feedbackDao.getFeedbackById(Integer.valueOf(id));
				request.setAttribute("feedback", feedback);
				request.getRequestDispatcher("/pages/faculty/feedbackDetails.jsp").forward(request,response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
