package com.utkucan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utkucan.dao.HibernateDao;
import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.UserModel;

/**
 * Servlet implementation class userInformationServlet
 */
@WebServlet("/userInformationServlet")
public class userInformationServlet extends HttpServlet {
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
		String email = request.getParameter("userEmail");
		HibernateDao dao = new HibernateDaoImpl();
		UserModel user = (UserModel) dao.getUserByUserEmail(email).get(0);
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", user);
		response.sendRedirect("userOperation.jsp");

	}

}
