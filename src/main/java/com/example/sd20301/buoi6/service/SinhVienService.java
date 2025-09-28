package com.example.sd20301.buoi6.service;

import com.example.sd20301.buoi6.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    private List<SinhVien> danhSach = new ArrayList<>();

    public SinhVienService() {
        danhSach.add(new SinhVien(1, "Nguyen Van A", 5.6f, true));
        danhSach.add(new SinhVien(2, "Nguyen Van B", 6.6f, true));
        danhSach.add(new SinhVien(3, "Nguyen Thi A", 7.6f, false));
    }

    public List<SinhVien> getAll() {
        return danhSach;
    }

    public SinhVien getDetail(Integer id) {
        for(SinhVien sv: danhSach) {
            if(sv.getId() == id) {
                return sv;
            }
        }
        return null;
    }

    public void addSinhVien(SinhVien sinhVien) {
        danhSach.add(sinhVien);
    }

    public void updateSinhVien(SinhVien sinhVien) {
        int idCanSua = -1;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId() == sinhVien.getId()) {
                idCanSua = i;
            }
        }
        danhSach.set(idCanSua, sinhVien);
    }

    public void deleteSinhVien(Integer id) {
        // ham xoa sinh vien theo id
        danhSach.removeIf(sv -> sv.getId() == id);
    }
}
