package com.example.backendspring.model;

import javax.persistence.*;

@Entity
public class SanBong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenSan;
    private String diaChi;
    @ManyToOne
    private KhachHang khachHang;
    @ManyToOne
    private ThongTinSan thongTinSan;
    @Column(columnDefinition = "boolean default true")
    private boolean flagDelete;

    public SanBong() {
    }

    public SanBong(int id, String tenSan, KhachHang khachHang, ThongTinSan thongTinSan, boolean flagDelete) {
        this.id = id;
        this.tenSan = tenSan;
        this.khachHang = khachHang;
        this.thongTinSan = thongTinSan;
        this.flagDelete = flagDelete;
    }

    public SanBong(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSan() {
        return tenSan;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public ThongTinSan getThongTinSan() {
        return thongTinSan;
    }

    public void setThongTinSan(ThongTinSan thongTinSan) {
        this.thongTinSan = thongTinSan;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
