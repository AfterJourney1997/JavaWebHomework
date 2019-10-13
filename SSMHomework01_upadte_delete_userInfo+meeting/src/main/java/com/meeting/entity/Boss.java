package com.meeting.entity;

public class Boss {

    private String name;
    private String corporation;
    private Car car;
    private String hobby;

    public Boss() {
    }

    public Boss(String name, String corporation, Car car, String hobby) {
        this.name = name;
        this.corporation = corporation;
        this.car = car;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", corporation='" + corporation + '\'' +
                ", car=" + car +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
