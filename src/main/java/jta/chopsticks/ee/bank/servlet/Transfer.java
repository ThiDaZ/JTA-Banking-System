package jta.chopsticks.ee.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Transfer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sourceAccount = req.getParameter("sourceAccountNo");
        String DestinationAccount = req.getParameter("DestinationAccountNo");
        String amount = req.getParameter("amount");

    }
}
