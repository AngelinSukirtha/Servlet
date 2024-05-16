package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;

/**
 * Servlet implementation class RegistrationForm
 */
@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Employee>list=new ArrayList<Employee>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationForm() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("cpassword");
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phoneNo");
		String gender = request.getParameter("gender");
		
		list.add(new Employee(firstName,lastName,userName,password,confirmPassword,email,phoneNo,gender));
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationSuccess.jsp");
		dispatcher.forward(request, response);
	}
}
