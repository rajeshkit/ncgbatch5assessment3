package org.eventbooking.dao;

import org.eventbooking.model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDao {
    public List<Event> listAllEvents()
    {
        String url = "jdbc:mysql://localhost:3306/eventbooking";
        String user = "root";
        String password = "Mns@164.";
        final List<Event> events = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM event");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Event event = new Event();
                event.setName(rs.getString(1));
                event.setDoe(rs.getDate(2));
                event.setVenue(rs.getString(3));
                event.setNoOfTicketsAvailable(rs.getInt(4));
                event.setCostPerTicket(rs.getInt(5));
                event.setEventId(rs.getInt(6));
                events.add(event);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
     return events;
    }

    public int updateTicketCountInEvent(Event event, int noOfTicketsBooked) {
        String url = "jdbc:mysql://localhost:3306/eventbooking";
        String user = "root";
        String password = "Mns@164.";
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE event SET noOfTicketsAvailable=? WHERE name=? AND date=? AND venue=?");
            pstmt.setInt(1, event.getNoOfTicketsAvailable() - noOfTicketsBooked);
            pstmt.setString(2, event.getName());
            pstmt.setDate(3, new Date(event.getDoe().getTime()));
            pstmt.setString(4, event.getVenue());
            result = pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
