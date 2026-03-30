package com.example.automation.controller;

import com.example.automation.dto.SensorDataRequest;
import com.example.automation.model.SensorData;
import com.example.automation.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensor-data")

public class SensorDataController {
    @Autowired
    private SensorDataService sensorDataService;
    @PostMapping
    public SensorData request(@RequestBody SensorDataRequest request){

    SensorData data = sensorDataService.saveSensorData(request);
    return data;
    }
}
