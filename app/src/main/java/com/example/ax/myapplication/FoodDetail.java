package com.example.ax.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class FoodDetail extends AppCompatActivity {


    private Context mContext;
    private uploadOldFood mUploads;
    private ImageAdapter.OnItemClickListener mListener;
//    private uploadOldFood gglarThis;
      TextView Tvtest;
//    TextView test2;
    //private int gg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_image_item);
//        //testr(gg);
//        Intent i = getIntent();
//        int p = i.getIntExtra("getSelectedPosition", 0);
////        String p = i.getStringExtra("getSelectedPosition");
//
////        test = findViewById(R.id.tvImageZoomInName);
////
////
//        Tvtest.setText("p");

    }

//    public void testr(int position) {
//        Intent i = getIntent();
//        int p = i.getIntExtra("getSelectedPosition", position);
//
//        test = findViewById(R.id.tvImageZoomInName);
//
//        test.setText(p);
//
//        test2 = findViewById(R.id.tvImageZoomInDesc);
//        test.setText("GG");
//    }

}
