package shoe.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoe.shop.repository.IPaymentDetailRepository;

import shoe.shop.service.IPaymentDetailService;
@Service
public class PaymentDetailService implements IPaymentDetailService {
    @Autowired
    IPaymentDetailRepository iPaymentDetailRepository;

}
