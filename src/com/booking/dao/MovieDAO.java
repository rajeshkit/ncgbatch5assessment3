package com.booking.dao;

import com.booking.exception.MovieIDNotFoundException;
import com.booking.model.Movie;

import java.sql.*;
import java.time.LocalDateTime;


public class MovieDAO {
    private Connection conn;
    public MovieDAO(Connection conn){
        this.conn = conn;
    }

    public ResultSet getAllMovies() {
        ResultSet resultSet = null;
        try{
            Statement stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM Movie");
        }catch(SQLException e){
          e.printStackTrace();
        }
        return resultSet;
    }

    public Movie getMovieById(int movieId) throws SQLException, MovieIDNotFoundException {
        String query = "SELECT * FROM Movie WHERE movieId = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, movieId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                LocalDateTime showTiming = resultSet.getTimestamp("showTiming").toLocalDateTime();
                int availableTickets = resultSet.getInt("availableTickets");
                return new Movie(movieId, title, showTiming, availableTickets);
            } else {
                throw new MovieIDNotFoundException("Movie with ID " + movieId + " not found.");
            }
        }
    }
    public void updateAvailableTickets(Movie movie) throws SQLException {
        String query = "UPDATE Movie SET availableTickets = ? WHERE movieId = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, movie.getAvailableTickets());
            preparedStatement.setInt(2, movie.getMovieId());
            preparedStatement.executeUpdate();
        }
    }




}
