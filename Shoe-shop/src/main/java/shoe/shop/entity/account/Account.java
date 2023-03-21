package shoe.shop.entity.account;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoe.shop.entity.oderProduct.Oder;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(columnDefinition = "varchar(45)", unique = true)
    private String username;
    @JsonIgnore
    private String password;
    @Column(columnDefinition = "varchar(45)", unique = true)
    private String email;
    private String name;
    @Column(columnDefinition = "varchar(12)", unique = true)
    private String idCard;
    private String address;
    private String phoneNumber;
    private String dateOfBirth;
    private boolean flagDelete;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;
    @Lob
    private String avatar;
    @OneToMany(mappedBy = "accounts")
    @JsonBackReference
    Set<Oder> oderSet;


}
