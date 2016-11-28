package com.feedback.mgm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.feedback.mgm.dao.FeedbackDAO;
import com.feedback.mgm.dao.MessageDAO;
import com.feedback.mgm.model.Feedback;
import com.feedback.mgm.model.Message;
import com.feedback.mgm.model.User;

public class FacultyServletController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1952857795781873050L;

	private static final Logger logger = Logger.getLogger (FacultyServletController.class);
	
	private FeedbackDAO feedbackDao = new FeedbackDAO();
	
	private MessageDAO messageDao = new MessageDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispathRequest(request, response);
	}

	private void dispathRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		logger.info("Full url: " + url);
		logger.info("Method: " + method);
		String[] str = url.split("/faculty/");
		logger.info("Extracted url: " + str[0] + "   " + str[1]);
		String[] partialUrl = str[1].split("/");
		if (partialUrl[0].equalsIgnoreCase("feedback")) {
			if (partialUrl[1].equalsIgnoreCase("list")) {
				listFeedback(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("details")) {
				feedbackDetails(request, response);
			}
		} else if (partialUrl[0].equalsIgnoreCase("message")) {
			if (partialUrl[1].equalsIgnoreCase("list")) {
				listMessage(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("details")) {
				messageDetails(request, response);
			}
		}
	}

	private void feedbackDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("feedback");
		Feedback feedback = feedbackDao.getFeedbackById(Integer.valueOf(id));
		request.setAttribute("feedback", feedback);
		request.getRequestDispatcher("/pages/faculty/feedbackDetails.jsp").forward(request,response);
	}

	private void listFeedback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Feedback> feedbacks = feedbackDao.getAllFeedback();
		request.setAttribute("feedbacks", feedbacks);
		request.getRequestDispatcher("/pages/faculty/feedbackList.jsp").forward(request,response);
	}

	private void messageDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("message");
		Message message = messageDao.getMessageById(Integer.valueOf(id));
		request.setAttribute("message", message);
		request.getRequestDispatcher("/pages/faculty/messageDetails.jsp").forward(request,response);
	}

	private void listMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		List<Message> messages = messageDao.getMessage(user.getId());
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("/pages/faculty/messageList.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
