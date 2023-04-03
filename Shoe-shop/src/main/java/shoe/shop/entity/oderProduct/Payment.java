package shoe.shop.entity.oderProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoe.shop.entity.account.Account;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private String paymentMethod;
    private String datePayment;
    private boolean paymentStatus;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Oder oder;

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
