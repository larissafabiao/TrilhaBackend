package br.com.zup.trilhabackend.connection;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ConnectionFactory extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>Hello Readers</h1>");
			out.println("</body></html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
