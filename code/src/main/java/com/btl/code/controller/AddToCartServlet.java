package com.btl.code.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.CartItemDao;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId = Integer.valueOf(req.getParameter("productId"));
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        Integer userId = Integer.valueOf(req.getParameter("userId"));
        try {
            new CartItemDao().addItemInCart(userId,productId,quantity);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
