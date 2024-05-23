package com.dao;

import java.sql.SQLException;

import com.model.Registration;

public interface RegistrationDAO {
	public void insert(Registration r) throws ClassNotFoundException, SQLException;
}
