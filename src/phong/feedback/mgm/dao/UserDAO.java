package phong.feedback.mgm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import phong.feedback.mgm.model.User;
import phong.feedback.mgm.util.ConnectionManager;
import phong.feedback.mgm.util.Role;

public class UserDAO {

	private static final Logger logger = Logger.getLogger (UserDAO.class);
	
	public User findUserByUsernameAndPassword (String username, String password) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "SELECT * FROM user WHERE username = ? and password = ?";
			logger.info(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = getUserFromResultSet(rs);
				return user;
			}
		} catch (Exception e) {
			logger.info("Find User get error with info: " + e);
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
	
	public User findUserByUsername (String username) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "SELECT * FROM user WHERE username = ?";
			logger.info(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = getUserFromResultSet(rs);
				return user;
			}
		} catch (Exception e) {
			logger.error("Find User get error with info: " + e);
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
	
	public User findUserById (Integer id) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "SELECT * FROM user WHERE id = ?";
			logger.info(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = getUserFromResultSet(rs);
				return user;
			}
		} catch (Exception e) {
			logger.error("Find User get error with info: " + e);
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

	private User getUserFromResultSet(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(Integer.valueOf(rs.getString("id")));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setAddress(rs.getString("address"));
		user.setEmail(rs.getString("email"));
		user.setDob(rs.getDate("dob"));
		user.setRole(rs.getString("role"));
		user.setDescription(rs.getString("description"));
		return user;
	}
	
	public List<User> findAllStudent () {
		Connection con = ConnectionManager.getConnection();
		List<User> users = new ArrayList<User>();
		try{  
			String sql = "SELECT * FROM user WHERE role = ?";
			logger.info(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "STUDENT");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = getUserFromResultSet(rs);
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			logger.info("Find User get error with info: " + e);
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
	
	public List<User> findAllFaculty () {
		Connection con = ConnectionManager.getConnection();
		List<User> users = new ArrayList<User>();
		try{  
			String sql = "SELECT * FROM user WHERE role = ?";
			logger.info(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Role.FACULTY.name());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = getUserFromResultSet(rs);
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			logger.info("Find Faculty get error with info: " + e);
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
	
	public int insertUser (User user) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "insert into user(username, password, lastName, firstName, dob, email, address, description, role) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);  

			ps.setString(1, user.getUsername());  
			ps.setString(2, user.getPassword());  
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getFirstName());
			if (user.getDob() != null) {
				ps.setDate(5, new Date(user.getDob().getTime()));
			} else {
				ps.setDate(5,  null);
			}
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getDescription());
			ps.setString(9, user.getRole());

			int i = ps.executeUpdate();  
			if (i>0) {
				logger.info("Insert User successfully with info: " + user);
				return 1;
			}

		} catch (Exception e) {
			logger.info("Insert User get error with info: " + e);
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
	
	public int updateUser (User user) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "update user set username=?, password=?, firstName=?, lastName=?, dob=?, email=?, address=?, description=?, role=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);  

			ps.setString(1, user.getUsername());  
			ps.setString(2, user.getPassword());  
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getFirstName());
			if (user.getDob() != null) {
				ps.setDate(5, new Date(user.getDob().getTime()));
			} else {
				ps.setDate(5, null);
			}
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getDescription());
			ps.setString(9, user.getRole());
			ps.setInt(10, user.getId());

			int i = ps.executeUpdate();  
			if (i>0) {
				logger.info("Update User successfully with info: " + user);
				return 1;
			}

		} catch (Exception e) {
			logger.info("Update User get error with info: " + e);
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
}
