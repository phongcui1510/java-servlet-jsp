package phong.feedback.mgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import phong.feedback.mgm.model.Feedback;
import phong.feedback.mgm.util.ConnectionManager;

public class FeedbackDAO {

private static final Logger logger = Logger.getLogger (FeedbackDAO.class);
	
	public int insertFeedback (Feedback feedback) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "insert into feedback(title, description, owner, date) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);  

			ps.setString(1, feedback.getTitle());  
			ps.setString(2, feedback.getDescription());  
			ps.setString(3, feedback.getOwner());
			ps.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

			int i = ps.executeUpdate();  
			if (i>0) {
				logger.info("Insert Feedback successfully with info: " + feedback);
				return 1;
			}

		} catch (Exception e) {
			logger.info("Insert Feedback get error with info: " + e);
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
	
	public List<Feedback> getFeedbackByFaculty (int faculty) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "select * from feedback where faculty = ?";
			PreparedStatement ps = con.prepareStatement(sql);  
			ps.setInt(1, faculty);  
			ResultSet rs = ps.executeQuery();
			
			List<Feedback> feedbacks = new ArrayList<Feedback>();
			while (rs.next()) {
				Feedback f = getFeedbackFromResultSet(rs);
				feedbacks.add(f);
			}
			return feedbacks;

		} catch (Exception e) {
			logger.info("Insert Feedback get error with info: " + e);
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
	
	public Feedback getFeedbackById (int id) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "select * from feedback where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);  
			ps.setInt(1, id);  
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Feedback f = getFeedbackFromResultSet(rs);
				return f;
			}

		} catch (Exception e) {
			logger.info("Insert Feedback get error with info: " + e);
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

	private Feedback getFeedbackFromResultSet(ResultSet rs) throws SQLException {
		Feedback f = new Feedback();
		f.setId(rs.getInt("id"));
		f.setTitle(rs.getString("title"));
		f.setDescription(rs.getString("description"));
		f.setOwner(rs.getString("owner"));
		f.setDate(rs.getDate("date"));
		return f;
	}
}
