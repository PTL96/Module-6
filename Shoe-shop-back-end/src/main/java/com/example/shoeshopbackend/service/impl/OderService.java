package com.example.shoeshopbackend.service.impl;

import com.example.shoeshopbackend.dto.oder.HistoryDto;
import com.example.shoeshopbackend.dto.oder.OderView;
import com.example.shoeshopbackend.dto.oder.TotalPrice;
import com.example.shoeshopbackend.dto.product.HotProductDto;
import com.example.shoeshopbackend.entity.Oder;
import com.example.shoeshopbackend.entity.Product;
import com.example.shoeshopbackend.repository.IOderRepository;
import com.example.shoeshopbackend.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository iOderRepository;


    @Override
    public void save(Oder oder) {
        oder.setFlag_delete(false);
        oder.setPayment(false);
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

    @Override
    public void savePayment(Oder order) {
        iOderRepository.save(order);
    }

    @Override
    public List<HistoryDto> getallHistory(Long idAccount) {
        return iOderRepository.getHistory(idAccount);
    }

    @Override
    public List<HotProductDto> getAllHot() {
        return iOderRepository.hotProduct();
    }


}





