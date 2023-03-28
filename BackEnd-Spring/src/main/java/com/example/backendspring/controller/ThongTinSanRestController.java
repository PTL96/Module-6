package com.example.backendspring.controller;

import com.example.backendspring.model.SanBong;
import com.example.backendspring.model.ThongTinSan;
import com.example.backendspring.service.ipml.ThongTinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thongtinsan")
@CrossOrigin("*")
public class ThongTinSanRestController {
    @Autowired
    private ThongTinService thongTinService;

    @GetMapping("")
    public ResponseEntity<List<ThongTinSan>> getAll() {
        List<ThongTinSan> thongTinSanList = thongTinService.getAllThongTinSan();
        if (thongTinSanList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(thongTinSanList, HttpStatus.OK);
    }
}
