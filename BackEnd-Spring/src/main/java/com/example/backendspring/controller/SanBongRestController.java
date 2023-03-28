package com.example.backendspring.controller;

import com.example.backendspring.model.SanBong;
import com.example.backendspring.service.ipml.SanBongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanbong")
@CrossOrigin("*")
public class SanBongRestController {
    @Autowired
    private SanBongService sanBongService;

    @GetMapping("")
    public ResponseEntity<List<SanBong>> getAll() {
        List<SanBong> sanBongList = sanBongService.getAllSanBong();
        if (sanBongList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sanBongList, HttpStatus.OK);
    }




    @PostMapping("/save")
    public ResponseEntity<SanBong> create(@RequestBody SanBong sanBong){
        sanBongService.save(sanBong);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("{id}")

    public ResponseEntity<SanBong> delete(@PathVariable("id") int id){
        SanBong sanBong = sanBongService.findById(id);
        if (sanBong==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sanBongService.deleteSanBong(id);
        return new ResponseEntity<>(sanBong, HttpStatus.OK);
    }
}
