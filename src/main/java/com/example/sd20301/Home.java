package com.example.sd20301;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HomeServlet", value = {"/Home-servlet",
        "/login",
})
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home-login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lay gia tri cua o input
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        // kiem tra username/password
        if (username.equals("admin") && password.equals("admin")) {
            // mo trang jsp login thanh cong
            request.getRequestDispatcher("thanh-cong.jsp").forward(request, response);
        } else {
            // in ra loi
            System.out.println("Login failed");
        }
    }
}