package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoe.shop.entity.oderProduct.Oder;
import shoe.shop.entity.product.Product;
import shoe.shop.repository.IOderRepository;
import shoe.shop.service.IOderService;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository iOderRepository;

    @Override
    public Oder findByProduct(Product product) {
        return iOderRepository.findByProduct(product);
    }

    @Override
    public void save(Oder oder) {
        iOderRepository.save(oder);
    }
}
