package com.utkucan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.impl.HibernateDaoImpl;

/**
 * Servlet implementation class getAjaxSiparisSayisi
 */
@WebServlet("/getAjaxSiparisSayisi")
public class GetAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HibernateDaoImpl impl = new HibernateDaoImpl();
			int siparisSayisi = impl.getAjax();
			response.getWriter().print(String.valueOf(siparisSayisi));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
