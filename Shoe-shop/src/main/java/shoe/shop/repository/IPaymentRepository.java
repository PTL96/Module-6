package shoe.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shoe.shop.entity.oderProduct.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByAccount_AccountIdAndOder_OderId(Long accountId, Long oderId);
}
