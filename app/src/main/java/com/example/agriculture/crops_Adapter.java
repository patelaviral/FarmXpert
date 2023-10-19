package com.example.agriculture;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class crops_Adapter extends RecyclerView.Adapter<crops_Adapter.Viewholder> {
    private int lastpost = -1;
    Context context;
    ArrayList<Arrconstructor> arrayList1;
    crops_Adapter(Context context1, ArrayList<Arrconstructor> arrayList1){
        this.context = context1;
        this.arrayList1 = arrayList1;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.crops_list,parent,false);
        Viewholder viewholder = new Viewholder(v);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.cropsimage.setImageResource(arrayList1.get(position).image);
        holder.cropname.setText(arrayList1.get(position).name);
        setAnimation(holder.itemView,position);
        holder.infor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.info_crops);

                ImageView imageView = dialog.findViewById(R.id.crops_image1);
                TextView textView = dialog.findViewById(R.id.crops_name1);
                TextView info_text = dialog.findViewById(R.id.info_text);
                textView.setText(arrayList1.get(position).name);
                imageView.setImageResource(arrayList1.get(position).image);
                if(0 == position){
                    info_text.setText(R.string.wheat_info);
                }
                else if(1 == position){
                    info_text.setText(R.string.barley_info);
                }
                else if(2 == position){
                    info_text.setText(R.string.musturd_info);
                }
                else if(3 == position){
                    info_text.setText(R.string.paddy_info);
                }
                else if(4 == position){
                    info_text.setText(R.string.legume_info);
                }
                else if(5 == position){
                    info_text.setText(R.string.maize_info);
                }
                else if(6 == position){
                    info_text.setText(R.string.gram_seeds_info);
                }
                else if (29 == position){
                    info_text.setText(R.string.cotton_info);
                }
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView cropsimage;
        TextView cropname;
        LinearLayout infor;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cropsimage = itemView.findViewById(R.id.crops_images);
            cropname = itemView.findViewById(R.id.crops_name);
            infor = itemView.findViewById(R.id.crops_lists);
        }
    }
    private void setAnimation(View viewto,int position){
        if(lastpost<position){
            Animation slide = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewto.startAnimation(slide);
            lastpost = position;
        }
    }
}
