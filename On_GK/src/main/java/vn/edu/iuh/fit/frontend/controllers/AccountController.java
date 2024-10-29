package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.data.entities.Account;
import vn.edu.iuh.fit.frontend.models.AccountModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountController", urlPatterns = "/account")
public class AccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            try {
                AccountModel accountModel = new AccountModel();
                Account account = new Account(username, password);
                if (accountModel.addAccount(account)) {
                    List<Account> accounts = new AccountModel().getAllAccount();
                    req.setAttribute("accountList", accounts);
                    req.getRequestDispatcher("listAccount.jsp").forward(req, resp);
                } else
                    resp.getWriter().println("Failed to save account");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                AccountModel accountModel = new AccountModel();
                if (accountModel.deleteAccount(id)) {
                    List<Account> accounts = new AccountModel().getAllAccount();
                    req.setAttribute("accountList", accounts);
                    req.getRequestDispatcher("listAccount.jsp").forward(req, resp);
                } else
                    resp.getWriter().println("Failed to delete account");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (action.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            try {
                AccountModel accountModel = new AccountModel();
                Account account = new Account(id, username, password);
                if (accountModel.updateAccount(account)) {
                    List<Account> accounts = new AccountModel().getAllAccount();
                    req.setAttribute("accountList", accounts);
                    req.getRequestDispatcher("listAccount.jsp").forward(req, resp);
                } else
                    resp.getWriter().println("Failed to update account");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (action.equals("switchUpdate")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("id", id);
            req.getRequestDispatcher("updateAccount.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountModel accountModel = new AccountModel();
        String action = req.getParameter("action");
        if (action.equals("list")) {
            req.setAttribute("accountList", accountModel.getAllAccount());
            req.getRequestDispatcher("listAccount.jsp").forward(req, resp);
        }
        else if (action.equals("filter")) {

            String method = req.getParameter("select");
            List<Account> listResult;
            if (method.equalsIgnoreCase("balance")) {
                int input = Integer.parseInt(req.getParameter("input"));
                listResult = accountModel.findByBalance(input, input);
            } else {
                String name = req.getParameter("input");
                listResult = accountModel.getByUsername(name);
            }
            req.setAttribute("listAcc", listResult);
            req.getRequestDispatcher("filter.jsp").forward(req, resp);
        }
    }
}
