package com.utkucan.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import com.utkucan.dao.HibernateDao;
import com.utkucan.dao.impl.HibernateDaoImpl;
import com.utkucan.model.ProductModel;
import com.utkucan.model.SubCategoryModel;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SecureRandom random = new SecureRandom();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subCategoryId = request.getParameter("subCategoryId");
		String PRODUCT_NAME = request.getParameter("PRODUCT_NAME");
		String PRODUCT_INFO = request.getParameter("PRODUCT_INFO");
		String PRICE = request.getParameter("PRICE");
		Part file = request.getPart("file");
		String fileName = file.getSubmittedFileName();

		ProductModel pModel = new ProductModel();
		pModel.setPRODUCT_NAME(PRODUCT_NAME);
		pModel.setPRODUCT_INFO(PRODUCT_INFO);
		pModel.setPRICE(Double.parseDouble(PRICE));
		pModel.setIMAGE_RESOURCE(PRODUCT_NAME);
		pModel.setSubCategoryId(new SubCategoryModel(Integer.parseInt(subCategoryId)));

		String resimUzantisi = FilenameUtils.getExtension(fileName);
		String sifrelenmisResimAdi = new BigInteger(130, random).toString(32).substring(0, 5).toUpperCase() + "_"
				+ PRODUCT_NAME + "." + resimUzantisi;
		pModel.setIMAGE_RESOURCE(sifrelenmisResimAdi);
		try {
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("/tmp/" + sifrelenmisResimAdi)));
			IOUtils.copy(file.getInputStream(), stream);

			stream.close();
			HibernateDao dao = new HibernateDaoImpl();
			dao.save(pModel);
			System.out.println(pModel.toString());
			response.sendRedirect("Product.jsp");
		} catch (Exception e) {
		}
	}

}
