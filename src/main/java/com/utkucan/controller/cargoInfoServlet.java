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
import com.utkucan.model.CargoModel;

/**
 * Servlet implementation class cargoInfoServlet
 */
@WebServlet("/cargoInfoServlet")
public class cargoInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sCargoID = request.getParameter("cargoID");
		int cargoID = Integer.parseInt(sCargoID);
		
		try {
			request.getSession().removeAttribute("cargoInfo");
			HibernateDao dao = new HibernateDaoImpl();
			CargoModel cargo = (CargoModel) dao.getCargoByID(cargoID).get(0);
			HttpSession session = request.getSession();
			session.setAttribute("cargoInfo", cargo);
			response.sendRedirect("cargo.jsp");
			
		} catch (Exception e) {
			System.out.println("Kargo Bilgisi G�sterilemedi!");
		}
		
	}

}
