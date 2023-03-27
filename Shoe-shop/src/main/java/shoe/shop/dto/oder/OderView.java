package shoe.shop.dto.oder;

public interface OderView {
    int getSize();

    Long getOderId();
Long getProductId();
    String getNameProduct();

    double getPriceProduct();

    String getAvatarProduct();

    int getQuantity();

    Long getAccountId();

    double getTotalPrice();

    double getTotal();
    double getSizes();
}
