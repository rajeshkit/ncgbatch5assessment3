package dao;

import exception.VehicleNotFoundException;
import model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    public int addVehicleDao(Vehicle vehicle) {
        String url = "jdbc:mysql://localhost:3306/vehicle_information_system";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        int status = 0;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `vehicle_info` VALUES (?, ?, ?, ?,?,?)");
            preparedStatement.setInt(1,vehicle.getVehicleNumber());
            preparedStatement.setString(2, vehicle.getVehicleType());
            preparedStatement.setString(3, vehicle.getFuelType());
            preparedStatement.setString(4,vehicle.getModelName());
            preparedStatement.setDate(5,  new Date(vehicle.getVehicleBuyDate().getTime()));
            preparedStatement.setString(6, vehicle.getVehicleOwnerName());
            status = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }


    public int editVehicleDetailsDao(int vehicleNumber, Vehicle vehicle) {
        String url = "jdbc:mysql://localhost:3306/vehicle_information_system";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        int status = 0;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `vehicle_info` SET vehicle_type=?,fuel_type=?,model_name=?,year=?,owner_name=? WHERE vehicle_number=?");
            preparedStatement.setInt(6,vehicle.getVehicleNumber());
            preparedStatement.setString(1, vehicle.getVehicleType());
            preparedStatement.setString(2, vehicle.getFuelType());
            preparedStatement.setString(3,vehicle.getModelName());
            preparedStatement.setDate(4,  new Date(vehicle.getVehicleBuyDate().getTime()));
            preparedStatement.setString(5, vehicle.getVehicleOwnerName());
            status = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }


    public Vehicle displayVehicleDetailsDao(int vehicleNumber) {
        String url = "jdbc:mysql://localhost:3306/vehicle_information_system";
        String username = "root";
        String password = "ankit2611";
        Connection connection = null;
        Vehicle vehicle= new Vehicle();
        try {
            connection=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM `vehicle_info` WHERE vehicle_number=?");
            preparedStatement.setInt(1,vehicleNumber);
            ResultSet rs=preparedStatement.executeQuery();

            while (rs.next()){
                vehicle.setVehicleNumber(rs.getInt(1));
                vehicle.setVehicleType(rs.getString(2));
                vehicle.setFuelType(rs.getString(3));
                vehicle.setModelName(rs.getString(4));
                vehicle.setYear(rs.getTime(5));
                vehicle.setVehicleOwnerName(rs.getString(6));

            }
            if (vehicle.getVehicleNumber()==0){
                throw new VehicleNotFoundException();
            }
           
            connection.close();
            preparedStatement.close();

        } catch (SQLException | VehicleNotFoundException e) {
            throw new RuntimeException(e);
        }
        return vehicle;
    }
}
