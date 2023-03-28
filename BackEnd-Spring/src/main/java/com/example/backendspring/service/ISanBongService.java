package com.example.backendspring.service;

import com.example.backendspring.model.SanBong;


import java.util.List;

public interface ISanBongService {
    List<SanBong> getAllSanBong();
   
    SanBong findById(int id);

    void deleteSanBong(int id);

    void save(SanBong sanBong);


}
