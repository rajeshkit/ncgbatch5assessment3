package main;

import exception.VehicleNotFoundException;
import model.Vehicle;
import service.VehicleService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VehicleInformationSystem {


    public static void addVehicle() throws ParseException {
        System.out.println("Enter Vehicle Details");
        System.out.println("-------------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your vehicle number");
        int vehicleNumber = input.nextInt();
        input.nextLine();
        System.out.println("Enter your vehicle type");
        String vehicleType = input.nextLine();
        System.out.println("Enter vehicle fuel type");
        String fuelType = input.nextLine();
        System.out.println("Enter vehicle model name");
        String modelName = input.nextLine();
        System.out.println("Enter date of buy vehicle/ dd-MM-yyyy");
        String  dateOfBuy = input.nextLine();
        System.out.println("Enter the owner name");
        String ownerName=input.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(dateOfBuy);
        Vehicle vehicle= new Vehicle(vehicleNumber,vehicleType,fuelType,modelName,date,ownerName);
        VehicleService vehicleService= new VehicleService();
        int i = vehicleService.addVehicle(vehicle);
        if (i==1){
            System.out.println("Vehicle added successfully !!");
        }else{
            System.out.println("Failed to add vehicle");
        }

    }
    public static void editVehicleDetails() throws ParseException {
        System.out.println("Enter Updated Vehicle Details");
        System.out.println("-------------------------");
        System.out.println("Enter your vehicle number");
        Scanner input = new Scanner(System.in);
        int vehicleNumber = input.nextInt();
        System.out.println("Enter your vehicle type");
        String vehicleType = input.next();
        System.out.println("Enter vehicle fuel type");
        String fuelType = input.next();
        System.out.println("Enter vehicle model name");
        String modelName = input.next();
        System.out.println("Enter date of buy vehicle/ dd-MM-yyyy");
        String  dateOfBuy = input.next();
        System.out.println("Enter the owner name");
        String ownerName=input.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(dateOfBuy);
        Vehicle vehicle= new Vehicle(vehicleNumber,vehicleType,fuelType,modelName,date,ownerName);
        VehicleService vehicleService= new VehicleService();
        int i = vehicleService.editVehicleDetails(vehicleNumber, vehicle);
        if (i==1){
            System.out.println("Vehicle updated successfully !!");
        }else{
            System.out.println("Failed to update vehicle");
        }

    }
    public static void displayVehicleDetails() throws VehicleNotFoundException {
        System.out.println("Enter the vehicle number");
        Scanner sc= new Scanner(System.in);
        int vehicleNumber = sc.nextInt();
        VehicleService vehicleService= new VehicleService();
        Vehicle vehicle = vehicleService.displayVehicleDetails(vehicleNumber);
        System.out.println("Vehicle details are:");
        System.out.println(vehicle);
    }

    public static void main(String[] args) throws ParseException, VehicleNotFoundException {

        System.out.println("Vehicle Information System");
        System.out.println("Press 1: add new Vehicle");
        System.out.println("Press 2: edit vehicle details");
        System.out.println("Press 3: Display vehicle details");
        System.out.println("Press 0: Exit");
        Scanner sc= new Scanner(System.in);
        int input = sc.nextInt();
        switch (input){
            case 1:
                addVehicle();
                break;
            case 2:
                editVehicleDetails();
                break;
            case 3:
                displayVehicleDetails();
                break;
            case 0:
                System.out.println("Thank you !!");
                break;
        }
    }
}
