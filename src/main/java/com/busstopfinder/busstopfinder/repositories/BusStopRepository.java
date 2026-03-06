package com.busstopfinder.busstopfinder.repositories;

import com.busstopfinder.busstopfinder.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;

@Repository
public interface BusStopRepository extends JpaRepository<BusStop, Long> {
    boolean existsByName(String name);

}
