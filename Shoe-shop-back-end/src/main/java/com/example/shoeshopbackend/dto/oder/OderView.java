package com.example.shoeshopbackend.dto.oder;

public interface OderView {
    Long getOderId();

    Long getProductId();

    String getNameProduct();

    double getPriceProduct();

    String getAvatarProduct();

    int getQuantity();

    Long getAccountId();

    double getTotalPrice();

}
