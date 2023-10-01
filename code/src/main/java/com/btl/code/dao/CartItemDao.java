package com.btl.code.dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.btl.code.model.CartItem;
import com.btl.code.model.Product;
import com.btl.code.util.HandleException;
import com.btl.code.util.HashPassword;

public class CartItemDao {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException {
//        CartItemDao cartItemDao = new CartItemDao();
//        List<CartItem> list = cartItemDao.getAllItemInCart(2);
//        list.forEach(System.out::println);
//        System.out.println(HashPassword.hashPassword("password1"));
        new CartItemDao().deleteItemInCart(2);
    }
    public List<CartItem> getAllItemInCart(Integer userId) throws ClassNotFoundException {
        List<CartItem> products = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM cart_item WHERE user_id = ?;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setInt(1,userId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                products.add(new CartItem(
                        result.getInt(1),
                        result.getInt(2),
                        result.getInt(3),
                        result.getInt(4)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return products;
    }

    public void addItemInCart(Integer userId, Integer productId, Integer quantity) throws ClassNotFoundException {
        String QUERY_SQL = "INSERT INTO cart_item(quantity,user_id,product_id) VALUES(?,?,?);";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setInt(1,quantity);
            statement.setInt(2,userId);
            statement.setInt(3,productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }

    public void deleteItemInCart(Integer userId) throws ClassNotFoundException {
        String QUERY_SQL = "DELETE FROM cart_item WHERE user_id=?;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setInt(1,userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }
}
