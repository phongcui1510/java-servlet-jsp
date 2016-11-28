package com.feedback.mgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.feedback.mgm.model.Feedback;
import com.feedback.mgm.util.ConnectionManager;

public class FeedbackDAO {

	private static final Logger logger = Logger.getLogger (FeedbackDAO.class);
	
	public int insertFeedback (Feedback feedback) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "insert into feedback(owner, date, topic, subject, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);  

			ps.setString(1, feedback.getOwner());  
			if (feedback.getDate() != null) {
				ps.setDate(2, new java.sql.Date(feedback.getDate().getTime()));  
			} else {
				ps.setDate(2, null);
			}
			ps.setString(3, feedback.getTopic());
			ps.setString(4, feedback.getSubject());
			ps.setString(5, feedback.getA1());
			ps.setString(6, feedback.getA2());
			ps.setString(7, feedback.getA3());
			ps.setString(8, feedback.getA4());
			ps.setString(9, feedback.getA5());
			ps.setString(10, feedback.getA6());
			ps.setString(11, feedback.getA7());
			ps.setString(12, feedback.getA8());
			ps.setString(13, feedback.getA9());
			ps.setString(14, feedback.getA10());
			ps.setString(15, feedback.getA11());

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
	
	public List<Feedback> getAllFeedback () {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "select * from feedback";
			PreparedStatement ps = con.prepareStatement(sql);  
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
		f.setOwner(rs.getString("owner"));
		f.setTopic(rs.getString("topic"));
		f.setSubject(rs.getString("subject"));
		f.setDate(rs.getDate("date"));
		f.setA1(rs.getString("a1"));
		f.setA2(rs.getString("a2"));
		f.setA3(rs.getString("a3"));
		f.setA4(rs.getString("a4"));
		f.setA5(rs.getString("a5"));
		f.setA6(rs.getString("a6"));
		f.setA7(rs.getString("a7"));
		f.setA8(rs.getString("a8"));
		f.setA9(rs.getString("a9"));
		f.setA10(rs.getString("a10"));
		f.setA11(rs.getString("a11"));
		
		return f;
	}
}
