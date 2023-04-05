package com.example.shoeshopbackend.dto.oder;

public interface HistoryDto {

    String getNameProduct();

    double getPriceProduct();

    int getQuantity();

    Long getAccountId();

    int getTotalPrice();

    String getDatePayment();
}
