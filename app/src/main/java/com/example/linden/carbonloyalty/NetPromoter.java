package com.example.linden.carbonloyalty;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NetPromoter extends AppCompatActivity {

    private float detractor_percent;
    //private String detractor_percent_s = String.format("%.2f", detractor_percent);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Methods to pull net promoter data from SQL
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_promoter);

        double detractor_weight = .10;
        double passive_weight = .15;
        double promoter_weight = .75;

        int red = (int)(256*detractor_weight);
        int green = (int)(256*promoter_weight);
        int blue = (int)(256*passive_weight);

        TextView statusElement = (TextView) findViewById(R.id.statusView);
        statusElement.setBackgroundColor(Color.rgb(red, green, blue));
    }
}
