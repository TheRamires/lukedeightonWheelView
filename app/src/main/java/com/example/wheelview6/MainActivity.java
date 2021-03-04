package com.example.wheelview6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private WheelView wheelView;
    private ArrayList<Drawable> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is the items I want to add
        list = new ArrayList<>();
        list.add(getResources().getDrawable(R.drawable.ic_add_a_photo_black_36dp));
        list.add(getResources().getDrawable(R.drawable.ic_adjust_black_48dp));
        list.add(getResources().getDrawable(R.drawable.ic_audiotrack_black_48dp));
        list.add(getResources().getDrawable(R.drawable.ic_blur_circular_black_36dp));

        ////

        wheelView = (WheelView) findViewById(R.id.wheelView);

        wheelView.setAdapter(new WheelAdapter() {

            @Override
            public Drawable getDrawable(int position) {
                Log.d("myLog",""+list.get(position));
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });
        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView parent, Drawable itemDrawable, int position) {
                Log.d("myLog",""+list.get(position)+ " "+position);

            }
        });
        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                Log.d("myLog",""+list.get(position)+ " "+position);

            }
        });
    }
}