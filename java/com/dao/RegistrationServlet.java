package com.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.*;
import java.sql.SQLException;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Registration r = new Registration();
	RegistrationImp registrationImp = new RegistrationImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("do post");
		String name = request.getParameter("name");
		r.setName(name);
		String mailId = request.getParameter("mailId");
		r.setMailId(mailId);
		String phoneNumber = request.getParameter("phoneNumber");
		r.setphoneNumber(phoneNumber);
		try {
			registrationImp.registration(r);
			PrintWriter writer = response.getWriter();
			writer.println(r.getName() + "added");
			writer.println(r.getMailId() + "added");
			writer.println(r.getphoneNumber() + "added");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
