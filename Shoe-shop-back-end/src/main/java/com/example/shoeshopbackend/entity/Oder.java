package com.example.shoeshopbackend.entity;



import com.example.shoeshopbackend.entity.account.Account;

import javax.persistence.*;

@Entity

public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oderId;
    private String nameProduct;
    private double priceProduct;
    private String avatarProduct;
    private int quantity;
    private int sizes;
    private int totalPrice;
    private int total;
    private boolean payment;
    private boolean flag_delete;
    private String datePayment;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Oder() {
    }

    public Oder(Long oderId, String nameProduct, double priceProduct, String avatarProduct, int quantity, int sizes, int totalPrice, Account account, Product product) {
        this.oderId = oderId;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.avatarProduct = avatarProduct;
        this.quantity = quantity;
        this.sizes = sizes;
        this.totalPrice = totalPrice;
        this.account = account;
        this.product = product;
    }

    public Oder(String datePayment) {
        this.datePayment = datePayment;
    }

    public Oder(boolean flag_delete) {
        this.flag_delete = flag_delete;
    }

    public Long getOderId() {
        return oderId;
    }

    public void setOderId(Long oderId) {
        this.oderId = oderId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getAvatarProduct() {
        return avatarProduct;
    }

    public void setAvatarProduct(String avatarProduct) {
        this.avatarProduct = avatarProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSizes() {
        return sizes;
    }

    public void setSizes(int sizes) {
        this.sizes = sizes;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public boolean isFlag_delete() {
        return flag_delete;
    }

    public void setFlag_delete(boolean flag_delete) {
        this.flag_delete = flag_delete;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }
}
