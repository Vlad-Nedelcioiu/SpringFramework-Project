package com.example.Project.service;

import com.example.Project.dao.ReservationDao;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ReservationService {
    private ReservationDao reservationDao;

    public ReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public void createReservation(String userName, int id_trip){
        reservationDao.createReservation(userName,id_trip);
    }

    public void showReservationsByIdUser(int id_user){
        reservationDao.showReservationsByIdUser(id_user);
    }

}
