package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import com.model.Registration;
import com.util.UserRegistrationUtil;

public class RegistrationImp implements RegistrationDAO {
	public void insert(Registration r) throws ClassNotFoundException, SQLException {
		Connection connection = UserRegistrationUtil.getConnection();
		String registration = "insert into userRegistration(name, mailId, phoneNumber)values(?,?,?)";
		PreparedStatement p = connection.prepareStatement(registration);
		p.setString(1, r.getName());
		p.setString(2, r.getMailId());
		p.setString(3, r.getphoneNumber());
		int rows = p.executeUpdate();
		System.out.println(rows + "rows inserted");
		p.close();
		connection.close();
	}

	public void delete(Registration r) throws ClassNotFoundException, SQLException {
		Connection connection = UserRegistrationUtil.getConnection();
		String delete = "delete from userRegistration where name='Rithiga'";
		PreparedStatement p = connection.prepareStatement(delete);
		int rows = p.executeUpdate();
		System.out.println(rows + "rows inserted");
		p.close();
		connection.close();
	}

	public void update(String name, String mailId) throws ClassNotFoundException, SQLException {
		Connection connection = UserRegistrationUtil.getConnection();
		String update = "update userRegistration set name='Vidhya',mailId='vidhya99@gmail.com' where phoneNumber='1111111111'";
		PreparedStatement p = connection.prepareStatement(update);
		int rows = p.executeUpdate();
		System.out.println(rows + "rows inserted");
		p.close();
		connection.close();
	}

	public List<Registration> readA() throws ClassNotFoundException, SQLException {
		List<Registration> list = new ArrayList<>();
		Connection connection = UserRegistrationUtil.getConnection();
		String readA = "select * from userRegistration";
		PreparedStatement p = connection.prepareStatement(readA);
		try {
			System.out.println(p);
			ResultSet rows = p.executeQuery();
			while (rows.next()) {
				String name = rows.getString("name");
				String mailId = rows.getString("mailId");
				String phoneNumber = rows.getString("phoneNumber");
				list.add(new Registration(name, mailId, phoneNumber));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

//	public static final String read = "select name, mailId, phoneNumber  from userRegistration where id=?";
//	public static final String readA = "select * from userRegistration";
//	public static final String delete = "delete from userRegistration where id=?";
//	public static final String update = "update userRegistration set name=?, mailId=?, phoneNumber=? where id=?";
//
//	public boolean update(Registration r) throws ClassNotFoundException, SQLException {
//		boolean rowUpdated;
//		try (Connection connection = UserRegistrationUtil.getConnection();
//				PreparedStatement p = connection.prepareStatement(update);) {
//			p.setString(1, r.getName());
//			p.setString(2, r.getMailId());
//			p.setString(3, r.getphoneNumber());
//			rowUpdated = p.executeUpdate() > 0;
//			p.close();
//			connection.close();
//		}
//		return rowUpdated;
//	}
//
//	public Registration read(int id) throws ClassNotFoundException, SQLException {
//		Registration r = null;
//		try (Connection connection = UserRegistrationUtil.getConnection();
//				PreparedStatement p = connection.prepareStatement(read);) {
//			p.setInt(1, id);
//			System.out.println(p);
//			ResultSet rows = p.executeQuery();
//			while (rows.next()) {
//				String name = rows.getString("name");
//				String mailId = rows.getString("mailId");
//				String phoneNumber = rows.getString("phoneNumber");
//				r = new Registration(name, mailId, phoneNumber);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return r;
//	}
//
//	public List<Registration> readA() throws ClassNotFoundException {
//		List<Registration> list = new ArrayList<>();
//		try (Connection connection = UserRegistrationUtil.getConnection();
//				PreparedStatement p = connection.prepareStatement(readA);) {
//			System.out.println(p);
//			ResultSet rows = p.executeQuery();
//			while (rows.next()) {
//				String name = rows.getString("name");
//				String mailId = rows.getString("mailId");
//				String phoneNumber = rows.getString("phoneNumber");
//				list.add(new Registration(name, mailId, phoneNumber));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public boolean delete(int id) throws ClassNotFoundException, SQLException {
//		boolean rowDeleted;
//		try (Connection connection = UserRegistrationUtil.getConnection();
//				PreparedStatement p = connection.prepareStatement(delete);) {
//			p.setInt(1, id);
//			rowDeleted = p.executeUpdate() > 0;
//			p.close();
//			connection.close();
//		}
//		return rowDeleted;
//	}

}
