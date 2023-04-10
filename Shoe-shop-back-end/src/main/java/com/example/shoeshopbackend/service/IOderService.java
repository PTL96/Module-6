package com.example.shoeshopbackend.service;


import com.example.shoeshopbackend.dto.oder.HistoryDto;
import com.example.shoeshopbackend.dto.oder.OderView;
import com.example.shoeshopbackend.dto.oder.TotalPrice;
import com.example.shoeshopbackend.dto.product.HotProductDto;
import com.example.shoeshopbackend.entity.Oder;

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

    void savePayment(Oder order);

   List<HistoryDto> getallHistory(Long idAccount);

    List<HotProductDto> getAllHot();
}
