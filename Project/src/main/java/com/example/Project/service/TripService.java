package com.example.Project.service;

import com.example.Project.dao.TripDao;
import com.example.Project.model.Trip;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TripService {

    private TripDao tripDao;

    public TripService(TripDao tripDao) {
        this.tripDao = tripDao;
    }
    /*
    public void addTrip(int id, String name, Date checkIn, Date checkOut, int numberOfPersons){
        tripDao.addTrip(id,name,checkIn,checkOut,numberOfPersons);
    }*/

    public List<Trip> showTrips(String name, Date checkIn, Date checkOut){
        return tripDao.showTrips(name,checkIn,checkOut);
    }
}
