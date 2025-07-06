package jta.chopsticks.ee.bank.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {"/home.jsp"})
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse ServletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse response = (HttpServletResponse) ServletResponse;
        if(req.getSession().getAttribute("user") == null) {
            chain.doFilter(request, ServletResponse);
        }else{
            response.sendRedirect("login.jsp");
        }
    }

}
