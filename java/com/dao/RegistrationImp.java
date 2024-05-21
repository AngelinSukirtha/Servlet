package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Registration;
import com.util.UserRegistrationUtil;

public class RegistrationImp implements RegistrationDAO {
	public void registration(Registration r) throws ClassNotFoundException, SQLException {
		Connection connection = UserRegistrationUtil.getConnection();
		String registration = "insert into userRegistration(name, mailId, phoneNumber)values(?,?,?)";
		PreparedStatement p = connection.prepareStatement(registration);
//		r.setName(r.getName());
		p.setString(1, r.getName());
//		r.setMailId(r.getMailId());
		p.setString(2, r.getMailId());
//		r.setPhoneNo(r.getPhoneNo());
		p.setString(3, r.getphoneNumber());
//		System.out
//				.println("Name: " + r.getName() + "\nMail Id: " + r.getMailId() + "\nPhone Number: " + r.getPhoneNo());
		int rows = p.executeUpdate();
		System.out.println(rows + "rows inserted");
	}
}
