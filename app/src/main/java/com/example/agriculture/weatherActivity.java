package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class weatherActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHorly;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",29,"sunny"));
        items.add(new Hourly("12 am",30,"wind"));
        items.add(new Hourly("1 am",29,"rainy"));
        items.add(new Hourly("2 am",27,"storm"));

        recyclerView = findViewById(R.id.recycler_weather);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapterHorly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHorly);
    }
}