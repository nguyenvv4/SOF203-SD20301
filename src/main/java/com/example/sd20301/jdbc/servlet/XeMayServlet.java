package com.example.sd20301.jdbc.servlet;

import java.io.*;

import com.example.sd20301.jdbc.service.XeMayService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "XeMayServletServlet", value = {
        "/xe-may/hien-thi",
})
public class XeMayServlet extends HttpServlet {

    XeMayService xeMayService = new XeMayService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi danh sach 10 xe may
            hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listXm", xeMayService.getList());
        request.getRequestDispatcher("/xe-may/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}