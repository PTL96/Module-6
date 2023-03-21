package shoe.shop.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.nashorn.internal.ir.annotations.Ignore;
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
    @Column(columnDefinition = "longtext")
    private String description;
    private Double price;
    @Column(columnDefinition = "longtext")
    private String avatar;
    private int quantity;
    private boolean flagDelete;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    private Size size;



}
