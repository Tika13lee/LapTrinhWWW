package vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.entities.Account;
import vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.services.AccountService;

import java.io.IOException;

@WebServlet(name = "controllerServlet", value = {"/login"})
public class ControllerServlet extends HttpServlet {
    private final AccountService accountService = new AccountService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("us");
        System.out.println(username);
        String password = req.getParameter("pw");

        if (accountService.checkLogin(username, password)) {
//            resp.sendRedirect("dashboard.html");
            Account account = accountService.getAccountById(username);
            req.getSession().setAttribute("account", account);
            resp.sendRedirect("dashboard.jsp");
        } else {
            resp.getWriter().println("<html><body><h1>Login failed</h1></body>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("us");
        Account account = accountService.getAccountById(username);
        req.setAttribute("account", account);
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }
}
