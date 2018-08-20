package com.example.vehicle.vehiclee.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Vehicle {

    private String  vehicel_type;
    private String model;
    private int capacity;
@NotNull
@Size(min=2)
    public Vehicle(String type,String model, int capacity)
    {
        this.capacity=capacity;
        this.model=model;
        this.vehicel_type=type;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getVehicel_type() {
        return vehicel_type;
    }

    public void setVehicel_type(String vehicel_type) {
        this.vehicel_type = vehicel_type;
    }
}
