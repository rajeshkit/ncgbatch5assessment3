package com.booking.model;
import java.time.LocalDateTime;
public class Booking {
    private int bookingId;
    private int movieId;
    private LocalDateTime showTiming;
    private int numberOfTickets;
    private double totalCost;

    public Booking(int bookingId, int movieId, LocalDateTime showTiming, int numberOfTickets, double totalCost) {
        this.bookingId = bookingId;
        this.movieId = movieId;
        this.showTiming = showTiming;
        this.numberOfTickets = numberOfTickets;
        this.totalCost = totalCost;
    }

    // Getters and Setters

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getShowTiming() {
        return showTiming;
    }

    public void setShowTiming(LocalDateTime showTiming) {
        this.showTiming = showTiming;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // toString for easy printing
    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", movieId=" + movieId +
                ", showTiming=" + showTiming +
                ", numberOfTickets=" + numberOfTickets +
                ", totalCost=" + totalCost +
                '}';
    }
}
