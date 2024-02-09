package com.example.Project.model;

public class Reservation {
    private int id_user;
    private int id_trip;

    public Reservation(int id_user, int id_trip) {
        this.id_user = id_user;
        this.id_trip = id_trip;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_trip() {
        return id_trip;
    }

    public void setId_trip(int id_trip) {
        this.id_trip = id_trip;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id_user=" + id_user +
                ", id_trip=" + id_trip +
                '}';
    }
}
