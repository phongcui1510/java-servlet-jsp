package phong.feedback.mgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import phong.feedback.mgm.model.User;
import phong.feedback.mgm.util.ConnectionManager;

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
		return user;
	}
	
	public List<User> findAllStudent () {
		Connection con = ConnectionManager.getConnection();
		List<User> users = new ArrayList<User>();
		try{  
			String sql = "SELECT * FROM user WHERE role = ?";
			logger.info(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "USER");
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
}
