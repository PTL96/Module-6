package shoe.shop.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shoe.shop.dto.oder.OderDto;
import shoe.shop.dto.oder.OderView;
import shoe.shop.entity.oderProduct.Oder;
import shoe.shop.service.IAccountService;
import shoe.shop.service.impl.OderService;
import shoe.shop.service.impl.ProductService;


import java.util.List;


@Controller
@RequestMapping("oder")
@CrossOrigin("*")
public class OderController {
    @Autowired
    private OderService oderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private IAccountService iAccountService;

    @PostMapping("addToCart")
    public ResponseEntity<OderDto> addToCart(@RequestBody OderDto oderDto) {
        Oder oder = new Oder();
        BeanUtils.copyProperties(oderDto, oder);
        oderDto.setQuantity(oderDto.getQuantity());
        oder.setAccount(iAccountService.findById(oderDto.getAccount_id()));
        oder.setProduct(productService.findByIdProduct(oderDto.getProduct_id()));
        oder.setSizes(oderDto.getSizes());
        oder.setPriceProduct(oderDto.getPriceProduct());
        oder.setNameProduct(oderDto.getProductName());
        oder.setAvatarProduct(oderDto.getAvatar());
        oderService.save(oder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


//    @GetMapping("")
//    public ResponseEntity<List<OderView>> getAll() {
//        List<OderView> oderViewList = oderService.getAllOderView();
//        if (oderViewList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(oderViewList, HttpStatus.OK);
//    }

}