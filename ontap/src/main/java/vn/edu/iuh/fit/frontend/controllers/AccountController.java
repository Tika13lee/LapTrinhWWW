package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.data.entities.Account;
import vn.edu.iuh.fit.frontend.models.AccountModel;

import java.io.IOException;

@WebServlet(name = "AccountController", value = "/account")
public class AccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action.equals("add_account")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            try {
                AccountModel accountModel = new AccountModel();
                Account account = new Account(username, password, true);
                accountModel.addAccount(account);
                resp.getWriter().println("Account saved");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
