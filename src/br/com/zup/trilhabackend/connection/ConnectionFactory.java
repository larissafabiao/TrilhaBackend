package br.com.zup.trilhabackend.connection;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ConnectionFactory extends HttpServlet {
	private static String message;
	
	public void init() throws ServletException {
		//required initialization
		message = "Hello World - Servlet";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}
	
	public void destroy() {
		//do nothing
	}
	
}
