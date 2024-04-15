package com.example.Project.service;

import com.example.Project.dao.TripDao;
import com.example.Project.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripDao tripDao;

    public TripService(TripDao tripDao) {
        this.tripDao = tripDao;
    }


    public List<Trip> showTrips(String name, Date checkIn, Date checkOut){
        return tripDao.showTrips(name,checkIn,checkOut);
    }

    public List<Integer> getAllFlightIds(){
        List<Trip> trips = tripDao.findAll();
        List<Integer> tripIds = new ArrayList<>();
        for(Trip trip : trips){
            tripIds.add(trip.getId());
        }
        return tripIds;
    }
}
