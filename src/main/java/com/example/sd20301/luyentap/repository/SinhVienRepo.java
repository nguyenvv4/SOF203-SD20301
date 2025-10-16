package com.example.sd20301.luyentap.repository;

import com.example.sd20301.luyentap.model.SinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SinhVienRepo {

    public List<SinhVien> getList() {
        List<SinhVien> list = new ArrayList<>();
        try {
            String sql = "select * from sinh_vien";
            Connection conn = dbConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setId(rs.getInt("id"));
                sinhVien.setHoTen(rs.getString("ho_ten"));
                sinhVien.setGioiTinh(rs.getString("gioi_tinh"));
                sinhVien.setDiaChi(rs.getString("dia_chi"));
                sinhVien.setTrangThai(rs.getBoolean("trang_thai"));
                list.add(sinhVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void insert(SinhVien sinhVien) {
        String sql = "INSERT INTO sinh_vien (ho_ten, dia_chi, gioi_tinh, trang_thai)\n" +
                "VALUES(?,?,?,?)";
        Connection conn = dbConnect.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sinhVien.getHoTen());
            ps.setString(2, sinhVien.getDiaChi());
            ps.setString(3, sinhVien.getGioiTinh());
            ps.setBoolean(4, sinhVien.getTrangThai());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM sinh_vien WHERE id = ?";
        Connection conn = dbConnect.getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
