package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			PrintWriter writer = response.getWriter();
			writer.println(r.getName() + " added\n" + r.getMailId() + " added\n" + r.getphoneNumber() + " added\n");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			registrationImp.delete(r);
			PrintWriter writer = response.getWriter();
			writer.println(r.getName() + "added");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		try {
			registrationImp.update(name, mailId);
			PrintWriter writer = response.getWriter();
			writer.println(r.getName() + " added\n" + r.getMailId() + " added\n" + r.getphoneNumber() + " added\n");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		try {
			listUser(request, response);
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

//		String action = request.getServletPath();
//		switch (action) {
//		case "/new":
//			showNewForm(request, response);
//			break;
//		case "/insert":
//			try {
//				insertUser(request, response);
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			break;
//		case "/delete":
//			try {
//				deleteUser(request, response);
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			break;
//		case "/edit":
//			try {
//				showEdit(request, response);
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			break;
//		case "/update":
//			try {
//				updateUser(request, response);
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			break;
//		default:
//			try {
//				listUser(request, response);
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			break;
//		}
//
//	}
//
//	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("UserR.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	public void insertUser(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, SQLException, ClassNotFoundException {
//		String name = request.getParameter("name");
//		String mailId = request.getParameter("mailId");
//		String phoneNumber = request.getParameter("phoneNumber");
//		Registration register = new Registration(name, mailId, phoneNumber);
//		registrationImp.insert(register);
//		response.sendRedirect("list");
//	}
//
//	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, SQLException, ClassNotFoundException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		registrationImp.delete(id);
//		response.sendRedirect("list");
//	}
//
//	public void showEdit(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, SQLException, ClassNotFoundException, ServletException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		Registration register = registrationImp.read(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("UserR.jsp");
//		request.setAttribute("r", register);
//		dispatcher.forward(request, response);
//	}
//
//	public void updateUser(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, SQLException, ClassNotFoundException, ServletException {
//		// int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String mailId = request.getParameter("mailId");
//		String phoneNumber = request.getParameter("phoneNumber");
//		Registration register = new Registration(name, mailId, phoneNumber);
//		registrationImp.update(register);
//		response.sendRedirect("list");
//	}
//
//	public void listUser(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, SQLException, ClassNotFoundException, ServletException {
//		List<Registration> list = registrationImp.readA();
//		request.setAttribute("list", list);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("UserR.jsp");
//		dispatcher.forward(request, response);
//	}
//}
