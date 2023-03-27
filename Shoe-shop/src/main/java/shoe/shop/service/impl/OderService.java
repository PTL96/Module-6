package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoe.shop.dto.oder.OderView;
import shoe.shop.entity.oderProduct.Oder;
import shoe.shop.repository.IOderRepository;
import shoe.shop.repository.IProductRepository;
import shoe.shop.service.IOderService;


import java.util.List;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository iOderRepository;
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public void save(Oder oder) {
        iOderRepository.save(oder);
    }


//    @Override
//    public List<OderView> getAllOderView() {
//        return iOderRepository.getAllOder();
//    }


}
