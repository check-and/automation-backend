package com.example.automation.service;

import com.example.automation.dto.EquipmentRequest;
import com.example.automation.repository.EquipmentRepository;
import com.example.automation.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.automation.model.SensorData;
import com.example.automation.dto.SensorDataRequest;
import com.example.automation.dto.SensorDataRequest;
import com.example.automation.model.Equipment;
import com.example.automation.model.SensorData;
import com.example.automation.repository.EquipmentRepository;
import com.example.automation.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class SensorDataService {
    @Autowired
    public SensorDataRepository sensorDataRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;

    public SensorData saveSensorData(SensorDataRequest request) {
    Long equipmentId = request.getEquipmentId();
    equipmentRepository.findById(equipmentId).orElseThrow(() -> new RuntimeException("Equipment not found"));
    Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
    SensorData data = new SensorData();
        data.setEquipment(equipment);
        data.setValue(request.getValue());
        data.setTime(request.getTime());
        SensorData saved = sensorDataRepository.save(data);
        return saved;
    }

















    public Equipment equipment2(EquipmentRequest request){
        Equipment data2 = new Equipment();
        data2.setName(request.getName());
        data2.setWorkshop(request.getWorkshop());
        data2.setLocation(request.getLocation());
        data2.setNormalMin(request.getNormalMin());
        data2.setNormalMax(request.getNormalMax());
        data2.setUnit(request.getUnit());
        Equipment save = equipmentRepository.save(data2);
        return data2;
    }
}
//Теперь нужен метод, который будет принимать SensorDataRequest и возвращать SensorData