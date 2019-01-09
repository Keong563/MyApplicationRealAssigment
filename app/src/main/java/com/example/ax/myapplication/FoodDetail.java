package com.example.ax.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FoodDetail extends AppCompatActivity {

    //private position
    //String selectedPosition = getIntent().getIntExtra("getSelectedPosition");
    String gg = getIntent().getStringExtra("getSelectedPosition");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        TextView desc;

        desc = findViewById(R.id.tvImageZoomInDesc);

        desc.setText(gg);
    }
}
