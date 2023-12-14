package model;

import java.util.Date;

public class Vehicle {

    private int vehicleNumber;
    private String vehicleType;
    private String fuelType;
    private String modelName;
    private Date vehicleBuyDate;
    private String vehicleOwnerName;

    public Vehicle(int vehicleNumber, String vehicleType, String fuelType, String modelName, Date vehicleBuyDate, String vehicleOwnerName) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.modelName = modelName;
        this.vehicleBuyDate = vehicleBuyDate;
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public Vehicle() {
    }


    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Date getVehicleBuyDate() {
        return vehicleBuyDate;
    }

    public void setYear(Date year) {
        this.vehicleBuyDate = year;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                ", vehicleNumber=" + vehicleNumber +
                ", vehicleType='" + vehicleType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", modelName='" + modelName + '\'' +
                ", year=" + vehicleBuyDate +
                ", vehicleOwnerName='" + vehicleOwnerName + '\'' +
                '}';
    }
}
