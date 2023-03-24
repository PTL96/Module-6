package shoe.shop.dto.product;

import shoe.shop.entity.account.Account;
import shoe.shop.entity.product.Product;

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
    float getTotalPrice();

}
