package com.example.backendspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ThongTinSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String khungGio;
    private double giaThue;
    @ManyToOne
    private LoaiSan loaiSans;
    @ManyToOne
    private KhuVuc khuVuc;
    @JsonBackReference
    @OneToMany(mappedBy = "thongTinSan")
    Set<SanBong> sanBongs;

    public ThongTinSan() {
    }

    public ThongTinSan(int id, String khungGio, double giaThue, LoaiSan loaiSans, KhuVuc khuVuc, Set<SanBong> sanBongs) {
        this.id = id;
        this.khungGio = khungGio;
        this.giaThue = giaThue;
        this.loaiSans = loaiSans;
        this.khuVuc = khuVuc;
        this.sanBongs = sanBongs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKhungGio() {
        return khungGio;
    }

    public void setKhungGio(String khungGio) {
        this.khungGio = khungGio;
    }

    public double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    public LoaiSan getLoaiSans() {
        return loaiSans;
    }

    public void setLoaiSans(LoaiSan loaiSans) {
        this.loaiSans = loaiSans;
    }

    public KhuVuc getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(KhuVuc khuVuc) {
        this.khuVuc = khuVuc;
    }

    public Set<SanBong> getSanBongs() {
        return sanBongs;
    }

    public void setSanBongs(Set<SanBong> sanBongs) {
        this.sanBongs = sanBongs;
    }
}
