package com.example.shoeshopbackend.dto.product;


import com.example.shoeshopbackend.entity.account.Account;
import com.example.shoeshopbackend.entity.Product;

public interface ProductView {
    Long getProductId();
    String getProductName();
    String getCategoryName();
    String getDescription();
    Double getPrice();
    String getAvatar();
    Double getQuantity();
    Account getAccount();
    Product getProduct();

}
