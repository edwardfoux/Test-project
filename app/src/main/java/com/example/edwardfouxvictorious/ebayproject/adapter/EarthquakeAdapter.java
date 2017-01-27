package com.example.edwardfouxvictorious.ebayproject.adapter;

import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edwardfouxvictorious.ebayproject.model.Earthquake;
import com.example.edwardfouxvictorious.ebayproject.R;
import com.example.edwardfouxvictorious.ebayproject.adapter.viewholder.EarthquakeViewHolder;

import java.util.List;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeViewHolder> {

    private List<Earthquake> list;
    private static final double MIN_MAGNITUDE = 8.0;

    public EarthquakeAdapter(List<Earthquake> list) {
        this.list = list;
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.earhquake_item, null);
        return new EarthquakeViewHolder(view);
    }

    @Override
    @VisibleForTesting
    public void onBindViewHolder(EarthquakeViewHolder holder, int position) {
        Earthquake earthquake = list.get(position);
        holder.setup(earthquake);
        if (Double.compare(earthquake.getMagnitude(), MIN_MAGNITUDE) > 0) {
            holder.selectEQ();
        } else {
            holder.unSelectEQ();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
