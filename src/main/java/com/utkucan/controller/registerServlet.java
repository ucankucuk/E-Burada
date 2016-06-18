package com.utkucan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.HibernateDao;
import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.UserModel;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		try {
			UserModel user = new UserModel(name, surname, email, password);
			HibernateDao dao = new HibernateDaoImpl();
			dao.save(user);
			dao.getAllUser();
			response.sendRedirect("login.jsp");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
