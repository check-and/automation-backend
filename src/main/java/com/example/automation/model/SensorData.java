package com.example.automation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
@Data
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private double value;
    @Column(nullable = false)
    private LocalDateTime time;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
