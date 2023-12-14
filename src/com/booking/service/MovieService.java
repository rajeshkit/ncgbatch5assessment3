package com.booking.service;


import com.booking.dao.BookingDAO;
import com.booking.dao.MovieDAO;
import com.booking.exception.MovieIDNotFoundException;
import com.booking.model.Booking;
import com.booking.model.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    private final MovieDAO mdao;
    // injecting DAO inside the MovieService
    public MovieService(MovieDAO mdao){
        this.mdao = mdao;
    }

    public void bookingFlow(Connection conn){
        this.displayShows();

        Movie enquiredBooking = this.enquireBooking();
        while(enquiredBooking==null) {
            System.out.println("You have entered a wrong ID please enter the ID properly");
            enquiredBooking = this.enquireBooking();
        }

        System.out.println("Movie chosen is "+enquiredBooking);
        this.bookTickets(enquiredBooking,conn);
    }

    //Method to get all the movies
    public List<Movie> getAllMovies()  {
        List<Movie> movies = new ArrayList<>();
       ResultSet resultSet = mdao.getAllMovies();

            try {
                while(resultSet.next()) {
                int movieId = resultSet.getInt("movieId");
                String title = resultSet.getString("title");
                LocalDateTime showTiming = resultSet.getTimestamp("showTiming").toLocalDateTime();
                int availableTickets = resultSet.getInt("availableTickets");
                movies.add(new Movie(movieId, title, showTiming, availableTickets));
            }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        return movies;
    }
    public Movie getMovieById(int movieId) throws SQLException, MovieIDNotFoundException {
        try{
            return mdao.getMovieById(movieId);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    public Movie enquireBooking(){
        Movie selectedMovie = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the movie you want to select: ");
        int selectedMovieId = scanner.nextInt();
        try {
            selectedMovie = this.getMovieById(selectedMovieId);
            if(selectedMovie==null)throw new MovieIDNotFoundException("You have provided wrong movie ID");
        } catch (MovieIDNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return selectedMovie;

    }

    public void displayShows(){
        List<Movie> movies = this.getAllMovies();
        System.out.println("Available Movies:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void bookTickets(Movie selectedMovie, Connection conn) {
        if(selectedMovie.getAvailableTickets()==0){
            System.out.println("Movie is housefull, book another movie");
            this.bookingFlow(conn);
        }
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of tickets you want to book: ");
            int numberOfTickets = scanner.nextInt();
            while(numberOfTickets<=0 & numberOfTickets<=selectedMovie.getAvailableTickets()){
              System.out.println("Please enter valid number of tickets");
              numberOfTickets = scanner.nextInt();
            }
            // Perform booking
            double totalCost = calculateTotalCost(selectedMovie, numberOfTickets);
            BookingDAO bookingDAO = new BookingDAO(conn);
            Booking booking = new Booking(bookingDAO.getLatestID()+1, selectedMovie.getMovieId(), selectedMovie.getShowTiming(), numberOfTickets, totalCost);

            bookingDAO.saveBooking(booking);

            // Update available tickets in Movie table
            selectedMovie.setAvailableTickets(selectedMovie.getAvailableTickets() - numberOfTickets);
            //If user wishes to book all the tickets
            if(selectedMovie.getAvailableTickets()==0) {
                System.out.println(selectedMovie.getTitle() + " is fullhouse !");
            }
             mdao.updateAvailableTickets(selectedMovie);

            System.out.println("Booking successful! You have booked " + numberOfTickets + " tickets for the show.");
            System.out.println("Total Cost: $" + totalCost);


        } catch (SQLException e) {
            e.printStackTrace(); // Handle database errors
        }
    }

    private double calculateTotalCost(Movie selectedMovie, int numberOfTickets) {
        return 10.0 * numberOfTickets;
    }


    
}
