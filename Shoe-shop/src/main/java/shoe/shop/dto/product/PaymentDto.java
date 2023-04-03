package shoe.shop.dto.product;

import shoe.shop.entity.account.Account;
import shoe.shop.entity.oderProduct.Oder;


public class PaymentDto {
    private Long paymentId;
    private String paymentMethod;
    private String datePayment;
    private boolean paymentStatus;
    private Account account;
    private Oder oder;

    public PaymentDto() {
    }

    public PaymentDto(Long paymentId, String paymentMethod, String datePayment, boolean paymentStatus, Account account, Oder oder) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.datePayment = datePayment;
        this.paymentStatus = paymentStatus;
        this.account = account;
        this.oder = oder;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Oder getOder() {
        return oder;
    }

    public void setOder(Oder oder) {
        this.oder = oder;
    }
}
