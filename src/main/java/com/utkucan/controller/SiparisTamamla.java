package com.utkucan.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.CargoModel;
import com.utkucan.model.OrderModel;
import com.utkucan.model.ProductModel;
import com.utkucan.model.UserModel;

/**
 * Servlet implementation class SiparisTamamla
 */
@WebServlet("/SiparisTamamla")
public class SiparisTamamla extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ProductModel> sepet = (List<ProductModel>) request.getSession().getAttribute("sepet");
		if (sepet != null) {
			HibernateDaoImpl dao = new HibernateDaoImpl();
			UserModel user = (UserModel) request.getSession().getAttribute("user");
			for (ProductModel productModel : sepet) {
				OrderModel om = new OrderModel();
				om.setORDER_ADDRESS("Test Adres");
				om.setORDER_DATE(new Date());
				om.setPIECE(1);
				om.setPRICE(productModel.getPRICE());
				om.setProduct(productModel);
				om.setUSER_ID(user);
				om.setCargo(new CargoModel(1));
				dao.save(om);
			}
			sepet.clear();
		}
		response.sendRedirect("index.jsp");
	}

}
