package com.btl.code.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.CategoryDao;
import com.btl.code.dao.ProductDao;
import com.btl.code.model.Category;
import com.btl.code.model.Product;

@WebServlet("/categories")
public class ShopCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryId = Integer.valueOf(req.getParameter("category"));
        ProductDao productDao = new ProductDao();
        List<Product> products = null;
        try {
            products = productDao.getAllProductByCategoryId(categoryId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Category category = null;
        try {
            category = new CategoryDao().getCategoryById(categoryId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("products",products);
        req.setAttribute("title","All product in "+category.getName());
        req.getRequestDispatcher("shop.jsp").forward(req, resp);
    }
}
