package com.btl.code.controller;

import com.btl.code.dao.UserDAO;
import com.btl.code.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // Get user, pass from cookie
        Cookie arr[] = request.getCookies();
        if (arr != null){
            for (Cookie o : arr){
                if (o.getName().equals("userC")){
                    request.setAttribute("username", o.getValue());
                }
                if (o.getName().equals("passC")){
                    request.setAttribute("password", o.getValue());
                }
            }
        }


        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // get parameter from HTML
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        // using cookie for save account
        Cookie u = new Cookie("userC", userName);
        Cookie p = new Cookie("passC", password);
        Cookie r = new Cookie("rC", remember);
        // set time storing for username
        u.setMaxAge(60 * 60 * 24 * 30);
        // if remember == null: don't save password
        if (remember != null){
            p.setMaxAge(60 * 60 * 24 * 30);
        }
        else {
            p.setMaxAge(0);
        }
        // Save to brower
        response.addCookie(u);
        response.addCookie(p);


        // Check valid userName and password
        HttpSession httpSession = request.getSession();
        if (userName != null && password != null){
            UserDAO userDAO = new UserDAO();
            User a = userDAO.login(userName, password);


            if (a == null) {
                request.setAttribute("error", "Wrong usename or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                httpSession.setAttribute ("account", a);
                request.getRequestDispatcher ("main.jsp").forward (request, response);

            }
        }
    }
}
