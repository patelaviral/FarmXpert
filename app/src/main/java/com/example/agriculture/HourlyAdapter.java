package com.example.agriculture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.viewHolder> {
    ArrayList<Hourly> items;
    Context context;

    public HourlyAdapter(ArrayList<Hourly> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public HourlyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly,parent,false);
        context = parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.viewHolder holder, int position) {
        holder.hourTxt.setText(items.get(position).getHour());
        holder.tempText.setText(items.get(position).getTemp()+"°");

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicpath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context).load(drawableResourceId).into(holder.plc);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView hourTxt,tempText;
        ImageView plc;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            hourTxt = itemView.findViewById(R.id.houtxt);
            tempText = itemView.findViewById(R.id.temptTxt);
            plc = itemView.findViewById(R.id.pic);
        }
    }
}
