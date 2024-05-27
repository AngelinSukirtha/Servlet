package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Login;
import com.util.UserUtil;

public class LoginDAO {
	public void insertA(Login login) throws ClassNotFoundException, SQLException {
		Connection connection = UserUtil.getConnection();
		String l = "insert into userLogin(userName, email)values(?,?)";
		PreparedStatement p = connection.prepareStatement(l);
		p.setString(1, login.getUserName());
		p.setString(2, login.getEmail());
		int rows = p.executeUpdate();
		System.out.println(rows + "rows inserted");
		p.close();
		connection.close();
	}

	public List<Login> read() throws ClassNotFoundException, SQLException {
		List<Login> list = new ArrayList<>();
		Connection connection = UserUtil.getConnection();
		String read = "select * from userLogin";
		PreparedStatement p = connection.prepareStatement(read);
		try {
			System.out.println(p);
			ResultSet rows = p.executeQuery();
			while (rows.next()) {
				String userName = rows.getString("userName");
				String email = rows.getString("email");
				list.add(new Login(userName, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
