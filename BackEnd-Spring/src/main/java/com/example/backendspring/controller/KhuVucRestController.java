package com.example.backendspring.controller;

import com.example.backendspring.model.KhachHang;
import com.example.backendspring.model.KhuVuc;
import com.example.backendspring.service.ipml.KhuVucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/khuvuc")
@CrossOrigin("*")
public class KhuVucRestController {
    @Autowired
    private KhuVucService khuVucService;

    @GetMapping("")
    public ResponseEntity<List<KhuVuc>> getAll() {
        List<KhuVuc> khuVucList = khuVucService.getAllKhuVuc();
        if (khuVucList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(khuVucList, HttpStatus.OK);
    }
}
