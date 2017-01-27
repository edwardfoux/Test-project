package com.example.edwardfouxvictorious.ebayproject.presenter;

import android.support.annotation.VisibleForTesting;

import com.example.edwardfouxvictorious.ebayproject.model.EarthquakeResponse;
import com.example.edwardfouxvictorious.ebayproject.net.ApiCallback;
import com.example.edwardfouxvictorious.ebayproject.net.EarthquakeRequest;
import com.example.edwardfouxvictorious.ebayproject.view.ActivityView;

import java.lang.ref.WeakReference;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Presenter class for the business logic of the MainActivity
 * Takes care of the networking data loading (Using Retrofit api)
 */
public class ListPresenter {

    public static final String URL = "http://api.geonames.org";
    public static final String URL_PATH = "/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman";

    @VisibleForTesting
    ActivityView view;

    @VisibleForTesting
    DataLoaderCallback dataLoaderCallback = new DataLoaderCallback(this);

    public ListPresenter(ActivityView view) {
        super();
        this.view = view;
    }

    /**
     * Called by the MainActivity to start loading the data
     */
    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EarthquakeRequest earthquakeApi = retrofit.create(EarthquakeRequest.class);

        Call<EarthquakeResponse> call = earthquakeApi.getEarthQuackesList();
        call.enqueue(dataLoaderCallback);
    }

    /**
     * static class for the networking job
     * Keeps the weak reference to the presenter to avoid memory leaks
     */
    @VisibleForTesting
    class DataLoaderCallback extends ApiCallback<EarthquakeResponse> {
        WeakReference<ListPresenter> ref;

        private DataLoaderCallback(ListPresenter page) {
            this.ref = new WeakReference<>(page);
        }

        @Override
        public void onSuccess(EarthquakeResponse response) {
            ListPresenter listPresenter = ref.get();
            if (listPresenter == null) return;

            listPresenter.view.onDataAvailable(response);
        }
    }
}
