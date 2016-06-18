package com.utkucan.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetImage
 */
@WebServlet("/resimgetir")
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("mresim");
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File("/tmp/" + name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStream out = response.getOutputStream();
		ImageIO.write(img, "jpg", out);
		out.close();
	}
}
