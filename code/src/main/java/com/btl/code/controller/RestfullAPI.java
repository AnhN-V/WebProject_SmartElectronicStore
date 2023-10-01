package com.btl.code.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.UserDao;
import com.btl.code.model.Category;
import com.btl.code.model.User;
import com.google.gson.Gson;

@WebServlet("/checkUniqueEmail")
public class RestfullAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        User user = null;
        try {
            user = new UserDao().getUserByEmail(email);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean isExistEmail = user == null ? false : true;
        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(gson.toJson(isExistEmail));
    }
}
