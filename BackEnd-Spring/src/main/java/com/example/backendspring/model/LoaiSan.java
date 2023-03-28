package com.example.backendspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LoaiSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenLoai;
    @JsonBackReference
    @OneToMany(mappedBy = "loaiSans")
    Set<ThongTinSan> thongTinSans;

    public LoaiSan() {
    }

    public LoaiSan(int id, String tenLoai, Set<ThongTinSan> thongTinSans) {
        this.id = id;
        this.tenLoai = tenLoai;
        this.thongTinSans = thongTinSans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Set<ThongTinSan> getThongTinSans() {
        return thongTinSans;
    }

    public void setThongTinSans(Set<ThongTinSan> thongTinSans) {
        this.thongTinSans = thongTinSans;
    }
}
