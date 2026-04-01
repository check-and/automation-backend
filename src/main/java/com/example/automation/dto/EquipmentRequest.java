package com.example.automation.dto;


public class EquipmentRequest {
    private String name;
    private Integer workshop;
    private String location;
    private Double normalMin;
    private Double normalMax;
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
    public Double getNormalMin(){
        return normalMin;}
    public void setNormalMin(Double normalMin){
    this.normalMin= normalMin;}
    public Double getNormalMax(){
        return normalMax;}
    public void setNormalMax(Double normalMax){
        this.normalMax=normalMax;}
    public String getUnit(){
        return unit;}
    public void setUnit(String unit){
        this.unit=unit;}

}

