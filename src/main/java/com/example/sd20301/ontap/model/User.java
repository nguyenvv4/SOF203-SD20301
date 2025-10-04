package com.example.sd20301.ontap.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String ten;

    private String email;

    private String tuoi;

    private Boolean gioiTinh;

}
