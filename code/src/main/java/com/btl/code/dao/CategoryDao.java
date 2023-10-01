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
import com.btl.code.model.Product;
import com.btl.code.util.HandleException;

public class CategoryDao {
    public static void main(String[] args) throws ClassNotFoundException {
        CategoryDao categoryDao = new CategoryDao();
        Category list = categoryDao.getCategoryById(1);
        System.out.println(list);
//        Category category = categoryDao.getCategoryById(1);
//        System.out.println(category);
    }

    public List<Category> getAllCategory() throws ClassNotFoundException {
        List<Category> categories = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM category;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(QUERY_SQL);
            while (result.next()) {
                categories.add(new Category(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return categories;
    }

    public Category getCategoryById(Integer categoryId) throws ClassNotFoundException {
        Category category = null;
        String QUERY_SQL = "SELECT * FROM category WHERE id = ?;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {

            statement.setInt(1, categoryId);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                category = new Category(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3)
            );}
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return category;
    }
}
