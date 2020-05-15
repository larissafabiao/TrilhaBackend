package br.com.zup.trilhabackend.connection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/uppercase", name = "uppercaseServlet")
public class UppercaseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String inputString = request.getParameter("input").toUpperCase();

        PrintWriter out = response.getWriter();
        out.println(inputString);
    }
}
