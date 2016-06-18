package com.utkucan.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utkucan.dao.HibernateDao;
import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.CargoModel;
import com.utkucan.model.OrderModel;
import com.utkucan.model.ProductModel;
import com.utkucan.model.UserModel;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cargo = request.getParameter("cargo");
		String PIECE = request.getParameter("PIECE");
		String ORDER_ADDRESS = request.getParameter("ORDER_ADDRESS");
		String PRICE = request.getParameter("PRICE");
		String USER_ID = request.getParameter("USER_ID");
		String product = request.getParameter("product");
		
		OrderModel o = new OrderModel();
		o.setPIECE(Integer.parseInt(PIECE));
		o.setPRICE(Double.parseDouble(PRICE));
		o.setORDER_ADDRESS(ORDER_ADDRESS);
		o.setUSER_ID(new UserModel(Integer.parseInt(USER_ID)));
		o.setProduct(new ProductModel(Integer.parseInt(product)));
		o.setCargo(new CargoModel(Integer.parseInt(cargo)));
		o.setORDER_DATE(new Date());
		
		try {
			HibernateDao dao = new HibernateDaoImpl();
			dao.save(o);
			response.sendRedirect("product.jsp");
		} catch (Exception e) {
		}
	}

}
