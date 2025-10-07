package com.example.sd20301.jdbc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XeMay {

    private String soKhung;

    private String soMay;

    private Integer phanKhoi;

    private Float khoiLuong;

    private Boolean trangThai;


    @Override
    public String toString() {
        return "XeMay{" +
                "soKhung='" + soKhung + '\'' +
                ", soMay='" + soMay + '\'' +
                ", phanKhoi=" + phanKhoi +
                ", khoiLuong=" + khoiLuong +
                ", trangThai=" + trangThai +
                '}';
    }
}
