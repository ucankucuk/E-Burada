package com.utkucan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.ProductModel;

@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HibernateDaoImpl dao = new HibernateDaoImpl();
			ProductModel p = dao.getProductByID(Integer.parseInt(request.getParameter("productID")));
			dao.delete(p);
			response.sendRedirect("Product.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
