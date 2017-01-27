package com.example.edwardfouxvictorious.ebayproject.view;


import com.example.edwardfouxvictorious.ebayproject.model.EarthquakeResponse;

/**
 * Interface to bridge UI (MainActivity) and the Presenter (MVP pattern)
 */
public interface ActivityView {
    /**
     * Called by presenter when the data is ready
     * @param response EarthquakeResponse payload
     */
    void onDataAvailable(EarthquakeResponse response);
}
