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

import org.apache.log4j.Logger;

import phong.feedback.mgm.dao.ContactUsDAO;
import phong.feedback.mgm.dao.UserDAO;
import phong.feedback.mgm.model.ContactUs;
import phong.feedback.mgm.model.User;
import phong.feedback.mgm.util.Role;

/**
 * Servlet implementation class AdminServletController
 */
public class AdminServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = Logger.getLogger (AdminServletController.class);
	
	private final UserDAO userDao = new UserDAO();
	
	private ContactUsDAO contactDao = new ContactUsDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServletController() {
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
	
	private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User student = extractParam(request);
		User checkUser = userDao.findUserByUsername(student.getUsername());
		if (checkUser == null) {
			logger.info("Student username is already exists" );
			request.setAttribute("errormsg", "Username is already exists");
			request.getRequestDispatcher("/pages/admin/studentCreate.jsp").forward(request,response);
		} else {
			int result = userDao.insertUser(student);
			if (result > 0) {
				logger.info("Redirect to view student after inserting successful" );
				response.sendRedirect(request.getContextPath() + "/admin/student/list");
			}
		}
	}
	
	private void viewStudent (HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		logger.info("View Student with username: " + id);
		User student = userDao.findUserById(Integer.valueOf(id));
		request.setAttribute("student", student);
		try {
			request.getRequestDispatcher("/pages/admin/studentDetail.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dispatchRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		logger.info("Full url: " + url);
		logger.info("Method: " + method);
		String[] str = url.split("/admin/");
		logger.info("Extracted url: " + str[0] + "   " + str[1]);
		String[] partialUrl = str[1].split("/");
		if (partialUrl[0].equalsIgnoreCase("student")) {
			if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("get")) {
				redirectStudentRegistrationPage(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("post")) {
				createStudent(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("details")){
				viewStudent(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("edit") && method.equalsIgnoreCase("get")) {
				redirectEditPage(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("edit") && method.equalsIgnoreCase("post")) {
				updateStudent(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("list")) {
				listStudent(request, response);
			}
		} else if (partialUrl[0].equalsIgnoreCase("faculty")) {
			if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("get")) {
				redirectFacultyRegistrationpage(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("post")) {
				createFaculty(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("list")) {
				listFaculty(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("edit") && method.equalsIgnoreCase("get")) {
				redirectToEditFacultyPage(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("edit") && method.equalsIgnoreCase("post")) {
				editFaculty(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("details")) {
				facultyDetails(request, response);
			}
		} else if (partialUrl[0].equalsIgnoreCase("contact")) {
			if (partialUrl[1].equalsIgnoreCase("list")) {
				listContact(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("details")) {
				contactDetails(request, response);
			}
		}
	}

	private void contactDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("contact");
		ContactUs contact = contactDao.getContactById(Integer.valueOf(id));
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/pages/admin/contactDetails.jsp").forward(request,response);
	}

	private void listContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ContactUs> contacts = contactDao.getAllContact();
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("/pages/admin/contactList.jsp").forward(request,response);
	}

	private void facultyDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		User faculty = userDao.findUserById(Integer.valueOf(id));
		request.setAttribute("faculty", faculty);
		request.getRequestDispatcher("/pages/admin/facultyDetails.jsp").forward(request,response);
	}

	private void editFaculty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String description = request.getParameter("description");
		User faculty = new User();
		faculty.setId(Integer.valueOf(id));
		faculty.setUsername(username);
		faculty.setPassword(password);
		faculty.setDescription(description);
		faculty.setRole(Role.FACULTY.name());
		userDao.updateUser(faculty);
		response.sendRedirect(request.getContextPath() + "/admin/faculty/list");
	}

	private void redirectToEditFacultyPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		User faculty = userDao.findUserById(Integer.valueOf(id));
		request.setAttribute("faculty", faculty);
		request.getRequestDispatcher("/pages/admin/facultyCreate.jsp").forward(request,response);
	}

	private void redirectFacultyRegistrationpage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Faculty Registration");
		request.getRequestDispatcher("/pages/admin/facultyCreate.jsp").forward(request,response);
	}

	private void listFaculty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> faculties = userDao.findAllFaculty();
		request.setAttribute("faculties", faculties);
		request.getRequestDispatcher("/pages/admin/facultyList.jsp").forward(request,response);
	}

	private void createFaculty(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String description = request.getParameter("description");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setDescription(description);
		user.setRole(Role.FACULTY.name());
		User faculty = userDao.findUserByUsername(username);
		if (faculty != null && faculty.getUsername() != null && faculty.getUsername() != "") {
			logger.info("Faculty username is already exists" );
			request.setAttribute("errormsg", "Username is already exists");
			request.getRequestDispatcher("/pages/admin/facultyCreate.jsp").forward(request,response);
		} else {
			int i = userDao.insertUser(user);
			if (i > 0) {
				logger.info("Redirect to view faculty after inserting successful" );
				response.sendRedirect(request.getContextPath() + "/admin/faculty/list");
			}
		}
	}

	private void redirectStudentRegistrationPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "Student Registration");
		request.getRequestDispatcher("/pages/admin/studentCreate.jsp").forward(request,response);
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> students = userDao.findAllStudent();
		request.setAttribute("students", students);
		request.getRequestDispatcher("/pages/admin/studentList.jsp").forward(request,response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("userid");
		User student = extractParam(request);
		int result = userDao.updateUser(student);
		if (result > 0) {
			logger.info("Redirect to view student after updating successful" );
			response.sendRedirect(request.getContextPath() + "/admin/student/list");
		}
	}

	private void redirectEditPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		logger.info("Edit Student with username: " + id);
		User user = userDao.findUserById(Integer.valueOf(id));
		request.setAttribute("user", user);
		request.setAttribute("title", "Student Edition");
		request.getRequestDispatcher("/pages/admin/studentCreate.jsp").forward(request,response);
	}
	
	private User extractParam(HttpServletRequest request) {
		User user = new User();
		if (request.getParameter("id") != null) {
			String id = request.getParameter("id");
			user.setId(Integer.valueOf(id));
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dobString = request.getParameter("dob");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = null;
		if (dobString != null) {
			try {
				dob = dateFormat.parse(dobString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDob(dob);
		user.setEmail(email);
		user.setAddress(address);
		user.setDescription(description);
		if (user.getRole() == null) {
			user.setRole(phong.feedback.mgm.util.Role.STUDENT.name());
		}
		return user;
	}
}
