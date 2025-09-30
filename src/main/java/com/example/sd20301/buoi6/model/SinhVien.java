package com.example.sd20301.buoi6.model;

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
    private String ten;
    private Float diem;
    private Boolean gioiTinh;

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", diem=" + diem +
                ", gioiTinh=" + gioiTinh +
                '}';
    }
}
