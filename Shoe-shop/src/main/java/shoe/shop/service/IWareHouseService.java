package shoe.shop.service;

import shoe.shop.entity.product.WareHouse;

import java.util.List;

public interface IWareHouseService {
    List<WareHouse> getAllWareHouse();

    void saveWareHouse(WareHouse wareHouse);
}
