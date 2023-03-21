package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoe.shop.entity.product.Size;
import shoe.shop.repository.ISizeRepository;
import shoe.shop.service.ISizeService;

import java.util.List;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private ISizeRepository iSizeRepository;

    @Override
    public List<Size> getAllSize() {
        return iSizeRepository.findAll();
    }
}
