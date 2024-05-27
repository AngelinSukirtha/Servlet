package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Registration r = new Registration();
	RegistrationImp registrationImp = new RegistrationImp();
	List<Registration> list = new ArrayList<Registration>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("do post");
		String name = request.getParameter("name");
		r.setName(name);
		String mailId = request.getParameter("mailId");
		r.setMailId(mailId);
		String phoneNumber = request.getParameter("phoneNumber");
		r.setphoneNumber(phoneNumber);

		try {
			registrationImp.insert(r);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);

			Cookie nameCookie = new Cookie("name", name);
			Cookie mailIdCookie = new Cookie("mailId", mailId);
			Cookie phoneNumberCookie = new Cookie("phoneNumber", phoneNumber);

			response.addCookie(nameCookie);
			response.addCookie(mailIdCookie);
			response.addCookie(phoneNumberCookie);
			PrintWriter writer = response.getWriter();
			writer.println(r.getName() + " added\n" + r.getMailId() + " added\n" + r.getphoneNumber() + " added\n");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			listUser(request, response);
			List<Registration> list = new ArrayList<>();
			list.add(r);
			request.setAttribute("list", list);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		list.add(new Registration(name, mailId, phoneNumber));
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("UserR.jsp");
		dispatcher.forward(request, response);

	}

	public void listUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ClassNotFoundException, ServletException {
		List<Registration> list = registrationImp.readA();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserR.jsp");
		dispatcher.forward(request, response);
	}

}
