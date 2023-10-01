package com.btl.code.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.btl.code.model.Product;
import com.btl.code.util.HandleException;

public class ProductDao {
    public static void main(String[] args) throws ClassNotFoundException {
        ProductDao productDao = new ProductDao();
//        List<Product> list = productDao.searchAllProductByText("64");
//        list.forEach(System.out::println);
//        productDao.addProduct("a","a","a",1,1);
        productDao.updateProduct(70,"b","b","b",2,2);
    }

    public List<Product> getAllProduct() throws ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM product;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(QUERY_SQL);
            while (result.next()) {
                products.add(new Product(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getInt(6)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return products;
    }

    public List<Product> getNewProduct() throws ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM product ORDER BY id DESC LIMIT 8;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(QUERY_SQL);
            while (result.next()) {
                products.add(new Product(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getInt(6)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return products;
    }

    public List<Product> getPageProduct(int page, int size) throws ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM product LIMIT ? OFFSET ?;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {

            statement.setInt(1, size);
            statement.setInt(2,(page-1)*size);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                products.add(new Product(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getInt(6)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return products;
    }

    public List<Product> getAllProductByCategoryId(Integer categoryId) throws ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM product WHERE category_id = ?;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {

            statement.setInt(1, categoryId);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                products.add(new Product(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getInt(6)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return products;
    }

    public Product getProductById(Integer productId) throws ClassNotFoundException {
        Product product = null;
        String QUERY_SQL = "SELECT * FROM product WHERE id = ?;";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {

            statement.setInt(1, productId);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                product = new Product(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getInt(6)
                );
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return product;
    }

    public List<Product> searchAllProductByText(String name) throws ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        String QUERY_SQL = "SELECT * FROM product WHERE name LIKE '%"+name+"%';";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {

//            statement.setString(1, name);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                products.add(new Product(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getInt(6)
                ));
            }
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return products;
    }

    public void deleteProduct(Integer productId) {
        String QUERY_SQL = "DELETE FROM product WHERE id=?;";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
                PreparedStatement statement = connection.prepareStatement(QUERY_SQL)) {
            statement.setInt(1,productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }

    public void addProduct (String name,String description,String image,Integer price,Integer category_id) {
        String INSERT_PRODUCT_SQL = "INSERT INTO product(name,description,image,price,category_id) VALUES (?,?,?,?,?);";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db?useSSL=false", "root", "");
                PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            statement.setString(1,name);
            statement.setString(2,description);
            statement.setString(3,image);
            statement.setInt(4,price);
            statement.setInt(5,category_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }

    public void updateProduct (Integer id,String name,String description,String image,Integer price,Integer category_id) {
        String INSERT_PRODUCT_SQL = "UPDATE product SET name = ?, description = ?,image=?,price=?,category_id=? WHERE id=?;";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/test_db?useSSL=false", "root", "");
                PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            statement.setString(1,name);
            statement.setString(2,description);
            statement.setString(3,image);
            statement.setInt(4,price);
            statement.setInt(5,category_id);
            statement.setInt(6,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
    }
}
