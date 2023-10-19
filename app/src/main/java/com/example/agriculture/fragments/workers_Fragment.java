package com.example.agriculture.fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agriculture.Arrconstructor;
import com.example.agriculture.R;
import com.example.agriculture.workers_adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class workers_Fragment extends Fragment {
    ArrayList<Arrconstructor_1> arrshows1 = new ArrayList<>();
    FloatingActionButton floatbtn;
    workers_adapter adapter;
    

    public workers_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V =  inflater.inflate(R.layout.fragment_workers_, container, false);


        RecyclerView recyclerView = V.findViewById(R.id.recycler02);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        floatbtn = V.findViewById(R.id.float_btn1);
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.worker_add);

                EditText edt1 = dialog.findViewById(R.id.nm1);
                EditText edt2 = dialog.findViewById(R.id.amt1);
                EditText edt3 = dialog.findViewById(R.id.phn1);
                Button btn1 = dialog.findViewById(R.id.apply1);
                
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String Name = "", amount = "", number = "";
                        if (!edt1.getText().toString().equals("")) {
                            Name = edt1.getText().toString();
                        } 
                        else{
                            Toast.makeText(getActivity(), "Please Enter Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edt2.getText().toString().equals("")){
                            amount = edt2.getText().toString();
                        }
                        else{
                            Toast.makeText(getActivity(), "Please Enter Amount", Toast.LENGTH_SHORT).show();
                        }
                        if(!edt3.getText().toString().equals("")){
                            number = edt3.getText().toString();
                        }
                        else{
                            Toast.makeText(getActivity(), "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
                        }
                        arrshows1.add(new Arrconstructor_1(R.drawable.av12,Name,amount,number));
                        adapter.notifyItemChanged(arrshows1.size()-1);
                        recyclerView.scrollToPosition(arrshows1.size()-1);

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        
        arrshows1.add(new Arrconstructor_1(R.drawable.av1,"sameer","200","9454654642"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av2,"jonty","500","9454654642"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av3,"Ayush","Free","953546542"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av4,"Sahil","500","9452554642"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av5,"Divyanshu","23","9454524642"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av6,"riya","52","9454654142"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av7,"mahesh","512","9454654212"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av8,"abhishek","235","9654651442"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av9,"shashank","512","9454142642"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av10,"tanay","457","9454610642"));
        arrshows1.add(new Arrconstructor_1(R.drawable.av11,"arpit","85","9454654412"));
        adapter = new workers_adapter(getContext(),arrshows1);
        recyclerView.setAdapter(adapter);
        return V;
    }
}