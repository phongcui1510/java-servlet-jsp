package com.feedback.mgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.feedback.mgm.model.ContactUs;
import com.feedback.mgm.util.ConnectionManager;

public class ContactUsDAO {

private static final Logger logger = Logger.getLogger (ContactUsDAO.class);
	
	public int insertContact (ContactUs contact) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "insert into contact_us(name, email, subject, message) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);  

			ps.setString(1,contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getSubject());
			ps.setString(4, contact.getMessage());

			int i = ps.executeUpdate();  
			if (i>0) {
				logger.info("Insert Contact successfully with info: " + contact);
				return 1;
			}

		} catch (Exception e) {
			logger.info("Insert Contact get error with info: " + e);
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
	
	public List<ContactUs> getAllContact () {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "select * from contact_us";
			PreparedStatement ps = con.prepareStatement(sql);  
			ResultSet rs = ps.executeQuery();
			
			List<ContactUs> contacts = new ArrayList<ContactUs>();
			while (rs.next()) {
				ContactUs c = new ContactUs();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setSubject(rs.getString("subject"));
				c.setMessage(rs.getString("message"));
				contacts.add(c);
			}
			return contacts;

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
	
	public ContactUs getContactById (int id) {
		Connection con = ConnectionManager.getConnection();
		try{  
			String sql = "select * from contact_us where id=?";
			PreparedStatement ps = con.prepareStatement(sql);  
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ContactUs c = new ContactUs();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setSubject(rs.getString("subject"));
				c.setMessage(rs.getString("message"));
				return c;
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
