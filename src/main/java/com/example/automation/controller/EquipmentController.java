package com.example.automation.controller;

import com.example.automation.dto.EquipmentRequest;
import com.example.automation.model.Equipment;
import com.example.automation.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @Autowired
    private SensorDataService sensorDataService;

    @PostMapping
    public Equipment equipment(@RequestBody EquipmentRequest request) {
        Equipment data = sensorDataService.equipment2(request);
        return data;
    }
}