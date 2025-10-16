package com.example.sd20301.luyentap.service;

import com.example.sd20301.luyentap.model.SinhVien;
import com.example.sd20301.luyentap.repository.SinhVienRepo;

import java.util.List;

public class SinhVienService {

    SinhVienRepo sinhVienRepo = new SinhVienRepo();

    public List<SinhVien> getSinhVien() {
        return sinhVienRepo.getList();
    }
    public SinhVien insertSinhVien(SinhVien sinhVien) {
        sinhVienRepo.insert(sinhVien);
        return sinhVien;
    }
    public void deleteSinhVien(int id) {
        sinhVienRepo.delete(id);
    }
}
