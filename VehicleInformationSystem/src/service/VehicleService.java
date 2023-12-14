package service;

import dao.VehicleDao;
import exception.VehicleNotFoundException;
import model.Vehicle;

public class VehicleService{

VehicleDao vehicleDao= new VehicleDao();
    public int addVehicle(Vehicle vehicle) {
       return  vehicleDao.addVehicleDao(vehicle);
    }


    public int editVehicleDetails(int vehicleNumber, Vehicle vehicle) {
       return vehicleDao.editVehicleDetailsDao(vehicleNumber,vehicle);
    }


    public Vehicle displayVehicleDetails(int vehicleNumber){

      return   vehicleDao.displayVehicleDetailsDao(vehicleNumber);

    }
}
