package com.example.sd20301.luyentap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {

    private Integer id;

    private String hoTen;

    private String diaChi;

    private String gioiTinh;

    private Boolean trangThai;

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }

    public SinhVien(String hoTen, String diaChi, String gioiTinh, Boolean trangThai) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
    }
}
