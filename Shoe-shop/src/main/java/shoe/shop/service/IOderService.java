package shoe.shop.service;

import shoe.shop.dto.oder.OderView;
import shoe.shop.dto.oder.TotalPrice;
import shoe.shop.entity.account.Account;
import shoe.shop.entity.oderProduct.Oder;



import java.util.List;

public interface IOderService {

    void save(Oder oder);


    List<OderView> getAllOderView(Long idAccount);

    TotalPrice getAllTotal(Long idAccount);

    Oder findById(Long id);

    void deleteOder(Long id);

    Oder finByAccountIdProductId(Long accountId, Long productId);

    void updateOder(Long id, int quantity);


    List<Oder> findByAccountId(Long accountId);
}
