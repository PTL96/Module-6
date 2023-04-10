package com.example.shoeshopbackend.controller;

import com.example.shoeshopbackend.dto.oder.HistoryDto;
import com.example.shoeshopbackend.dto.oder.OderDto;
import com.example.shoeshopbackend.dto.oder.OderView;
import com.example.shoeshopbackend.dto.oder.TotalPrice;
import com.example.shoeshopbackend.dto.product.HotProductDto;
import com.example.shoeshopbackend.entity.Product;
import com.example.shoeshopbackend.entity.account.Account;
import com.example.shoeshopbackend.entity.Oder;
import com.example.shoeshopbackend.service.IAccountService;
import com.example.shoeshopbackend.service.IProductService;
import com.example.shoeshopbackend.service.impl.OderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("oder")
@CrossOrigin("*")
public class OderController {
    @Autowired
    private OderService oderService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IAccountService iAccountService;

    @PostMapping("addToCart")
    public ResponseEntity<OderDto> addToCart(@RequestBody OderDto oderDto) {
        Long productId = oderDto.getProduct_id();
        Long accountId = oderDto.getAccount_id();
        Oder check = oderService.finByAccountIdProductId(accountId, productId);
        Product product = iProductService.findByIdProduct(oderDto.getProduct_id());
        if (check != null) {
            if (product.getQuantity() < oderDto.getQuantity() + check.getQuantity()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            check.setQuantity(check.getQuantity() + oderDto.getQuantity());
            oderService.save(check);
        } else {
            if (product.getQuantity() < oderDto.getQuantity() || oderDto.getQuantity()<=0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Oder oder = new Oder();
            oderDto.setQuantity(oderDto.getQuantity());
            BeanUtils.copyProperties(oderDto, oder);
            oder.setAccount(iAccountService.findById(oderDto.getAccount_id()));
            oder.setProduct(iProductService.findByIdProduct(oderDto.getProduct_id()));
            oder.setSizes(oderDto.getSizes());
            oder.setPriceProduct(oderDto.getPriceProduct());
            oder.setNameProduct(oderDto.getProductName());
            oder.setAvatarProduct(oderDto.getAvatar());

            oderService.save(oder);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<OderView>> getAll(@RequestParam Long idAccount) {
        List<OderView> oderViewList = oderService.getAllOderView(idAccount);
        return new ResponseEntity<>(oderViewList, HttpStatus.OK);
    }

    @GetMapping("update")
    public ResponseEntity<Oder> update(@RequestParam("id") Long id, @RequestParam("quantity") int quantity) {
        Oder oder = oderService.findById(id);
        if (oder == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        oderService.updateOder(id, quantity);
        return new ResponseEntity<>(oder, HttpStatus.OK);
    }

    @DeleteMapping("delete{id}")
    public ResponseEntity<Oder> delete(@PathVariable("id") Long id) {
        Oder oder = oderService.findById(id);
        if (oder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        oderService.deleteOder(id);
        return new ResponseEntity<>(oder, HttpStatus.OK);
    }

    @GetMapping("/total")
    public ResponseEntity<TotalPrice> getTotal(@RequestParam Long idAccount) {
        TotalPrice totalPrice = oderService.getAllTotal(idAccount);
        if (totalPrice == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }


    @PutMapping("/payment")
    public ResponseEntity<String> updatePaymentStatus(@RequestBody Account account) {
        List<Oder> orders = oderService.findByAccountId(account.getAccountId());
        if (!orders.isEmpty()) {
            for (Oder order : orders) {
                Product product = iProductService.findByIdProduct(order.getProduct().getProductId());
                product.setQuantity(product.getQuantity() - order.getQuantity());
                iProductService.save(product);
                order.setPayment(true);
                order.setDatePayment(String.valueOf(LocalDateTime.now()));
                oderService.savePayment(order);
            }
            return ResponseEntity.ok("Thanh toán thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("history")
    public ResponseEntity<List<HistoryDto>> getallHistory(@RequestParam Long idAccount) {
        List<HistoryDto> historyDtoList = oderService.getallHistory(idAccount);
        if (historyDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyDtoList, HttpStatus.OK);
    }

    @GetMapping("/hot")
    public ResponseEntity<List<HotProductDto>> getAll() {
        List<HotProductDto> hotProductDtoList = oderService.getAllHot();
        return new ResponseEntity<>(hotProductDtoList, HttpStatus.OK);
    }

}