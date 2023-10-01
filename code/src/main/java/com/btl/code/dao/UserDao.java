package com.btl.code.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.btl.code.model.Category;
import com.btl.code.model.User;
import com.btl.code.util.HandleException;
import com.btl.code.util.HashPassword;
import com.btl.code.util.RandomString;

public class UserDao {
    public static void main(String[] args) throws ClassNotFoundException {
//        User user = new UserDao().getUserByEmail("admin@example.com");
//        System.out.println(user);
//        new UserDao().addUser("vietanhnguyenit201002@gmail.com","12345","Nguyen","Viet Anh","ROLE_ADMIN");
//        new UserDao().updatePassword(1,"12345");
        System.out.println(HashPassword.hashPassword("kfannwtann"));
        new UserDao().updatePassword(32, HashPassword.hashPassword("kfannwtann"));
    }
    public List<User> getAllUser () {
        List<User> userList = new ArrayList<>();
        String SELECT_USERS_SQL = "SELECT * FROM user;";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db?useSSL=false", "root", "");
                Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(SELECT_USERS_SQL);
            while (result.next()) {
                userList.add(new User(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7)
                        ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return userList;
    }

    public User getUserByEmail(String email) throws ClassNotFoundException {
        User user = null;
        String QUERY_SQL = "SELECT * FROM user WHERE email = ?;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {

            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                user = new User(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7)
                );}
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return user;
    }

    public void addUser (String email,String password,String first_name,String last_name,String role) {
        String INSERT_USERS_SQL = "INSERT INTO user(email,password,first_name,last_name,role) VALUES (?,?,?,?,?);";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db?useSSL=false", "root", "");
                PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL)) {
                statement.setString(1,email);
                statement.setString(2,password);
                statement.setString(3,first_name);
                statement.setString(4,last_name);
                statement.setString(5,role);
                statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }

    public void deleteUser(Integer userId) {
        String QUERY_SQL = "DELETE FROM user WHERE id=?;";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setInt(1,userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }

    public void updatePassword (Integer id,String password) {
        String INSERT_PRODUCT_SQL = "UPDATE test_db.user SET password =? WHERE id=?;";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            statement.setString(1, password);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }

    public void updateName (Integer id,String fName, String lName) {
        String INSERT_PRODUCT_SQL = "UPDATE test_db.user SET first_name = ?, last_name = ? WHERE id = ?;";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            statement.setString(1, fName);
            statement.setString(2, lName);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }
}
