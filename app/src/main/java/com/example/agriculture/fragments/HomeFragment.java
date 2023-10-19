package com.example.agriculture.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.agriculture.HomeActivity;
import com.example.agriculture.R;
import com.example.agriculture.RecyclerFragment;
import com.example.agriculture.weatherActivity;


public class HomeFragment extends Fragment {

ImageView crops,rains,worker;
HomeActivity mainActivity;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        crops = v.findViewById(R.id.crop1);
        rains = v.findViewById(R.id.rains);
        worker = v.findViewById(R.id.farmers1);
        mainActivity = (HomeActivity)getActivity();
        crops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new RecyclerFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container,fragment);
                transaction.commit();
            }
        });
        rains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent spl = new Intent(getActivity(), weatherActivity.class);
                startActivity(spl);
            }
        });
        worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new workers_Fragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container,fragment);
                transaction.commit();
            }
        });

        return v;
    }
}