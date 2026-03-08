package com.busstopfinder.busstopfinder.Service;

import com.busstopfinder.busstopfinder.model.Province;
import com.busstopfinder.busstopfinder.model.User;
import com.busstopfinder.busstopfinder.repositories.UserRepository;
import com.busstopfinder.busstopfinder.repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User with this email already exists!");
        }
        // Load the full province object first
           Province province = provinceRepository.findById(user.getProvince().getId())
            .orElseThrow(() -> new RuntimeException("Province not found!"));
            user.setProvince(province);

           return userRepository.save(user);
    }

    public List<User> getUsersByProvinceCode(String code) {
        return userRepository.findByProvince_Code(code);
    }

    public List<User> getUsersByProvinceName(String name) {
        return userRepository.findByProvince_Name(name);
    }
}
