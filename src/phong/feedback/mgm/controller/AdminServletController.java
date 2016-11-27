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

import phong.feedback.mgm.dao.StudentDAO;
import phong.feedback.mgm.dao.UserDAO;
import phong.feedback.mgm.model.Student;
import phong.feedback.mgm.model.User;
import phong.feedback.mgm.util.Role;


//import org.apache.log4j.Logger;

/**
 * Servlet implementation class AdminServletController
 */
public class AdminServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = Logger.getLogger (AdminServletController.class);
	
	private final StudentDAO studentDAO = new StudentDAO();
	
	private final UserDAO userDao = new UserDAO();
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
		dispatchRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User student = extractParam(request);
		int result = userDao.insertUser(student);
		if (result > 0) {
			logger.info("Redirect to view student after inserting successful" );
//			Student savedStudent = studentDAO.findStudentByUsername(student.getUsername());
//			response.sendRedirect(request.getContextPath() + "/admin/user/view?username=" + savedStudent.getUsername());
			response.sendRedirect(request.getContextPath() + "/admin/student/list");
		}
	}
	
	private void viewStudent (HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		logger.info("View Student with username: " + username);
		Student student = studentDAO.findStudentByUsername(username);
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
//				response.sendRedirect(request.getContextPath() + "/pages/admin/userCreate.jsp");
				redirectStudentRegistrationPage(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("create") && method.equalsIgnoreCase("post")) {
				createStudent(request, response);
			} else if (partialUrl[1].equalsIgnoreCase("view")){
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
				String id = request.getParameter("facultyid");
				User faculty = userDao.findUserById(Integer.valueOf(id));
				request.setAttribute("faculty", faculty);
				request.getRequestDispatcher("/pages/admin/facultyCreate.jsp").forward(request,response);
			} else if (partialUrl[1].equalsIgnoreCase("edit") && method.equalsIgnoreCase("post")) {
				User faculty = extractParam(request);
				userDao.updateUser(faculty);
				request.getRequestDispatcher("/pages/admin/facultyList.jsp").forward(request,response);
			}
		}
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

	private void createFaculty(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String description = request.getParameter("description");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setDescription(description);
		user.setRole(Role.FACULTY.name());
		int i = userDao.insertUser(user);
		if (i > 0) {
			logger.info("Redirect to view faculty after inserting successful" );
			response.sendRedirect(request.getContextPath() + "/admin/faculty/list");
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
//					Student savedStudent = studentDAO.findStudentByUsername(student.getUsername());
//					response.sendRedirect(request.getContextPath() + "/admin/user/view?username=" + savedStudent.getUsername());
			response.sendRedirect(request.getContextPath() + "/admin/student/list");
		}
	}

	private void redirectLoginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = request.getParameter("errorMsg");
		if (error != null && !error.equalsIgnoreCase("")) {
			request.setAttribute("errorMsg", error);
		}
		request.getRequestDispatcher("/pages/admin/login.jsp").forward(request,response);
	}

	private void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		logger.info("Login with: username = " + username + " and password =  " + password);
		User user = userDao.findUserByUsernameAndPassword(username, password);
		logger.info("User: " + user + "   " + (user == null));
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/admin/login?errorMsg=show");
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("currentUser", user);
			
			List<Student> students = studentDAO.findAllStudent();
			session.setAttribute("students", students);
			
			request.getRequestDispatcher("/pages/admin/studentList.jsp").forward(request,response);
		}
	}

	private void redirectEditPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		logger.info("Edit Student with username: " + username);
		User user = userDao.findUserByUsername(username);
		request.setAttribute("user", user);
		request.setAttribute("title", "Student Edition");
		request.getRequestDispatcher("/pages/admin/studentCreate.jsp").forward(request,response);
	}
	
	private User extractParam(HttpServletRequest request) {
		User student = new User();
		if (request.getParameter("userid") != null) {
			String id = request.getParameter("userid");
			student.setId(Integer.valueOf(id));
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dobString = request.getParameter("dob");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = null;
		try {
			dob = dateFormat.parse(dobString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String description = request.getParameter("description");
		student.setUsername(username);
		student.setPassword(password);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setDob(dob);
		student.setEmail(email);
		student.setAddress(address);
		student.setDescription(description);
		student.setRole(phong.feedback.mgm.util.Role.STUDENT.name());
//		student.setDob(new Date);
		return student;
	}
}
