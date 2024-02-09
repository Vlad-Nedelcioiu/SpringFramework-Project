package com.example.Project.dao;

import com.example.Project.model.Trip;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TripDao {

    private Connection connection;

    // private PreparedStatement addTrip;
    private PreparedStatement showTrips;


    public TripDao(Connection connection) {
        this.connection = connection;

        try {
            //addTrip = connection.prepareStatement("INSERT INTO trips VALUES(null,?,?,?,?)");
            showTrips = connection.prepareStatement("SELECT * FROM trips WHERE name = ? AND checkIn >= ? AND checkOut <= ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    public void addTrip(int id, String name, Date checkIn, Date checkOut, int numberOfPersons) {
        try {
            addTrip.setInt(1, id);
            addTrip.setString(2, name);
            addTrip.setDate(3, checkIn);
            addTrip.setDate(4, checkOut);
            addTrip.setInt(5, numberOfPersons);
            addTrip.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

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
}