package com.example.sp346_utccnav;

public class Building {
    private String name;
    private double latitude;
    private double longitude;
    private String description;

    public Building(String name, double latitude, double longitude, String description) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public String getName() { return name; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getDescription() { return description; }
}