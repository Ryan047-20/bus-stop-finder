package com.busstopfinder.busstopfinder.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Data
@Entity
@Table(name = "Routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String routeNumber;

    @Column(nullable = false)
    private String startPoint;

    @Column(nullable = false)
    private String endPoint;

    @ManyToMany
    @JoinTable(
        name = "bus_stop_route",
        joinColumns = @JoinColumn(name = "route_id"),
        inverseJoinColumns = @JoinColumn(name = "bus_stop_id")
    )
    private List<BusStop> busStops;
}
