package com.btl.code.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.btl.code.model.Order;
import com.btl.code.model.OrderDetail;
import com.btl.code.util.HandleException;

public class OrderDetailDao {
    public static void main(String[] args) {
//        new OrderDetailDao().addOrder(1,"A");
//        List<OrderDetail> orderDetails = new OrderDetailDao().getOrderDetail(1);
//        orderDetails.forEach(System.out::println);
        System.out.println(new OrderDetailDao().getProductName(1));
    }

    public void addOrder (Integer order_id, String product_name) {
        String QUERY_SQL = "INSERT INTO test_db.order_detail(order_id,product_name) VALUES (?,?);";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setInt(1,order_id);
            statement.setString(2,product_name);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }

    public List<OrderDetail> getOrderDetail (Integer order_id) {
        List<OrderDetail> orders = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM test_db.order_detail WHERE order_id=?;";
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setInt(1,order_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(new OrderDetail(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return orders;
    }

    public String getProductName(Integer order_id) {
        List<OrderDetail> orderDetails = new OrderDetailDao().getOrderDetail(order_id);
        String res = "";
        if (orderDetails.isEmpty() || orderDetails == null){
            return res;
        }
        for (OrderDetail orderDetail : orderDetails) {
            res+=orderDetail.getProductName()+", ";
        }
        return res.substring(0,res.length()-2);
    }
}
