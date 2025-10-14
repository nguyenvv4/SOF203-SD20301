package com.example.sd20301.jdbc.servlet;

import java.io.*;

import com.example.sd20301.jdbc.model.XeMay;
import com.example.sd20301.jdbc.service.XeMayService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "XeMayServletServlet", value = {
        "/xe-may/hien-thi",
        "/xe-may/them", // POST
        "/xe-may/view-update", // GET
        "/xe-may/sua", // POST
        "/xe-may/xoa", // GET
})
public class XeMayServlet extends HttpServlet {

    XeMayService xeMayService = new XeMayService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi danh sach 10 xe may
            hienThi(request, response);
        } else if(uri.contains("view-update")) {
            viewUpdate(request, response);
        } else if(uri.contains("xoa")) {
            xoa(request, response);
        }
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String soKhung = request.getParameter("soKhung");
        xeMayService.deleteXeMay(soKhung);
        response.sendRedirect("/xe-may/hien-thi");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String soKhung = request.getParameter("soKhung");
        XeMay xeMay = xeMayService.getXeMayBySoKhung(soKhung);
        request.setAttribute("xeMay", xeMay);
        request.getRequestDispatcher("/xe-may/view-update.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listXm", xeMayService.getList());
        request.getRequestDispatcher("/xe-may/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("them")) {
            themXemMay(request, response);
        } else if(uri.contains("sua")) {
            suaXemMay(request, response);
        }
    }

    private void suaXemMay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String soKhung = request.getParameter("soKhung");
        String soMay = request.getParameter("soMay");
        Integer phanKhoi = Integer.valueOf(request.getParameter("phanKhoi"));
        Float khoiLuong = Float.valueOf(request.getParameter("khoiLuong"));
        Boolean trangThai = Boolean.valueOf(request.getParameter("trangThai"));
        XeMay xm = new XeMay(soKhung, soMay, phanKhoi, khoiLuong, trangThai);
        xeMayService.updateXeMay(xm);

        response.sendRedirect("/xe-may/hien-thi");
    }

    private void themXemMay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String soKhung = request.getParameter("soKhung");
        String soMay = request.getParameter("soMay");
        Integer phanKhoi = Integer.valueOf(request.getParameter("phanKhoi"));
        Float khoiLuong = Float.valueOf(request.getParameter("khoiLuong"));
        Boolean trangThai = Boolean.valueOf(request.getParameter("trangThai"));
        XeMay xm = new XeMay(soKhung, soMay, phanKhoi, khoiLuong, trangThai);
        xeMayService.themXeMay(xm);

        response.sendRedirect("/xe-may/hien-thi");
    }
}