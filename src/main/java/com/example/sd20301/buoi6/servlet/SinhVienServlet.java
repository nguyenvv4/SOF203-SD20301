package com.example.sd20301.buoi6.servlet;

import java.io.*;

import com.example.sd20301.buoi6.model.SinhVien;
import com.example.sd20301.buoi6.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SinhVienServletServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/xoa",// dinh nghia la phuong thuc get => viet vao doGet
        "/sinh-vien/them", //them moi 1 sv. dinh nghia phuong thuc la Post => viet trong doPost
        "/sinh-vien/chi-tiet", // hien thi chi tiet 1 sinh vien => dinh nghia la doGet
        "/sinh-vien/cap-nhat"// doPost

})
public class SinhVienServlet extends HttpServlet {
    SinhVienService sinhVienService = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            hienThi(request, response);
        } else if (uri.contains("xoa")) {
            xoa(request, response);
        } else if (uri.contains("/sinh-vien/chi-tiet")) {
            chiTiet(request, response);
        }
        // hien thi chi tiet sinh vien
    }

    private void chiTiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lay id cua sinh vien
        Integer id = Integer.parseInt(request.getParameter("id"));
        // lay thong tin sinh vien theo id
        request.setAttribute("sinhVien", sinhVienService.getDetail(id));
        // lay lai danh sach ban dau
        request.setAttribute("danhSach", sinhVienService.getAll());
        request.getRequestDispatcher("/buoi6/chi-tiet.jsp").forward(request, response);

    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // thuc hien xoa theo id cua sinh vien
        // lay id cua sinh vien nhw the nao ?
        // ten tham so se la "id"
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id la :" + id);
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
        String uri = request.getRequestURI();
        if (uri.contains("/sinh-vien/them")) {
            them(request, response);
        } else if (uri.contains("/sinh-vien/cap-nhat")) {
            capNhat(request, response);
        }
    }

    private void capNhat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        Float diem = Float.parseFloat(request.getParameter("diem"));
        Boolean gt = Boolean.parseBoolean(request.getParameter("gioiTinh"));
        // tao ra sinh vien
        SinhVien sinhVien = new SinhVien(id, ten, diem, gt);
        sinhVienService.updateSinhVien(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void them(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // lay thong tin tren form xuong
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        Float diem = Float.parseFloat(request.getParameter("diem"));
        Boolean gt = Boolean.parseBoolean(request.getParameter("gioiTinh"));
        // tao ra sinh vien
        SinhVien sinhVien = new SinhVien(id, ten, diem, gt);
        sinhVienService.addSinhVien(sinhVien);
        // sau khi xoa xong => quay lai trang hien thi
        // sendRedirect mo ra duong dan servlet co san
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}