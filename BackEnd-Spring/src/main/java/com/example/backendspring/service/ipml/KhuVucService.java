package com.example.backendspring.service.ipml;

import com.example.backendspring.model.KhuVuc;
import com.example.backendspring.repository.IKhuVucRepository;
import com.example.backendspring.service.IKhuVucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuVucService implements IKhuVucService {
    @Autowired
    private IKhuVucRepository iKhuVucRepository;

    @Override
    public List<KhuVuc> getAllKhuVuc() {
        return iKhuVucRepository.getAllKhuVuc();
    }
}
