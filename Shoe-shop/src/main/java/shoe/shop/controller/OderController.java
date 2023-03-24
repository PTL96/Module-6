package shoe.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;

import shoe.shop.entity.oderProduct.Oder;
import shoe.shop.entity.product.Product;
import shoe.shop.service.impl.OderService;
import shoe.shop.service.impl.ProductService;


@Controller
@RequestMapping("oder")
@CrossOrigin("*")
public class OderController {
    @Autowired
    private OderService oderService;
    @Autowired
    private ProductService productService;


    @PostMapping("addToCart")
    public ResponseEntity<Oder> addToCart(@RequestBody  Product product) {
        Oder oder = oderService.findByProduct(product);
        if(oder !=null){
            oder.setQuantity(oder.getQuantity()+1);
        }else {
            oder = new Oder();
            oder.setProduct(product);
            oder.setQuantity(1);
            oder.setNameProduct(product.getProductName());
            oder.setAvatarProduct(product.getAvatar());
            oder.setPriceProduct(product.getPrice());
            oder.getSize();
        }
        oderService.save(oder);
        return ResponseEntity.ok(oder);
}
}