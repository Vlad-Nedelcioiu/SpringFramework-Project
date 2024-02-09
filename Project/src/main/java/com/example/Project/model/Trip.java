package com.example.Project.model;

import java.sql.Date;

public class Trip {
    private int id;
    private String destination;
    private Date checkIn;
    private Date checkOut;
    private int numberOfPersons;

    public Trip(String destination, Date checkIn, Date checkOut) {

        this.destination = destination;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        //this.numberOfPersons = numberOfPersons;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
    /*
    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
    */

    @Override
    public String toString() {
        return "Trip{" +
                ", destination='" + destination + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                //", numberOfPersons=" + numberOfPersons +
                '}';
    }
}
