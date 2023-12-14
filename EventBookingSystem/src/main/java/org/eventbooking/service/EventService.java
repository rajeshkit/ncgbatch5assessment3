package org.eventbooking.service;

import org.eventbooking.dao.EventDao;
import org.eventbooking.model.Event;

import java.util.List;

public class EventService {
    public List<Event> listAllEvents()
    {
        EventDao dao=new EventDao();
         return dao.listAllEvents();
    }
    public int updateTicketCountInEvent(Event event, int noOfTicketsBooked) {
        EventDao dao=new EventDao();
        return dao.updateTicketCountInEvent(event, noOfTicketsBooked);
    }
}
