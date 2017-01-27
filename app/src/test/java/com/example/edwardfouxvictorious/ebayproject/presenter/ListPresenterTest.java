package com.example.edwardfouxvictorious.ebayproject.presenter;


import com.example.edwardfouxvictorious.ebayproject.model.EarthquakeResponse;
import com.example.edwardfouxvictorious.ebayproject.view.ActivityView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import retrofit.Retrofit;

public class ListPresenterTest {

    private ListPresenter listPresenter;
    private ActivityView activityView;

    @Mock
    EarthquakeResponse earthquakeResponseBody;

    @Mock
    Retrofit retrofit;

    @Before
    public void setup() {
        listPresenter = new ListPresenter(activityView);

        activityView = Mockito.mock(ActivityView.class);
        listPresenter.view = activityView;
    }

    @Test
    public void onDataAvailableTest() {
        listPresenter.dataLoaderCallback.onSuccess(earthquakeResponseBody);

        Mockito.verify(activityView, Mockito.times(1)).onDataAvailable(earthquakeResponseBody);
    }
}
