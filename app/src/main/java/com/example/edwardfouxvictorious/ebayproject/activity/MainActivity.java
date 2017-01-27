package com.example.edwardfouxvictorious.ebayproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.edwardfouxvictorious.ebayproject.model.EarthquakeResponse;
import com.example.edwardfouxvictorious.ebayproject.presenter.ListPresenter;
import com.example.edwardfouxvictorious.ebayproject.R;
import com.example.edwardfouxvictorious.ebayproject.view.ActivityView;
import com.example.edwardfouxvictorious.ebayproject.adapter.EarthquakeAdapter;

public class MainActivity extends AppCompatActivity implements ActivityView {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ListPresenter listPresenter = new ListPresenter(this);
        listPresenter.getData();
    }

    @Override
    public void onDataAvailable(EarthquakeResponse response) {
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(response.getEarthquakes());
        recyclerView.setAdapter(earthquakeAdapter);

        earthquakeAdapter.notifyDataSetChanged();
    }
}
