package com.btl.code.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cUserName = new Cookie("cookuser", null);
        Cookie cPassword = new Cookie("cookpass", null);
        Cookie cRemember = new Cookie("cookrem", null);
        cUserName.setMaxAge(0);
        cPassword.setMaxAge(0);
        cRemember.setMaxAge(0);
        resp.addCookie(cUserName);
        resp.addCookie(cPassword);
        resp.addCookie(cRemember);
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
