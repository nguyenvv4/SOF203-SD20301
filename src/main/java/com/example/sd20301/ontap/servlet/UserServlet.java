package com.example.sd20301.ontap.servlet;

import java.io.*;

import com.example.sd20301.ontap.model.User;
import com.example.sd20301.ontap.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UserServletServlet", value = {
        "/user/hien-thi",
        "/user/them",
        "/user/xoa",
        "/user/chi-tiet",
        "/user/cap-nhat"
})
public class UserServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/user/hien-thi")) {
            hienThi(request, response);
        } else if (uri.contains("/user/chi-tiet")) {
            chiTiet(request, response);
        }
    }

    private void chiTiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/ontap/chi-tiet.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", userService.list());
        request.getRequestDispatcher("/ontap/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}