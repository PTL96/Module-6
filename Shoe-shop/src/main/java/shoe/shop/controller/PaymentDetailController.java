package shoe.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import shoe.shop.service.IPaymentDetailService;

@Controller
@RequestMapping("payment-detail")
@CrossOrigin("*")
public class PaymentDetailController {
    @Autowired
    private IPaymentDetailService iPaymentDetailService;

}
