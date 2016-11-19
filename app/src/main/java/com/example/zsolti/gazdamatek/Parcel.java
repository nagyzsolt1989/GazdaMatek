package com.example.zsolti.gazdamatek;

/**
 * Created by Zsolti on 2016.11.17..
 * A class to store information about a parcel
 */

public class Parcel {

    public String name;
    public String area;
    public String plant;

    //SETTERS

    public void setParcelName(String parcelName)
    {
        this.name = parcelName;
    }

    public void setParcelArea(String parcelArea)
    {
        this.area = parcelArea;
    }

    public void setPlant(String plant)
    {
        this.plant = plant;
    }

    //GETTER

    public String getName()
    {
        return this.name;
    }

    public String getArea()
    {
        return this.area;
    }

    public String getPlant()
    {
        return this.plant;
    }

    //CONSTRUCTOR

    public Parcel(String name, String area, String plant)
    {
        this.name = name;
        this.area = area;
        this.plant = plant;
    }

}
