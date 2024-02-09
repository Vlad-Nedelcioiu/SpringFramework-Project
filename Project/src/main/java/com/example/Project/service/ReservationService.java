package com.example.Project.service;

import com.example.Project.dao.ReservationDao;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private ReservationDao reservationDao;

    public ReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public void createReservation(int id_user, int id_trip){
        reservationDao.createReservation(id_user,id_trip);
    }

    public void showReservationsByIdUser(int id_user){
        reservationDao.showReservationsByIdUser(id_user);
    }
}
