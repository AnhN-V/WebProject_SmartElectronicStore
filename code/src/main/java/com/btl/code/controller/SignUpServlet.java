package com.btl.code.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.UserDao;
import com.btl.code.util.HashPassword;
import com.google.gson.Gson;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String role = "ROLE_USER";
        new UserDao().addUser(email.trim(), HashPassword.hashPassword(password.trim()),first_name.trim(),last_name.trim(),role.trim());
//        req.setAttribute("status","3");
//        req.getRequestDispatcher("login.jsp").forward(req, resp);
        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(gson.toJson(email));
    }
}
