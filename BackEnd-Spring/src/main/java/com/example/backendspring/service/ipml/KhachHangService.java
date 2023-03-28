package com.example.backendspring.service.ipml;

import com.example.backendspring.model.KhachHang;
import com.example.backendspring.repository.IKhachHangRepository;
import com.example.backendspring.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService {
    @Autowired
    private IKhachHangRepository iKhachHangRepository;

    @Override
    public List<KhachHang> getAllKhachHang() {
        return iKhachHangRepository.getAllKhachHang();
    }
}
