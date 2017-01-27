package com.example.edwardfouxvictorious.ebayproject.net;

import com.example.edwardfouxvictorious.ebayproject.model.EarthquakeResponse;

import retrofit.Call;
import retrofit.http.GET;

import static com.example.edwardfouxvictorious.ebayproject.presenter.ListPresenter.URL_PATH;

public interface EarthquakeRequest {
    @GET(URL_PATH)
    Call<EarthquakeResponse> getEarthQuackesList();
}
