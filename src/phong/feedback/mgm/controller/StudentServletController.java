package phong.feedback.mgm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import phong.feedback.mgm.dao.ContactUsDAO;
import phong.feedback.mgm.dao.FeedbackDAO;
import phong.feedback.mgm.dao.MessageDAO;
import phong.feedback.mgm.dao.UserDAO;
import phong.feedback.mgm.model.ContactUs;
import phong.feedback.mgm.model.Feedback;
import phong.feedback.mgm.model.Message;
import phong.feedback.mgm.model.User;

/**
 * Servlet implementation class StudentServletController
 */
public class StudentServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = Logger.getLogger (StudentServletController.class);
	

	private UserDAO userDao = new UserDAO();
	
	private FeedbackDAO feebackDao = new FeedbackDAO();
	
	private MessageDAO messageDao = new MessageDAO();
	
	private ContactUsDAO contactUsDao = new ContactUsDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void dispatchRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		logger.info("Full url: " + url);
		logger.info("Method: " + method);
		String[] str = url.split("/student/");
		logger.info("Extracted url: " + str[0] + "   " + str[1]);
		String[] partialUrl = str[1].split("/");
		if (partialUrl[0].equalsIgnoreCase("changePass")) {
			
		} else if (partialUrl[0].equalsIgnoreCase("contactUs")) {
			
		} else if (partialUrl[0].equalsIgnoreCase("feedback")) {
			if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("get")) {
				request.getRequestDispatcher("/pages/student/feedbackSubmit.jsp").forward(request,response);
			} else if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("post")) {
				Feedback feedback = extractParam(request);
				int result = feebackDao.insertFeedback(feedback);
				if (result>0) {
					request.setAttribute("msg", "Submit feedback successfully");
					request.getRequestDispatcher("/pages/student/feedbackSubmit.jsp").forward(request,response);
				}
			}
		} else if (partialUrl[0].equalsIgnoreCase("message")) {
			if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("get")) {
				List<User> faculties = userDao.findAllFaculty();
				request.setAttribute("faculties", faculties);
				request.getRequestDispatcher("/pages/student/message.jsp").forward(request,response);
			} else if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("post")) {
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("currentUser");
				String destination = request.getParameter("destination");
				String subject = request.getParameter("subject");
				String message = request.getParameter("message");
				Message m = new Message();
				m.setSender(user.getFirstName()+ " " + user.getLastName());
				m.setDestination(destination);
				m.setSubject(subject);
				m.setMessage(message);
				messageDao.insertMessage(m);
				request.setAttribute("msg", "Send message successfully");
				request.getRequestDispatcher("/pages/student/message.jsp").forward(request,response);
			}
		} else if (partialUrl[0].equalsIgnoreCase("contact")) {
			if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("get")) {
				request.getRequestDispatcher("/pages/student/contactUs.jsp").forward(request,response);
			} else if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("post")) {
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String subject = request.getParameter("subject");
				String message = request.getParameter("message");
				ContactUs contact = new ContactUs();
				contact.setName(name);
				contact.setEmail(email);
				contact.setSubject(subject);
				contact.setMessage(message);
				contactUsDao.insertContact(contact);
				request.setAttribute("msg", "Send message successfully");
				request.getRequestDispatcher("/pages/student/contactUs.jsp").forward(request,response);
			}
		}
	}
	
	
	private Feedback extractParam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String topic = request.getParameter("topic");
		String subject = request.getParameter("subject");
		String dateString = request.getParameter("date");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (dateString != null) {
			try {
				date = df.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		String a3 = request.getParameter("a3");
		String a4 = request.getParameter("a4");
		String a5 = request.getParameter("a5");
		String a6 = request.getParameter("a6");
		String a7 = request.getParameter("a7");
		String a8 = request.getParameter("a8");
		String a9 = request.getParameter("a9");
		String a10 = request.getParameter("a10");
		String a11 = request.getParameter("a11");
		
		Feedback feedback = new Feedback();
		User user = (User)session.getAttribute("currentUser");
		feedback.setOwner(user.getFirstName() + " " + user.getLastName());
		feedback.setTopic(topic);
		feedback.setSubject(subject);
		feedback.setDate(date);
		feedback.setA1(a1);
		feedback.setA2(a2);
		feedback.setA3(a3);
		feedback.setA4(a4);
		feedback.setA5(a5);
		feedback.setA6(a6);
		feedback.setA7(a7);
		feedback.setA8(a8);
		feedback.setA9(a9);
		feedback.setA10(a10);
		feedback.setA11(a11);
		
		return feedback;
	}
}
