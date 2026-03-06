package com.busstopfinder.busstopfinder.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "provinces")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;
}