package com.example.sp346_utccnav;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class calculateNear {

    public double latitude;
    public double longtitude;

    private void getLocation(){
    }
    public String getSampleBuildingName() {

        return "Lat: " + latitude + ", Lon: " + longtitude;
    }
}
