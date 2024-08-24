package org.example.session01.bean;

public class LoginBean {
    public int Login(String username, String password) {
        if (username.equals("admin")) {
            if (password.equals("admin")) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
}
