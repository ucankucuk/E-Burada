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
 * Servlet implementation class cargoSyncServlet
 */
@WebServlet("/cargoSyncServlet")
public class cargoSyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	String sCargoID = request.getParameter("CARGO_ID");
	int cargoID = Integer.parseInt(sCargoID);
	String cargoName = request.getParameter("CARGO_NAME");
	String sDesiPrice = request.getParameter("DESI_PRICE");
	double desiPrice = Double.parseDouble(sDesiPrice);
	request.getSession().removeAttribute("cargoInfo");
	
	
	try {
		HibernateDao dao = new HibernateDaoImpl();
		CargoModel cargoFirm = new CargoModel(cargoID, cargoName, desiPrice);
		dao.update(cargoFirm);
		response.sendRedirect("cargo.jsp");

	} catch (Exception e) {
		System.out.println("M��teri G�ncellemede Hata Var");
	}
	}

}
