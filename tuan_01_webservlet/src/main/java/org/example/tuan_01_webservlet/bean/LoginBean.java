package org.example.tuan_01_webservlet.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBean {

//    public int Login(String username, String password) {
//        if (username.equals("admin")) {
//            if (password.equals("admin")) {
//                return 1;
//            } else {
//                return 0;
//            }
//        } else {
//            return -1;
//        }
//    }

    public int Login(String username, String password) {
        try {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            ConnectDB connectDB = new ConnectDB();
            Connection connection = connectDB.getConnection();
            String query = "SELECT * FROM account WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("password").equals(password)) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
