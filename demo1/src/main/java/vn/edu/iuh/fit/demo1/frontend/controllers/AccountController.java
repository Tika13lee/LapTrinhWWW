package vn.edu.iuh.fit.demo1.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.demo1.backend.data.entities.Account;
import vn.edu.iuh.fit.demo1.frontend.models.AccountModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AccountController", value = "/accountController")
public class AccountController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("add")) {
            String id = req.getParameter(("id"));
            String us = req.getParameter(("username"));
            String pw = req.getParameter(("password"));

            try {
                AccountModel accountModel = new AccountModel();
                Account account = new Account(id, us, pw);
                if (accountModel.addAccount(account)) {
                    List<Account> accounts = accountModel.getAccounts();
                    req.setAttribute("accounts", accounts);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } else {
                    resp.getWriter().println("Account added failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("delete")) {
            String id = req.getParameter("id");
            AccountModel accountModel = new AccountModel();
            if (accountModel.deleteAccount(id)) {
                List<Account> accounts = accountModel.getAccounts();
                req.setAttribute("accounts", accounts);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                resp.getWriter().println("Account delete failed");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(("action"));
        AccountModel accountModel = new AccountModel();
        if (action.equalsIgnoreCase("list")) {
            req.setAttribute("accounts", accountModel.getAccounts());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        if (action.equalsIgnoreCase("search")) {
            String select = req.getParameter("select");
            String input = req.getParameter("search");
            if (select.equalsIgnoreCase("username")) {
                if (input.equalsIgnoreCase("")) {
                    req.setAttribute("accounts", null);
                } else {
                    req.setAttribute("accounts", accountModel.getAccountsByUsername(input));
                }
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else if (select.equalsIgnoreCase("id")) {
//                resp.getWriter().println(accountModel.getAccountById(input));
                if (input.equalsIgnoreCase("")) {
                    req.setAttribute("accounts", null);
                } else {
                    List<Account> accounts = new ArrayList<>();
                    accounts.add(accountModel.getAccountById(input));
                    req.setAttribute("accounts", accounts);
                }
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
    }
}
