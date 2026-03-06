package com.busstopfinder.busstopfinder.Controllers;

import com.busstopfinder.busstopfinder.model.Province;
import com.busstopfinder.busstopfinder.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveProvince(@RequestBody Province province) {
        try {
            Province saved = provinceService.saveProvince(province);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllProvinces() {
        List<Province> provinces = provinceService.getAllProvinces();
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProvinceById(@PathVariable Long id) {
        try {
            Province province = provinceService.getProvinceById(id);
            return new ResponseEntity<>(province, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
