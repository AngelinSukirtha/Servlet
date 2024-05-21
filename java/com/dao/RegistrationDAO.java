package com.dao;

import java.sql.SQLException;

import com.model.Registration;

public interface RegistrationDAO {
	public void registration(Registration r) throws ClassNotFoundException, SQLException;
}
