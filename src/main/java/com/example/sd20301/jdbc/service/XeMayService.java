package com.example.sd20301.jdbc.service;

import com.example.sd20301.jdbc.model.XeMay;
import com.example.sd20301.jdbc.repository.XeMayRepository;

import java.util.ArrayList;

public class XeMayService {

    XeMayRepository xeMayRepository = new XeMayRepository();

    public ArrayList<XeMay> getList() {
        return xeMayRepository.getList();
    }
}
