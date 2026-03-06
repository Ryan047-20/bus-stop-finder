package com.busstopfinder.busstopfinder.repositories;

import com.busstopfinder.busstopfinder.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;    
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    boolean existsByRouteNumber(String routeNumber);

    Page<Route> findAll(Pageable pageable);

}
