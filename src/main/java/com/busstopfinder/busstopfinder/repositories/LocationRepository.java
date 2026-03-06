package com.busstopfinder.busstopfinder.repositories;

import com.busstopfinder.busstopfinder.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    boolean existsByStreetAndSector(String street, String sector);

}
