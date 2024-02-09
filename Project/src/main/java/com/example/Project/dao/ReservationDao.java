package com.example.Project.dao;

import org.springframework.stereotype.Repository;

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

    public void createReservation(int id_user, int id_trip){
        try {
            createReservation.setInt(1,id_user);
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
                resultSet.getInt(id_user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
