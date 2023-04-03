package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoe.shop.dto.oder.OderView;
import shoe.shop.dto.oder.TotalPrice;
import shoe.shop.entity.account.Account;
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


    @Override
    public List<OderView> getAllOderView(Long idAccount) {
        return iOderRepository.getAllOder(idAccount);
    }

    @Override
    public TotalPrice getAllTotal(Long idAccount) {
        return iOderRepository.totalPrice(idAccount);
    }

    @Override
    public Oder findById(Long id) {
        return iOderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOder(Long id) {
        iOderRepository.deleteById(id);
    }

    @Override
    public Oder finByAccountIdProductId(Long accountId, Long productId) {
        return iOderRepository.findAllByAccount_AccountIdAndProduct_ProductId(accountId, productId);
    }

    @Override
    public void updateOder(Long id, int quantity) {
        iOderRepository.updateOder(id, quantity);
    }

    @Override
    public List<Oder> findByAccountId(Long accountId) {
        return iOderRepository.findByAccount_AccountId(accountId);
    }


}





