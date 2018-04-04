package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String verify = request.getParameter("verify");
        if (password.equals(verify)) {
            System.out.println("Password and verify match!!");
            try {
                User user = DaoFactory.getUsersDao().findByUsername(username);
                if (user != null) {
                    System.out.println("Name is already taken!");
                } else {
                    user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);
                    System.out.println(user.getUsername());
                    System.out.println(user.getPassword());
                    System.out.println(user.getEmail());
                    DaoFactory.getUsersDao().insert(user); // never hits this
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("/profile");
                }
            } catch (SQLException e) {
                System.out.println("Something happened to the database!!" + e.getMessage());
            }
        } else {
            try {
                response.sendRedirect("/register");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
    }
}
