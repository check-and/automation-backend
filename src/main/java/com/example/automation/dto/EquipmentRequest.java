package com.example.automation.dto;


public class EquipmentRequest {
    private String name;
    private Integer workshop;
    private String location;
    private Integer normalMin;
    private Integer normalMax;
    private String unit;

    public EquipmentRequest() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getWorkshop(){
        return workshop;
    }
    public void setWorkshop(Integer workshop){
        this.workshop=workshop;
    }
    public String getLocation(){
        return location;}
    public void setLocation(String location){
        this.location=location;}
    public Integer getNormalMin(){
        return normalMin;}
    public void setNormalMin(Integer normalMin){
    this.normalMin= normalMin;}
    public Integer getNormalMax(){
        return normalMax;}
    public void setNormalMax(Integer normalMax){
        this.normalMax=normalMax;}
    public String getUnit(){
        return unit;}
    public void setUnit(String unit){
        this.unit=unit;}

}

