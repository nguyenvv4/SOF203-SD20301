package com.example.sd20301.jdbc.repository;

import com.example.sd20301.jdbc.model.XeMay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class XeMayRepository {

    public ArrayList<XeMay> getList() {
        // thuc thi truy van o day
        ArrayList<XeMay> list = new ArrayList<>();
        String sql = "select  * from xe_may";
        try {
            Connection conn = dbConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                XeMay xeMay = new XeMay();
                xeMay.setSoMay(rs.getString("so_may"));
                xeMay.setSoKhung(rs.getString("so_khung"));
                xeMay.setKhoiLuong(rs.getFloat("khoi_luong"));
                xeMay.setPhanKhoi(rs.getInt("phan_khoi"));
                xeMay.setTrangThai(rs.getBoolean("trang_thai"));
                list.add(xeMay);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public XeMay getXeMayBySoKhung(String soKhung) {
        String sql = "SELECT * FROM xe_may WHERE so_khung = ?";
        try {
            Connection conn = dbConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, soKhung);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new XeMay(
                    rs.getString("so_khung"),
                    rs.getString("so_may"),
                    rs.getInt("phan_khoi"),
                    rs.getFloat("khoi_luong"),
                    rs.getBoolean("trang_thai")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteXeMay(String soKhung) {
        String sql = "DELETE FROM xe_may WHERE so_khung = ?";
        try {
            Connection conn = dbConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, soKhung);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateXeMay(XeMay xeMay) {
        String sql = "UPDATE xe_may SET so_may = ?, khoi_luong = ?, phan_khoi = ?, trang_thai = ? WHERE so_khung = ?";
        try {
            Connection conn = dbConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xeMay.getSoMay());
            ps.setFloat(2, xeMay.getKhoiLuong());
            ps.setInt(3, xeMay.getPhanKhoi());
            ps.setBoolean(4, xeMay.getTrangThai());
            ps.setString(5, xeMay.getSoKhung());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addXeMay(XeMay xeMay) {
        String sql = "INSERT INTO xe_may (so_khung, so_may, khoi_luong, phan_khoi, trang_thai) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = dbConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xeMay.getSoKhung());
            ps.setString(2, xeMay.getSoMay());
            ps.setFloat(3, xeMay.getKhoiLuong());
            ps.setInt(4, xeMay.getPhanKhoi());
            ps.setBoolean(5, xeMay.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
