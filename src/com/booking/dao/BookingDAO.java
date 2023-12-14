package com.booking.dao;

import com.booking.model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {
    private Connection connection;

    public BookingDAO(Connection connection) {
        this.connection = connection;
    }

    public int getLatestID() throws SQLException {
        String query = "SELECT MAX(bookingId) AS latestID FROM Booking";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("latestID");
            } else {
                return 0; // No bookings exist, return 0
            }
        }
    }
    public void saveBooking(Booking booking) throws SQLException {
//        System.out.println("Inside saveBOoking" + booking.getBookingId());
        String query = "INSERT INTO Booking (bookingId,movieId, showTiming, numberOfTickets, totalCost) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, booking.getBookingId());
            preparedStatement.setInt(2,booking.getMovieId());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(booking.getShowTiming()));
            preparedStatement.setInt(4, booking.getNumberOfTickets());
            preparedStatement.setDouble(5, booking.getTotalCost());
            preparedStatement.executeUpdate();
        }
    }
}
