package com.example.automation.dto;


import java.time.LocalDateTime;

public class SensorDataRequest {
    private Double value;
    private LocalDateTime time;
    private Long equipmentId;

    public SensorDataRequest() {
    }

    public Double getValue() {
        return value;}
    public void setValue(Double value){
        this.value = value;
    }

    public LocalDateTime getTime(){
        return time;
    }
    public void setTime(LocalDateTime time){
        this.time = time;
    }

    public Long getEquipmentId(){
        return equipmentId;
    }
    public void setEquipment(Long equipment){
        this.equipmentId = equipment;
    }
}
// на основе этого класса получаем данные от клиента, и на основе модели
// сохраням потом данные в бд