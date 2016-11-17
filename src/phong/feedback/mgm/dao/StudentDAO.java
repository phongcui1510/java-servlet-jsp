package phong.feedback.mgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import phong.feedback.mgm.model.Student;
import phong.feedback.mgm.util.ConnectionManager;

public class StudentDAO {

	private static final Logger logger = Logger.getLogger (StudentDAO.class);
	
	public int insertStudent (Student student) {
		Connection con = ConnectionManager.getConnection();
		try{  
			PreparedStatement ps = con.prepareStatement(  
					"insert into student(username, password, dob, email) values(?,?,?,?)");  

			ps.setString(1, student.getUsername());  
			ps.setString(2, student.getPassword());  
			ps.setString(3, student.getDob());  
			ps.setString(4, student.getEmail());  

			int i = ps.executeUpdate();  
			if (i>0) {
				logger.info("Insert Student successfully with info: " + student);
				return 1;
			}
			
			return 0;


		} catch (Exception e) {
			logger.info("Insert Student get error with info: " + e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Student findStudentByUsername (String username) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "SELECT * FROM student WHERE username = ?";
			logger.info(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setUsername(rs.getString("username"));
				student.setPassword(rs.getString("password"));
				student.setDob(rs.getString("dob"));
				student.setEmail(rs.getString("email"));
				return student;
			}
		} catch (Exception e) {
			logger.info("Find Student get error with info: " + e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Student> findAllStudent () {
		Connection con = ConnectionManager.getConnection();
		List<Student> students = new ArrayList<Student>();
		try{  
			String sql = "SELECT * FROM student";
			logger.info(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setUsername(rs.getString("username"));
				student.setPassword(rs.getString("password"));
				student.setDob(rs.getString("dob"));
				student.setEmail(rs.getString("email"));
				students.add(student);
			}
			return students;
		} catch (Exception e) {
			logger.info("Find Student get error with info: " + e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
