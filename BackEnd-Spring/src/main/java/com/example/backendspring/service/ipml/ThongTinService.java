package com.example.backendspring.service.ipml;

import com.example.backendspring.model.ThongTinSan;
import com.example.backendspring.repository.IThongTinRepository;
import com.example.backendspring.service.IThongTinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongTinService implements IThongTinService {
    @Autowired
    private IThongTinRepository iThongTinRepository;

    @Override
    public List<ThongTinSan> getAllThongTinSan() {
        return iThongTinRepository.getAllThongTin();
    }
}
