package com.btl.code.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.btl.code.model.Order;
import com.btl.code.util.HandleException;

public class OrderDao {
    public static void main(String[] args) throws ClassNotFoundException {
        OrderDao orderDao = new OrderDao();
        Integer orderId = orderDao.addOrder(new Date(System.currentTimeMillis()),"IN_PROGRESS",150,1);
        System.out.println(orderId);
    }
    public int addOrder (Date order_time, String status, Integer total, Integer user_id) {
        String QUERY_SQL = "INSERT INTO test_db.order(order_time,status,total,user_id) VALUES (?,?,?,?);";
        String QUERY_GETID = "SELECT LAST_INSERT_ID();";
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                Statement getId = connection.createStatement();
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setDate(1,order_time);
            statement.setString(2,status);
            statement.setInt(3,total);
            statement.setInt(4,user_id);
            statement.executeUpdate();
            ResultSet resultSet = getId.executeQuery(QUERY_GETID);
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return 0;
    }

    public List<Order> getOrder (Integer user_id) throws ClassNotFoundException {
        List<Order> orders = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM test_db.order WHERE user_id=?;";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setInt(1,user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return orders;
    }

    public List<Order> getAllOrder () throws ClassNotFoundException {
        List<Order> orders = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM test_db.order";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_SQL);
            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return orders;
    }
}
