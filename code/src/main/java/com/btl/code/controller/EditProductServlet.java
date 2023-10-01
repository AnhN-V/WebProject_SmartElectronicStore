package com.btl.code.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.ProductDao;
import com.btl.code.model.Product;

@WebServlet("/edit-product")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId = Integer.valueOf(req.getParameter("productId"));
        Product product = null;
        try {
            product = new ProductDao().getProductById(productId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("product",product);
        req.getRequestDispatcher("popup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("productId"));
        String name = req.getParameter("name_product");
        String description = req.getParameter("description_product");
        String image = req.getParameter("img_product");
        Integer price = Integer.valueOf(req.getParameter("price_product"));
        Integer category_id = Integer.valueOf(req.getParameter("category_id"));
        new ProductDao().updateProduct(id,name,description,image,price,category_id);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
