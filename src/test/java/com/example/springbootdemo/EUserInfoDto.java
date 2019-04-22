package com.example.springbootdemo;

import lombok.Data;

@Data
public class EUserInfoDto {
    private Driver driver;
    private Car car;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
