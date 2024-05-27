package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Login login = new Login();
	LoginDAO log = new LoginDAO();
	List<Login> list = new ArrayList<Login>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		String userName = request.getParameter("userName");
		login.setUserName(userName);
		String email = request.getParameter("email");
		login.setEmail(email);

		try {
			log.insertA(login);
			PrintWriter writer = response.getWriter();
			writer.println(login.getUserName() + " added\n" + login.getEmail() + " added\n");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			list(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		list.add(new Login(userName, email));
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserLogin.jsp");
		dispatcher.forward(request, response);

	}

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ClassNotFoundException, ServletException {
		List<Login> list = log.read();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserLogin.jsp");
		dispatcher.forward(request, response);
	}

}
