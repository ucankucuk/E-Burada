package com.utkucan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.HibernateDao;
import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.helper.Constant;
import com.utkucan.model.ProductModel;
import com.utkucan.model.UserModel;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HibernateDao dao = new HibernateDaoImpl();
		List<UserModel> user = dao.getUserByUserEmail(email);

		if (!user.isEmpty() && user.get(0).getUSER_EMAIL().equals(email) && user.get(0).getUSER_PASS().equals(password)
				&& user.get(0).getAUTORIZATION_ID() == Constant.getUserAutorizationId()) {
			request.getSession().setAttribute("user", user.get(0));
			request.getSession().setAttribute("sepet", new ArrayList<ProductModel>());
			response.sendRedirect("index.jsp");
		} else if (!user.isEmpty() && user.get(0).getUSER_EMAIL().equals(email)
				&& user.get(0).getUSER_PASS().equals(password)
				&& user.get(0).getAUTORIZATION_ID() == Constant.getUserAutorizationId()) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("admin.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}
}
