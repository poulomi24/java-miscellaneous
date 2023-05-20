package com.builder;

public class VehicleBuilder {
 String engine;
 int wheel;
 int airbags;

 public VehicleBuilder(String engine, int wheel)
 {
     this.engine = engine;
     this.wheel = wheel;
 }

    public VehicleBuilder setAirbags(int airbags) {
        this.airbags = airbags;
        return this;
    }

    public Vehicle build()
    {
        return new Vehicle(this);
    }
}
