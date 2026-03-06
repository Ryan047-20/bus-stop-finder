package com.busstopfinder.busstopfinder.Service;

import com.busstopfinder.busstopfinder.model.Province;
import com.busstopfinder.busstopfinder.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;
    public Province saveProvince(Province province) {
        if (provinceRepository.existsByCode(province.getCode())) {
            throw new RuntimeException("Province with this code already exists!");
        }
        return provinceRepository.save(province);
    }

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public Province getProvinceById(Long id) {
        return provinceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Province not found!"));
    }
}




