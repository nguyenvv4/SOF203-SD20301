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
}
