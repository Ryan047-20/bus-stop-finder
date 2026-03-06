package com.busstopfinder.busstopfinder.repositories;

import com.busstopfinder.busstopfinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByEmail(String email);

    List<User> findByProvince_Code(String code);

    List<User> findByProvince_Name(String name);

}
