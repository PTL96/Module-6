package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoe.shop.entity.product.WareHouse;
import shoe.shop.repository.IWareHouseRepository;
import shoe.shop.service.IWareHouseService;

import java.util.List;

@Service
public class WareHouseService implements IWareHouseService {
    @Autowired
    IWareHouseRepository iWareHouseRepository;

    @Override
    public List<WareHouse> getAllWareHouse() {
        return iWareHouseRepository.findAll();
    }

    @Override
    public void saveWareHouse(WareHouse wareHouse) {
        iWareHouseRepository.save(wareHouse);
    }
}
