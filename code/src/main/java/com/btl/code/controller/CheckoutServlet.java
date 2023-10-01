package com.btl.code.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.CartItemDao;
import com.btl.code.dao.OrderDao;
import com.btl.code.dao.OrderDetailDao;
import com.btl.code.dao.ProductDao;
import com.btl.code.model.CartItem;
import com.btl.code.model.Product;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Integer.valueOf(req.getParameter("userId"));
        List<CartItem> cartItems = null;
        try {
            cartItems = new CartItemDao().getAllItemInCart(userId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int total = 0;
        for(CartItem cartItem : cartItems) {
            Product product = null;
            try {
                product = new ProductDao().getProductById(cartItem.getProductId());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            total += cartItem.getQuantity()*product.getPrice();
        }
        Integer orderId =  new OrderDao().addOrder(new Date(System.currentTimeMillis()),"IN_PROGRESS",total,userId);
        for(CartItem cartItem : cartItems) {
            Product product = null;
            try {
                product = new ProductDao().getProductById(cartItem.getProductId());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            new OrderDetailDao().addOrder(orderId,product.getName());
        }
        try {
            new CartItemDao().deleteItemInCart(userId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("title","Check out successful!");
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }
}
