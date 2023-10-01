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

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        List<Product> products = null;
        int page = Integer.parseInt(req.getParameter("page"));
        int size = 8;
        int totalPage;
        try {
            totalPage =  (float)productDao.getAllProduct().size() / size == productDao.getAllProduct().size() / size ?
                    productDao.getAllProduct().size() / size : productDao.getAllProduct().size() / size + 1;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            products = productDao.getPageProduct(page,size);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("products",products);
        req.setAttribute("title","All product");
        req.getRequestDispatcher("shop.jsp").forward(req, resp);
    }
}
