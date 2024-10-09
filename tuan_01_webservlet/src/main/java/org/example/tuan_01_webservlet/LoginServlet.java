package org.example.tuan_01_webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tuan_01_webservlet.bean.LoginBean;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("us");
        String password = req.getParameter("pw");

        LoginBean loginBean = new LoginBean();
        int result = loginBean.Login(username, password);
        PrintWriter out = resp.getWriter();
        if (username.equals("") || password.equals("")) {
            out.println("<html><body>" +
                    "<h1>Username or password are not empty</h1>" +
                    "</body>");
        } else {
            if (result == 1) {
                out.println("<html><body>" +
                        "<h1>Login success</h1>" +
                        "</body>");
            }
            if (result == 0) {
                out.println("<html><body>" +
                        "<h1>Password invalid</h1>" +
                        "</body>");
            }
            if (result == -1) {
                out.println("<html><body>" +
                        "<h1>Username invalid</h1>" +
                        "</body>");
            }
        }
        out.close();
    }
}
