package com.frankov.model;

public class Office {

    private int id;
    private String title;
    private double lon;
    private double lat;
    private String address;
    private long distance;

    public Office(int id, String title, double lon, double lat, String address) {
        this.id = id;
        this.title = title;
        this.lon = lon;
        this.lat = lat;
        this.address = address;
    }

    public Office(int id, String title, double lon, double lat, String address, long distance) {
        this.id = id;
        this.title = title;
        this.lon = lon;
        this.lat = lat;
        this.address = address;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public String getAddress() {
        return address;
    }

    public long getDistance() {
        return distance;
    }

}
