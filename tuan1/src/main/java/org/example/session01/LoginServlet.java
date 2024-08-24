package org.example.session01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.session01.bean.LoginBean;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginBean loginBean = new LoginBean();
        int result = loginBean.Login(username, password);
        PrintWriter out = resp.getWriter();
        if (result == 1) {
            out.println("<h1>Login Success<h1>");
        } else if (result == 0) {
            out.println("<h1>Login Failed<h1>");
        } else {
            out.println("<h1>Invalid User<h1>");
        }
    }
}
