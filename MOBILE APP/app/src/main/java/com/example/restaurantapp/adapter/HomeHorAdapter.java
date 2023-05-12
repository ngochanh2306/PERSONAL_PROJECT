package com.example.restaurantapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.R;
import com.example.restaurantapp.model.HomeHorModel;
import com.example.restaurantapp.model.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

   UpdateVerRec updateVerRec;
   Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check = true;
    boolean select = true;
    int row_index=-1;

    public HomeHorAdapter(UpdateVerRec updateVerRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerRec = updateVerRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizonal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if(check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Cheese Pizza", "5.0", "$10 - $50"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Hot Dogs Pizza", "5.0", "$7 - $20"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Mixed Pizza", "5.0", "$30 - $70"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Chicken Pizza", "5.0", "$10 - $25"));

            updateVerRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position;
                    notifyDataSetChanged();

                    if (position == 0){

                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Cheese Pizza", "5.0", "$10 - $50"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Hot Dogs Pizza", "5.0", "$7 - $20"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Mixed Pizza", "5.0", "$30 - $70"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Chicken Pizza", "5.0", "$10 - $25"));

                        updateVerRec.callBack(position, homeVerModels);
                    }
                    else if (position == 1){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Chicken Hamburger", "5.0", "$5 - $10"));
                        homeVerModels.add(new HomeVerModel(R.drawable.burger2, "Beef Hamburger", "5.0", "$15 - $30"));
                        homeVerModels.add(new HomeVerModel(R.drawable.burger4, "Mixed Hamburger", "5.0", "$20 - $50"));

                        updateVerRec.callBack(position, homeVerModels);
                    }

                    else if (position == 2){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.fries1, "Cheese Fries", "5.0", "$5- $10"));
                        homeVerModels.add(new HomeVerModel(R.drawable.fries2, "Original Fries", "5.0", "$2 - $5"));
                        homeVerModels.add(new HomeVerModel(R.drawable.fries3, "Seaweed Fries", "5.0", "$7 - $15"));

                        updateVerRec.callBack(position, homeVerModels);
                    }

                    else if (position == 3){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Chocolate", "5.0", "$5 - $10"));
                        homeVerModels.add(new HomeVerModel(R.drawable.icecream2, "Coconut", "5.0", "$5 - $10"));
                        homeVerModels.add(new HomeVerModel(R.drawable.icecream3, "Strawberry", "5.0", "$5 - $10"));

                        updateVerRec.callBack(position, homeVerModels);
                    }

                    else if (position == 4){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.sandwich1, "Avocado Sandwich", "5.0", "$10 - $20"));
                        homeVerModels.add(new HomeVerModel(R.drawable.sandwich2, "Mixed Sandwich", "5.0", "$10 - $20"));
                        homeVerModels.add(new HomeVerModel(R.drawable.sandwich3, "Blueberry Sandwich", "5.0", "$10 - $20"));

                        updateVerRec.callBack(position, homeVerModels);
                    }
                }
            });

            if (select){
                if(position==0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select=false;
                }
            }
            else {
                if (row_index == position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }
                else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);
            cardView=itemView.findViewById(R.id.cartView);
        }
    }
}
