package com.meeting.entity;

public class Car {

    private String brand;
    private String color;
    private String output;

    public Car(String brand, String color, String output) {
        this.brand = brand;
        this.color = color;
        this.output = output;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
