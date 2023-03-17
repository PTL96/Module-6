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
public class SizeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeProductId;
   @ManyToOne
    private Size size;
   @ManyToOne
    private Product products;
}
