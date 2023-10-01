package com.btl.code.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btl.code.dao.UserDao;
import com.btl.code.model.User;
import com.btl.code.util.EmailUtility;
import com.btl.code.util.HashPassword;
import com.btl.code.util.RandomString;

@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String newPassword= RandomString.random();
        User user = null;
        try {
            user = new UserDao().getUserByEmail(email);
            new UserDao().updatePassword(user.getId(), HashPassword.hashPassword(newPassword));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(user == null) {
            req.setAttribute("status", "6");
        } else {
            ServletContext context = getServletContext();
            String host = context.getInitParameter("host");
            String port = context.getInitParameter("port");
            String users = context.getInitParameter("user");
            String pass = context.getInitParameter("pass");
            String recipient = email;
            String subject = "Reset Password";
            String content = "<span>New password is: "+newPassword+"</span>" +
                    "    <br>" +
                    "    <span><a href=\"http://localhost:8080/login.jsp\">Click this link to login with new password</a></span>";
            try {
                EmailUtility.sendEmail(host, port, users, pass, recipient, subject,
                        content);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            req.setAttribute("status", "7");
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
