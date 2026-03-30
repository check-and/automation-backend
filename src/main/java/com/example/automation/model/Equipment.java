package com.example.automation.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.lang.model.element.Name;

@Entity
@Table (name = "equipment")
@Data //lombok

public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer workshop;
    @Column (nullable = false)
    private String location;
    @Column (nullable = false)
    private Integer normalMin;
    private Integer normalMax;
    @Column (nullable = false)
    private String unit;

}
