package com.example.sd20301.jdbc.service;

import com.example.sd20301.jdbc.model.XeMay;
import com.example.sd20301.jdbc.repository.XeMayRepository;

import java.util.ArrayList;

public class XeMayService {

    XeMayRepository xeMayRepository = new XeMayRepository();

    public ArrayList<XeMay> getList() {
        return xeMayRepository.getList();
    }

    public XeMay getXeMayBySoKhung(String soKhung) {
        return xeMayRepository.getXeMayBySoKhung(soKhung);
    }

    public void themXeMay(XeMay xeMay) {
        xeMayRepository.addXeMay(xeMay);
    }

    public void updateXeMay(XeMay xeMay) {
        xeMayRepository.updateXeMay(xeMay);
    }

    public void deleteXeMay(String soKhung) {
        xeMayRepository.deleteXeMay(soKhung);
    }
}
