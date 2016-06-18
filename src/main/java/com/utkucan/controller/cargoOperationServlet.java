package com.utkucan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.HibernateDao;
import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.CargoModel;

/**
 * Servlet implementation class cargoOperationServlet
 */
@WebServlet("/cargoOperationServlet")
public class cargoOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String CARGO_NAME = request.getParameter("CARGO_NAME");
		String sDESI_PRICE = request.getParameter("DESI_PRICE");
		double DESI_PRICE = Double.parseDouble(sDESI_PRICE);
		
		try {
			HibernateDao dao = new HibernateDaoImpl();
			CargoModel cargoFirm = new CargoModel(CARGO_NAME, DESI_PRICE);
			dao.save(cargoFirm);
			response.sendRedirect("cargo.jsp");
		} catch (Exception e) {
			System.out.println("Kargo Eklemede Hata Var !!");
		}
		
		
	}

}
