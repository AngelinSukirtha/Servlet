package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

	
	public boolean delete(String name) throws ClassNotFoundException, SQLException {
		boolean rowDeleted;
		String delete = "delete from userRegistration where name=?";
		try (Connection connection = UserRegistrationUtil.getConnection();
				PreparedStatement p = connection.prepareStatement(delete);) {
			p.setString(1, name);
			rowDeleted = p.executeUpdate() > 0;
			p.close();
			connection.close();
		}
		return rowDeleted;
	}

	public void update(Registration registration) throws ClassNotFoundException, SQLException {
		String update = "update userRegistration set mailId=?, phoneNumber=? where name=?";
		try (Connection connection = UserRegistrationUtil.getConnection();
				PreparedStatement p = connection.prepareStatement(update)) {
			p.setString(1, registration.getMailId());
			p.setString(2, registration.getphoneNumber());
			p.setString(3, registration.getName());
			int rows = p.executeUpdate();
			System.out.println(rows + " rows updated");
			p.close();
			connection.close();
		}
	}
}
