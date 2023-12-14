package com.booking;

import com.booking.dao.DBConnectionManager;
import com.booking.dao.MovieDAO;
import com.booking.service.MovieService;
import java.sql.Connection;



public class Main {
    public static void main(String[] args) {
        Connection conn = DBConnectionManager.establishConnection();
        MovieDAO mdao = new MovieDAO(conn);
        MovieService movieService = new MovieService(mdao);

        movieService.bookingFlow(conn);

        // Updated shows
        System.out.println("Here are the updated shows with the timings and avaialble tickets !! ");
        movieService.displayShows();

    }
}

