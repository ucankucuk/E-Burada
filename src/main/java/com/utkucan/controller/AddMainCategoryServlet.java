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
import com.utkucan.model.SuperCategoryModel;

/**
 * Servlet implementation class AddMainCategoryServlet
 */
@WebServlet("/AddMainCategoryServlet")
public class AddMainCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMainCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String CATEGORY_NAME = request.getParameter("ad");
		
		SuperCategoryModel s = new SuperCategoryModel();
		s.setCategoryId(Integer.parseInt(id));
		
		try {
			HibernateDao dao = new HibernateDaoImpl();
			MainCategoryModel cargoFirm = new MainCategoryModel(CATEGORY_NAME, s);
			dao.save(cargoFirm);
			response.sendRedirect("category.jsp");
		} catch (Exception e) {
		}
	}

}
