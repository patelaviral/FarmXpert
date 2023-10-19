package com.example.agriculture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriculture.fragments.Arrconstructor_1;

import java.util.ArrayList;

public class workers_adapter extends RecyclerView.Adapter<workers_adapter.viewholder> {
    Context context;
    ArrayList<Arrconstructor_1> arrlists;
    public workers_adapter(Context context, ArrayList<Arrconstructor_1> arrlists){
        this.context = context;
        this.arrlists = arrlists;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.worker_list,parent,false);
        viewholder viewholder1 = new viewholder(v);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        holder.image11.setImageResource(arrlists.get(position).img1);
        holder.workername.setText(arrlists.get(position).name);
        holder.phone.setText(arrlists.get(position).phone);
        holder.amount.setText(arrlists.get(position).amount);
    }

    @Override
    public int getItemCount() {
        return arrlists.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView workername,amount,phone;
        ImageView image11;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            workername = itemView.findViewById(R.id.worker_name);
            amount = itemView.findViewById(R.id.worker_amount);
            phone = itemView.findViewById(R.id.worker_phone_no);
            image11 = itemView.findViewById(R.id.worker_images);
        }
    }
}
