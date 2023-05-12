package com.example.restaurantapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.DetailDishAdapter;
import com.example.restaurantapp.model.DetailDishModel;

import java.util.ArrayList;
import java.util.List;

public class DetailDishActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailDishModel> detailDishModelsList;
    DetailDishAdapter dishAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dish);

        String type = getIntent().getStringExtra("type");

        recyclerView=findViewById(R.id.detail_rec);
        imageView=findViewById(R.id.detail_img);

        recyclerView = findViewById(R.id.detail_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailDishModelsList=new ArrayList<>();
        dishAdapter=new DetailDishAdapter(detailDishModelsList);
        recyclerView.setAdapter(dishAdapter);

        if(type != null && type.equalsIgnoreCase("breakfast")){
            detailDishModelsList.add(new DetailDishModel(R.drawable.fav1,"Breakfast", "description","5.0","50"));
            detailDishModelsList.add(new DetailDishModel(R.drawable.fav2,"Breakfast", "description","5.0","50"));
            detailDishModelsList.add(new DetailDishModel(R.drawable.fav3,"Breakfast", "description","5.0","50"));

            dishAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("sweets")){
            imageView.setImageResource(R.drawable.sweets);
            detailDishModelsList.add(new DetailDishModel(R.drawable.s1,"Breakfast", "description","5.0","50"));
            detailDishModelsList.add(new DetailDishModel(R.drawable.s2,"Breakfast", "description","5.0","50"));
            detailDishModelsList.add(new DetailDishModel(R.drawable.s3,"Breakfast", "description","5.0","50"));

            dishAdapter.notifyDataSetChanged();
        }
    }
}