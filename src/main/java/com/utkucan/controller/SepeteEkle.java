package com.utkucan.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.HibernateDao;
import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.ProductModel;

/**
 * Servlet implementation class SepeteEkle
 */
@WebServlet("/SepeteEkle")
public class SepeteEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			ArrayList<ProductModel> sepet = (ArrayList<ProductModel>) request.getSession().getAttribute("sepet");
			HibernateDao dao = new HibernateDaoImpl();
			ProductModel p = dao.getProductByID(Integer.parseInt(request.getParameter("ID")));
			sepet.add(p);
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");

		}
	}

}
