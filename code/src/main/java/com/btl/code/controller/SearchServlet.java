package com.btl.code.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.ProductDao;
import com.btl.code.model.Product;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Product> products = null;
        try {
            products = new ProductDao().searchAllProductByText(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("products",products);
        if (products.isEmpty()) {
            req.setAttribute("title","Can't find product with: "+name);
        } else {
            req.setAttribute("title","Result of search: "+name);
        }
        req.getRequestDispatcher("shop.jsp").forward(req, resp);
    }
}
