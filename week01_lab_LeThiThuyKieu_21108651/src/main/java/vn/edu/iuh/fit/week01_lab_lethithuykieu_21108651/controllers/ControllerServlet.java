package vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.services.AccountService;

import java.io.IOException;

@WebServlet(name = "controllerServlet", value = "/login")
public class ControllerServlet extends HttpServlet {
    private AccountService accountService = new AccountService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("us");
        String password = req.getParameter("pw");

        if (accountService.checkLogin(username, password)) {
            resp.sendRedirect("dashboard.html");
        } else {
            resp.getWriter().println("<html><body><h1>Login failed</h1></body>");
        }
    }
}
