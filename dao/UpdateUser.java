package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Registration;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Registration register = new Registration();
	RegistrationImp registrationImp = new RegistrationImp();
	List<Registration> list = new ArrayList<Registration>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String name = request.getParameter("name");
		register.setName(name);
		String mailId = request.getParameter("mailId");
		register.setMailId(mailId);
		String phoneNumber = request.getParameter("phoneNumber");
		register.setphoneNumber(phoneNumber);

		try {
			registrationImp.update(register);
			PrintWriter writer = response.getWriter();
			writer.println(register.getName() + " updated\n" + register.getMailId() + " updated\n"
					+ register.getphoneNumber() + " updated\n");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "update":
				try {
					updateUser(request, response);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ClassNotFoundException, ServletException {
		String name = request.getParameter("name");
		String mailId = request.getParameter("mailId");
		String phoneNumber = request.getParameter("phoneNumber");
		Registration register = new Registration(name, mailId, phoneNumber);
		registrationImp.update(register);
		response.sendRedirect("UserR.jsp");
	}
}
