package com.example.vehicle.vehiclee.service;

import com.example.vehicle.vehiclee.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DbInfo {

    private ArrayList<Vehicle>  gaddiList= new ArrayList<Vehicle>();

    public DbInfo()
    {
        this.gaddiList.add(new Vehicle("sedan","AKBKO",5));
        this.gaddiList.add(new Vehicle("hatchback","AKBKMN",3));
        this.gaddiList.add(new Vehicle("truck","BKOJNH",5));
    }

    public ArrayList<Vehicle> getAllVehicle()
    {
        return  gaddiList;
    }

}
