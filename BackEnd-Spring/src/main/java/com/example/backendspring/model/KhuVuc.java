package com.example.backendspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class KhuVuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenKhuVuc;
    @JsonBackReference
    @OneToMany(mappedBy = "khuVuc")
    Set<ThongTinSan> thongTinSans;

    public KhuVuc() {
    }

    public KhuVuc(int id, String tenKhuVuc, Set<ThongTinSan> thongTinSans) {
        this.id = id;
        this.tenKhuVuc = tenKhuVuc;
        this.thongTinSans = thongTinSans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }

    public Set<ThongTinSan> getThongTinSans() {
        return thongTinSans;
    }

    public void setThongTinSans(Set<ThongTinSan> thongTinSans) {
        this.thongTinSans = thongTinSans;
    }
}
