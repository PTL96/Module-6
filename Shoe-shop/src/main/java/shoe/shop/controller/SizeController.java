package shoe.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shoe.shop.entity.product.Size;
import shoe.shop.service.impl.SizeService;

import java.util.List;

@Controller
@RequestMapping("size")
@CrossOrigin("*")
public class SizeController {
    @Autowired
    private SizeService sizeService;

    @GetMapping("")
    public ResponseEntity<List<Size>> getAll() {
        List<Size> sizeList = sizeService.getAllSize();
        if (sizeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }
}
