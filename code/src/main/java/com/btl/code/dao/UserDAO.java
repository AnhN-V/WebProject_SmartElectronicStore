package com.btl.code.dao;

import com.btl.code.db.DBConnection;
import com.btl.code.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;


    public User login(String user, String pass){

        String query = "SELECT * FROM user where user_name = ? and password = ?;";
        try {
            conn = new DBConnection().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()){
                return new User(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );

            }
        } catch (Exception e){

        }

        return null;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User a = userDAO.login("john.doe", "p@ssword1");
        System.out.println(a);

    }

}
