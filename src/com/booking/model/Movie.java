package com.booking.model;

import java.time.LocalDateTime;

public class Movie {
    private int movieId;
    private String title;
    private LocalDateTime showTiming;
    private int availableTickets;

    public Movie(int movieId, String title, LocalDateTime showTiming, int availableTickets) {
        this.movieId = movieId;
        this.title = title;
        this.showTiming = showTiming;
        this.availableTickets = availableTickets;
    }

    // Getters and Setters

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getShowTiming() {
        return showTiming;
    }

    public void setShowTiming(LocalDateTime showTiming) {
        this.showTiming = showTiming;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    // toString for easy printing
    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", showTiming=" + showTiming +
                ", availableTickets=" + availableTickets +
                '}';
    }
}
