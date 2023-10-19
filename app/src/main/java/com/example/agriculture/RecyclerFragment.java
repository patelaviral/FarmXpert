package com.example.agriculture;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agriculture.Arrconstructor;
import com.example.agriculture.R;
import com.example.agriculture.crops_Adapter;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {
    ArrayList<Arrconstructor>arrshows = new ArrayList<>();


    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recycler01);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrshows.add(new Arrconstructor(R.drawable.wheat,"Wheat"));
        arrshows.add(new Arrconstructor(R.drawable.barley,"Barley"));
        arrshows.add(new Arrconstructor(R.drawable.mustard,"Mustard"));
        arrshows.add(new Arrconstructor(R.drawable.paddy_rice,"Paddy Rice"));
        arrshows.add(new Arrconstructor(R.drawable.legume,"Legume"));
        arrshows.add(new Arrconstructor(R.drawable.maize,"Maize"));
        arrshows.add(new Arrconstructor(R.drawable.gram,"Gram Seeds"));
        arrshows.add(new Arrconstructor(R.drawable.potato,"Potato"));
        arrshows.add(new Arrconstructor(R.drawable.raddish,"Radish"));
        arrshows.add(new Arrconstructor(R.drawable.coriander,"Coriander"));
        arrshows.add(new Arrconstructor(R.drawable.turmeric,"Turmeric"));
        arrshows.add(new Arrconstructor(R.drawable.onion,"Onion"));
        arrshows.add(new Arrconstructor(R.drawable.bitter_gourd,"Bitter Gourd"));
        arrshows.add(new Arrconstructor(R.drawable.chilli,"Chilli"));
        arrshows.add(new Arrconstructor(R.drawable.lemon,"Lemon"));
        arrshows.add(new Arrconstructor(R.drawable.tomato,"Tomato"));
        arrshows.add(new Arrconstructor(R.drawable.ginger,"Ginger"));
        arrshows.add(new Arrconstructor(R.drawable.capsicum,"Capsicum"));
        arrshows.add(new Arrconstructor(R.drawable.sunflower,"Sunflower"));
        arrshows.add(new Arrconstructor(R.drawable.garlic,"Garlic"));
        arrshows.add(new Arrconstructor(R.drawable.mango,"Mango"));
        arrshows.add(new Arrconstructor(R.drawable.guava,"Guava"));
        arrshows.add(new Arrconstructor(R.drawable.water_melon,"Water Melon"));
        arrshows.add(new Arrconstructor(R.drawable.brinjal,"Brinjal"));
        arrshows.add(new Arrconstructor(R.drawable.cabbage,"Cabbage"));
        arrshows.add(new Arrconstructor(R.drawable.ladyfinger,"Ladyfinger"));
        arrshows.add(new Arrconstructor(R.drawable.cauliflower,"Cauliflower"));
        arrshows.add(new Arrconstructor(R.drawable.banana,"Banana"));
        arrshows.add(new Arrconstructor(R.drawable.pomegranate,"Pomegranate"));
        arrshows.add(new Arrconstructor(R.drawable.cotton,"Cotton"));

        crops_Adapter adapter = new crops_Adapter(getContext(),arrshows);
        recyclerView.setAdapter(adapter);


        return v;
    }

}