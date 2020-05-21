package br.com.zup.trilhabackend.connection;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(urlPatterns = "/teste", name = "testeSer")
public class ConnectionFactory extends HttpServlet {
    
	/**
     * 
     */
    private static final long serialVersionUID = 3993201784881460345L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        
		response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>TESTE COMANDO ECLIPSE</h1>");
			out.println("</body></html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
