package com.btl.code.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.ProductDao;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name_product");
        String description = req.getParameter("description_product");
        String image = req.getParameter("img_product");
        Integer price = Integer.valueOf(req.getParameter("price_product"));
        Integer category_id = Integer.valueOf(req.getParameter("category_id"));
        new ProductDao().addProduct(name,description,image,price,category_id);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
