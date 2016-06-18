package com.utkucan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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
		response.setContentType("image/jpeg");
		File file = new File("/log/" + name);
		response.setContentLength((int) file.length());

		FileInputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) >= 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}
}
