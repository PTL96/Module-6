package shoe.shop.entity.oderProduct;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoe.shop.entity.account.Account;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oderId;
    private boolean flagDelete;
    private String oderDate;
    @ManyToOne
    private Account accounts;
    @OneToMany(mappedBy = "oder")
    @JsonBackReference
    Set<Payment> paymentSet;

}
