package com.example.sd20301.luyentap.servlet;

import java.io.*;

import com.example.sd20301.luyentap.model.SinhVien;
import com.example.sd20301.luyentap.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SinhVienServletServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/them",
        "/sinh-vien/xoa",
        "/sinh-vien/cap-nhat",
        "/sinh-vien/chi-tiet"
})
public class SinhVienServlet extends HttpServlet {

    SinhVienService sinhVienService = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            hienThi(request, response);
        } else if (uri.contains("xoa")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            sinhVienService.deleteSinhVien(id);
            response.sendRedirect("/sinh-vien/hien-thi");
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lay danh sach sinh vien
        request.setAttribute("list", sinhVienService.getSinhVien());
        request.getRequestDispatcher("/sinh-vien/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("them")) {
            String hoTen = request.getParameter("hoTen");
            String diaChi = request.getParameter("diaChi");
            String gioiTinh = request.getParameter("gioiTinh");
            Boolean trangThai = Boolean.parseBoolean(request.getParameter("trangThai"));
            SinhVien sv = new SinhVien(hoTen, diaChi, gioiTinh, trangThai);
            sinhVienService.insertSinhVien(sv);
            response.sendRedirect("/sinh-vien/hien-thi");
        }
    }
}