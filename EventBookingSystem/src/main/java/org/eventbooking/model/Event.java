package org.eventbooking.model;

import java.util.Date;

public class Event {
    private String name;
    private Date doe;
    private String venue;
    private int noOfTicketsAvailable;
    private int costPerTicket;
    private int eventId;

    public Event(String name, Date doe, String venue, int noOfTicketsAvailable, int costPerTicket, int eventId) {
        this.name = name;
        this.doe = doe;
        this.venue = venue;
        this.noOfTicketsAvailable = noOfTicketsAvailable;
        this.costPerTicket = costPerTicket;
        this.eventId = eventId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Event() {

    }

    @Override
    public String toString() {
        return  "Event Name='" + name + '\'' +
                ", Doe=" + doe +
                ", venue='" + venue + '\'' +
                ", noOfTicketsAvailable=" + noOfTicketsAvailable +
                ", costPerTicket=" + costPerTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDoe() {
        return doe;
    }

    public void setDoe(Date doe) {
        this.doe = doe;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getNoOfTicketsAvailable() {
        return noOfTicketsAvailable;
    }

    public void setNoOfTicketsAvailable(int noOfTicketsAvailable) {
        this.noOfTicketsAvailable = noOfTicketsAvailable;
    }

    public int getCostPerTicket() {
        return costPerTicket;
    }

    public void setCostPerTicket(int costPerTicket) {
        this.costPerTicket = costPerTicket;
    }
}
