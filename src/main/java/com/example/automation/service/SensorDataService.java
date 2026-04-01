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
import org.springframework.beans.factory.annotation.Value;

@Service

public class SensorDataService {


    private final SensorDataRepository sensorDataRepository;
    private final EquipmentRepository equipmentRepository;
    private final EmailService emailService; // Добавили
    private final String engineerEmail;

    public SensorDataService(SensorDataRepository sensorDataRepository,
                             EquipmentRepository equipmentRepository,
                             EmailService emailService, // Добавили в конструктор
                             @Value("${engineer.email}") String engineerEmail) { // Добавили email из настроек
        this.sensorDataRepository = sensorDataRepository;
        this.equipmentRepository = equipmentRepository;
        this.emailService = emailService; // Инициализируем
        this.engineerEmail = engineerEmail; // Инициализируем
    }


    public SensorData saveSensorData(SensorDataRequest request) {
        // 1. Находим оборудование
        Equipment equipment = equipmentRepository.findById(request.getEquipmentId())
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        // 2. Проверяем, не вышло ли значение за пределы нормы
        double value = request.getValue();
        if (value < equipment.getNormalMin() || value > equipment.getNormalMax()) {
            String message = String.format(
                    "⚠️ Отклонение от нормы!\nОборудование: %s\nЗначение: %.2f %s\nНорма: %.2f - %.2f",
                    equipment.getName(), value, equipment.getUnit(),
                    equipment.getNormalMin(), equipment.getNormalMax()
            );

            // Отправляем письмо
            emailService.sendAlert(engineerEmail, "ВНИМАНИЕ: Отклонение от нормы!", message);
        }

        // 3. Создаём и сохраняем показание
        SensorData data = new SensorData();
        data.setEquipment(equipment);
        data.setValue(value);
        data.setTime(request.getTime());   // важно: поле в DTO называется time
        return sensorDataRepository.save(data);
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