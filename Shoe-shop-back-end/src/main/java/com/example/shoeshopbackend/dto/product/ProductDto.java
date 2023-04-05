package com.example.shoeshopbackend.dto.product;


import com.example.shoeshopbackend.entity.account.Account;
import com.example.shoeshopbackend.entity.Category;

public class ProductDto {
    private Long productId;
//    @NotBlank(message = "Bạn chưa nhập tên sản phẩm")
//    @Min(value = 3, message = "Tối thiểu 3 ký tự")
//    @Max(value = 100, message = "Tối đa 100 ký tự")
    private String productName;
//    @NotBlank(message = "Bạn chưa nhập mô tả sản phẩm")
//    @Min(value = 5, message = "Tối thiểu 5 ký tự")
//    @Max(value = 1000, message = "Tối đa 1000 ký tự")
    private String description;
//    @NotNull(message = "Bạn chưa nhập giá sản phẩm")
//    @DecimalMin(value = "0", message = "Giá tiền không được nhỏ hơn 0")
//    @DecimalMax(value = "100000000", message = "Giá tối đa của sản phẩm là 100 triệu")
    private Double price;
//    @NotBlank(message = "Bạn chưa chọn ảnh của sản phẩm")
//    @Size(max = 500)
    private int quantity;
    private String avatar;
    private boolean flagDelete;
    private Category category;
    private Account account;


    public ProductDto() {
    }

    public ProductDto(int quantity) {
        this.quantity = quantity;
    }

    public ProductDto(Long productId, String productName, String description, Double price, String avatar, boolean flagDelete, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.avatar = avatar;
        this.flagDelete = flagDelete;
        this.category = category;
    }

    public ProductDto(Account account) {
        this.account = account;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
