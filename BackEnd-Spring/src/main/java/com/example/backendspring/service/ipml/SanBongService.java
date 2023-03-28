package com.example.backendspring.service.ipml;

import com.example.backendspring.model.SanBong;
import com.example.backendspring.repository.ISanBongRepository;
import com.example.backendspring.service.ISanBongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanBongService implements ISanBongService {
    @Autowired
    private ISanBongRepository iSanBongRepository;

    @Override
    public List<SanBong> getAllSanBong() {
        return iSanBongRepository.getAllSanBong();
    }


    @Override
    public SanBong findById(int id) {
        return iSanBongRepository.findById(id).get();
    }


    @Override
    public void deleteSanBong(int id) {
        iSanBongRepository.deleteById(id);
    }

    @Override
    public void save(SanBong sanBong) {
        iSanBongRepository.save(sanBong);
    }

}
