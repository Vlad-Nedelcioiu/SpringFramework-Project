package com.example.Project.dao;

import com.example.Project.model.Trip;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TripDao {

    private Connection connection;

    private PreparedStatement showTrips;
    private PreparedStatement findAllTrips;


    public TripDao(Connection connection) {
        this.connection = connection;

        try {
            showTrips = connection.prepareStatement("SELECT * FROM trips WHERE name = ? AND checkIn >= ? AND checkOut <= ?");
            findAllTrips = connection.prepareStatement("SELECT * FROM trips");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Trip> showTrips(String name, Date checkIn, Date checkOut) {
        List<Trip> tripList = new ArrayList<Trip>();
        try {

            showTrips.setString(1,name);
            showTrips.setDate(2,checkIn);
            showTrips.setDate(3,checkOut);
            ResultSet resultSet = showTrips.executeQuery();

            while(resultSet.next()){
                String tripName = resultSet.getString("name");
                Date checkInDate = resultSet.getDate("checkIn");
                Date checkOutDate = resultSet.getDate("checkOut");
                tripList.add(new Trip(tripName,checkInDate,checkOutDate));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return tripList;
    }

    public List<Trip> findAll(){
        List<Trip> tripList = new ArrayList<Trip>();
        try {
            ResultSet resultSet = findAllTrips.executeQuery();
            while(resultSet.next()){
                String tripName = resultSet.getString("name");
                Date checkInDate = resultSet.getDate("checkIn");
                Date checkOutDate = resultSet.getDate("checkOut");
                tripList.add(new Trip(tripName,checkInDate,checkOutDate));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tripList;
    }
}