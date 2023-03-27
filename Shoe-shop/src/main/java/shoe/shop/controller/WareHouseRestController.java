package shoe.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shoe.shop.entity.product.WareHouse;
import shoe.shop.service.impl.WareHouseService;

import java.util.List;

@Controller
@RequestMapping("warehouse")
@CrossOrigin("*")
public class WareHouseRestController {
    @Autowired
    WareHouseService wareHouseService;

    @GetMapping("")
    public ResponseEntity<List<WareHouse>> getAll() {
        List<WareHouse> wareHouseList = wareHouseService.getAllWareHouse();
        if (wareHouseList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wareHouseList, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<WareHouse> save(@RequestBody WareHouse wareHouse) {
        wareHouseService.saveWareHouse(wareHouse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
