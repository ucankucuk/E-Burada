package com.utkucan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.HibernateDao;
import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.MainCategoryModel;
import com.utkucan.model.SubCategoryModel;

/**
 * Servlet implementation class SubCategoryServlet
 */
@WebServlet("/SubCategoryServlet")
public class SubCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String CATEGORY_NAME = request.getParameter("ad");
		
		MainCategoryModel s = new MainCategoryModel();
		s.setMainCategoryId(Integer.parseInt(id));
		
		try {
			HibernateDao dao = new HibernateDaoImpl();
			SubCategoryModel cargoFirm = new SubCategoryModel(CATEGORY_NAME, s);
			dao.save(cargoFirm);
			response.sendRedirect("category.jsp");
		} catch (Exception e) {
		}
	}

}
