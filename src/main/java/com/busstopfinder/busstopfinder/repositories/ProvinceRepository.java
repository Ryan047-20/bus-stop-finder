package com.busstopfinder.busstopfinder.repositories;

import com.busstopfinder.busstopfinder.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {

    boolean existsByCode(String code);

}
