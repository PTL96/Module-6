package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shoe.shop.entity.oderProduct.DetailPayment;

public interface IPaymentDetailController extends JpaRepository<DetailPayment, Integer> {
}
