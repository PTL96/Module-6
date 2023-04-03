package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoe.shop.entity.oderProduct.Payment;
import shoe.shop.repository.IPaymentRepository;
import shoe.shop.service.IPaymentService;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    IPaymentRepository iPaymentRepository;

    @Override
    public void save(Payment payment) {
        iPaymentRepository.save(payment);
    }

    @Override
    public Payment findByOrderIdAccountId(Long oderId, Long accountId) {
        return iPaymentRepository.findByAccount_AccountIdAndOder_OderId(oderId, accountId);
    }
}
