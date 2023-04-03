package shoe.shop.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shoe.shop.dto.product.PaymentDto;
import shoe.shop.entity.account.Account;
import shoe.shop.entity.oderProduct.Oder;
import shoe.shop.entity.oderProduct.Payment;
import shoe.shop.service.IAccountService;
import shoe.shop.service.IOderService;
import shoe.shop.service.IPaymentService;

import java.time.LocalDate;

@Controller
@RequestMapping("payment")
@CrossOrigin("*")
public class PaymentRestController {
    @Autowired
    private IPaymentService iPaymentService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IOderService iOderService;

    @PutMapping("update-account/{id}")

    public ResponseEntity<Account> update(@RequestParam("id") Long id, @RequestBody Account account) {
        Account account1 = iAccountService.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        account.setAccountId(account1.getAccountId());
        iAccountService.save(account);
        return new ResponseEntity<>(iAccountService.findById(id), HttpStatus.OK);
    }

    @PostMapping("payment-oder")
    public ResponseEntity<PaymentDto> create(@RequestBody PaymentDto paymentDto) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDto, payment);
        payment.setOder(iOderService.findById(paymentDto.getOder().getOderId()));
        payment.setAccount(iAccountService.findById(paymentDto.getAccount().getAccountId()));
        payment.setDatePayment(String.valueOf(LocalDate.now()));
        iPaymentService.save(payment);
        Oder oder = new Oder();
        oder.setPayment(true);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
