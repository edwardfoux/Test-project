package com.example.edwardfouxvictorious.ebayproject.model;

import java.util.List;


public class EarthquakeResponse {

    private List<Earthquake> earthquakes;

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    @Override
    public String toString() {
        return "EarthquakeResponse{" +
                "earthquakes=" + earthquakes +
                '}';
    }
}
