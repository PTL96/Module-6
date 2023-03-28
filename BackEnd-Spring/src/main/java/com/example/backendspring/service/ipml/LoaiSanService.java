package com.example.backendspring.service.ipml;

import com.example.backendspring.model.LoaiSan;
import com.example.backendspring.repository.ILoaiSanRepository;
import com.example.backendspring.service.ILoaiSanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSanService implements ILoaiSanService {
    @Autowired
    private ILoaiSanRepository iLoaiSanRepository;

    @Override
    public List<LoaiSan> getAllLoaiSan() {
        return iLoaiSanRepository.getAllLoaiSan();
    }
}
