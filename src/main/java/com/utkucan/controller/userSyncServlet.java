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
 * Servlet implementation class userSyncServlet
 */
@WebServlet("/userSyncServlet")
public class userSyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String SuID = request.getParameter("uID");
		String SaID = request.getParameter("aID");
		int uID = Integer.parseInt(SuID);
		int aID = Integer.parseInt(SaID);
		String uName = request.getParameter("uName");
		String uSurname = request.getParameter("uSurname");
		String uEmail = request.getParameter("uEmail");
		String uPass = request.getParameter("uPass");
		String uAddress = request.getParameter("uAddress");
		String uOAddress = request.getParameter("uOAddress");
		String uMobile = request.getParameter("uMobile");
		String uOMobile = request.getParameter("uOMobile");

		request.getSession().removeAttribute("userInfo");

		try {
			HibernateDao dao = new HibernateDaoImpl();
			UserModel user = new UserModel(uID, uName, uSurname, uEmail, uPass, uAddress, uOAddress, uMobile, uOMobile,
					aID);
			dao.update(user);
			request.getSession().setAttribute("userInfo", user);
			response.sendRedirect("userOperation.jsp");

		} catch (Exception e) {
			System.out.println("M��teri G�ncellemede Hata Var");
		}

	}

}
