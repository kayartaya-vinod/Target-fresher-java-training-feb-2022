package com.targetindia.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String html = "<h1>Hello, world!</h1>";
		html += "<hr />";
		html += "<p>This output is coming from a Java Servlet Object</p>";
		
		PrintWriter writer = resp.getWriter();
		writer.write(html);
		writer.close();
		
	}
}
