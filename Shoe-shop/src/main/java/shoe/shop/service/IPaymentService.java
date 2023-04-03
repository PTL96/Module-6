package shoe.shop.service;

import shoe.shop.entity.oderProduct.Payment;

public interface IPaymentService {
    void save(Payment payment);

    Payment findByOrderIdAccountId(Long oderId, Long accountId);
}
