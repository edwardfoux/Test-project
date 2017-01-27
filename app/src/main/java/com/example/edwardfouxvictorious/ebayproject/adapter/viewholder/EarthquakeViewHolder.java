package com.example.edwardfouxvictorious.ebayproject.adapter.viewholder;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.edwardfouxvictorious.ebayproject.model.Earthquake;
import com.example.edwardfouxvictorious.ebayproject.R;


public class EarthquakeViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private TextView magnitude;
    private TextView depth;
    private Earthquake earthquake;
    private View view;

    public EarthquakeViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        textView = (TextView) itemView.findViewById(R.id.date);
        depth = (TextView) itemView.findViewById(R.id.depth);
        magnitude = (TextView) itemView.findViewById(R.id.magnitude);
    }

    public void setup(Earthquake earthquake) {
        this.earthquake = earthquake;
        textView.setText(earthquake.getDatetime());
        depth.setText(String.valueOf(earthquake.getDepth()));
        magnitude.setText(String.valueOf(earthquake.getMagnitude()));
    }

    public void selectEQ() {
        magnitude.setTextColor(Color.RED);
    }

    public void unSelectEQ() {
        magnitude.setTextColor(Color.BLACK);
    }
}
