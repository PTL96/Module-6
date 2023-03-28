package com.example.backendspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenKhach;
    private String soDienThoai;
    private int gioiTinh;
    @JsonBackReference
    @OneToMany(mappedBy = "khachHang")
    private Set<SanBong> sanBongs;

    public KhachHang() {
    }

    public KhachHang(int id, String tenKhach, String soDienThoai, int gioiTinh, Set<SanBong> sanBongs) {
        this.id = id;
        this.tenKhach = tenKhach;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.sanBongs = sanBongs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Set<SanBong> getSanBongs() {
        return sanBongs;
    }

    public void setSanBongs(Set<SanBong> sanBongs) {
        this.sanBongs = sanBongs;
    }
}
