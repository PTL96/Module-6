package shoe.shop.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String description;
    private Double price;
    @Column(columnDefinition = "longtext")
    private String avatar;
    private boolean flagDelete;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    Set<WareHouse> wareHouseSet;
    @OneToMany(mappedBy = "products")
    @JsonBackReference
    Set<SizeProduct> sizeProductSet;
}
