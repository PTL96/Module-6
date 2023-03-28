package shoe.shop.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shoe.shop.dto.oder.OderDto;
import shoe.shop.dto.oder.OderView;
import shoe.shop.dto.oder.TotalPrice;
import shoe.shop.entity.oderProduct.Oder;
import shoe.shop.service.IAccountService;
import shoe.shop.service.IProductService;
import shoe.shop.service.impl.OderService;


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
        if (check != null){
            check.setQuantity(check.getQuantity()+oderDto.getQuantity());
            oderService.save(check);
        }else {
            Oder oder = new Oder();
            BeanUtils.copyProperties(oderDto, oder);
            oderDto.setQuantity(oderDto.getQuantity());
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
        if (oderViewList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(oderViewList, HttpStatus.OK);
    }


    @DeleteMapping("delete{id}")
    public ResponseEntity<Oder> delete(@PathVariable("id") Long id) {
        Oder oder = oderService.findById(id);
        if (oder == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
}