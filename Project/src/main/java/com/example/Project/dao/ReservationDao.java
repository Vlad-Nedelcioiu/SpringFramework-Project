package com.example.Project.dao;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ReservationDao {

    private Connection connection;

    PreparedStatement createReservation;
    PreparedStatement showReservationsByIdUser;

    public ReservationDao(Connection connection) {
        this.connection = connection;

        try {
            createReservation = connection.prepareStatement("INSERT INTO reservations VALUES(null,?,?)"); //TODO de sters aici
            showReservationsByIdUser = connection.prepareStatement("SELECT * FROM reservations WHERE id_user = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createReservation(String userName, int id_trip){
        try {
            createReservation.setString(1,userName);
            createReservation.setInt(2,id_trip);
            createReservation.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showReservationsByIdUser(int id_user){
        try {
            showReservationsByIdUser.setInt(1,id_user);
            ResultSet resultSet = showReservationsByIdUser.executeQuery();
            while(resultSet.next()){
                resultSet.getInt("id_user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
