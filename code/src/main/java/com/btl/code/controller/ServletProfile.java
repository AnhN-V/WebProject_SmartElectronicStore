package com.btl.code.controller;

import com.btl.code.dao.UserDao;
import com.btl.code.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletProfile", value = "/profile")
public class ServletProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        UserDao userDao = new UserDao();
        try {
            User user = userDao.getUserByEmail(username);
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        try {
            User user = new UserDao().getUserByEmail(username);
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            new UserDao().updateName(user.getId(), firstName, lastName);
            session.setAttribute("status", "8");
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
