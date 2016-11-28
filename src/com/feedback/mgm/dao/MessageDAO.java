package com.feedback.mgm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.feedback.mgm.model.Message;
import com.feedback.mgm.util.ConnectionManager;


public class MessageDAO {

	private static final Logger logger = Logger.getLogger (MessageDAO.class);
	
	public int insertMessage (Message message) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "insert into message(sender, destination, date, subject, message) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);  

			ps.setString(1, message.getSender());
			ps.setInt(2,Integer.valueOf(message.getDestination()));
			ps.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
			ps.setString(4, message.getSubject());
			ps.setString(5, message.getMessage());

			int i = ps.executeUpdate();  
			if (i>0) {
				logger.info("Insert Message successfully with info: " + message);
				return 1;
			}

		} catch (Exception e) {
			logger.info("Insert Message get error with info: " + e);
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
	
	public List<Message> getMessage (int destination) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "select * from message where destination =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, destination);
			ResultSet rs = ps.executeQuery();
			
			List<Message> messages = new ArrayList<Message>();
			while (rs.next()) {
				Message m = new Message();
				m.setId(rs.getInt("id"));
				m.setSender(rs.getString("sender"));
				m.setDestination(String.valueOf(rs.getInt("destination")));
				m.setSubject(rs.getString("subject"));
				m.setMessage(rs.getString("message"));
				m.setDate(rs.getDate("date"));
				messages.add(m);
			}
			return messages;

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
	
	public Message getMessageById (int id) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "select * from message where id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Message m = new Message();
				m.setId(rs.getInt("id"));
				m.setSender(rs.getString("sender"));
				m.setDestination(String.valueOf(rs.getInt("destination")));
				m.setSubject(rs.getString("subject"));
				m.setMessage(rs.getString("message"));
				m.setDate(rs.getDate("date"));
				return m;
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
}
