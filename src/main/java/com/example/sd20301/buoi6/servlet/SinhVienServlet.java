package com.example.sd20301.buoi6.servlet;

import java.io.*;

import com.example.sd20301.buoi6.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SinhVienServletServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/xoa",// dinh nghia la phuong thuc get => viet vao doGet

})
public class SinhVienServlet extends HttpServlet {
    SinhVienService sinhVienService = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(request, response);
        }else if (uri.contains("xoa")){
            xoa(request, response);
        }
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // thuc hien xoa theo id cua sinh vien
        // lay id cua sinh vien nhw the nao ?
        // ten tham so se la "id"
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id la :"+id);
        sinhVienService.deleteSinhVien(id);
        // sau khi xoa xong => quay lai trang hien thi
        // sendRedirect mo ra duong dan servlet co san
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSach", sinhVienService.getAll());
        request.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}