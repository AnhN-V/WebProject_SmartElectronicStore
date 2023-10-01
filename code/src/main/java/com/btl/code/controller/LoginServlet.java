package com.btl.code.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.btl.code.dao.UserDao;
import com.btl.code.model.User;
import com.btl.code.util.HashPassword;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        User user = null;
        try {
            user = new UserDao().getUserByEmail(username.trim());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(user == null) {
            req.setAttribute("status","1");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        if(user != null && !user.getPassword().trim().equals(HashPassword.hashPassword(password))) {
            req.setAttribute("status","2");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        if(user != null && user.getPassword().trim().equals(HashPassword.hashPassword(password))) {
            if(remember != null) {
                Cookie cUserName = new Cookie("cookuser", username.trim());
                Cookie cPassword = new Cookie("cookpass", password.trim());
                Cookie cRemember = new Cookie("cookrem", remember.trim());
                cUserName.setMaxAge(60 * 60 * 24 * 15);// 15 days
                cPassword.setMaxAge(60 * 60 * 24 * 15);
                cRemember.setMaxAge(60 * 60 * 24 * 15);
                resp.addCookie(cUserName);
                resp.addCookie(cPassword);
                resp.addCookie(cRemember);
            }
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(180 * 60);
            session.setAttribute("username", username);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
