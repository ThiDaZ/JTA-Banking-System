package jta.chopsticks.ee.bank.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jta.chopsticks.ee.bank.ejb.remote.RegisterService;

import java.io.IOException;

@WebServlet("/signup")
public class Signup extends HttpServlet {

    @EJB
    private RegisterService registerService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        registerService.registerUser(name, email, password);

        resp.sendRedirect("login.jsp");

    }
}
