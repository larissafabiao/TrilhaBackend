package br.com.zup.trilhabackend.connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
        if (!request.getServletPath().equals("/counter")) {
            ServletContext context = event.getServletContext();
            context.setAttribute("counter", (int) context.getAttribute("counter") + 1);
        }
    }

    // implementations for other methods
}
