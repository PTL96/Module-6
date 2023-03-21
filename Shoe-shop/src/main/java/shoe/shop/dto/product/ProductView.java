package shoe.shop.dto.product;

public interface ProductView {
    Long getProductId();
    String getProductName();
    String getCategoryName();
    String getDescription();
    Double getPrice();
    String getAvatar();
    public int getQuantity();
    boolean isFlagDelete();

    }
