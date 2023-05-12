package com.example.restaurantapp.ui.dish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurantapp.R;
import com.example.restaurantapp.adapter.DishAdapter;
import com.example.restaurantapp.model.DishModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DishFragment extends Fragment {
/*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DishFragment() {
        // Required empty public constructor
    }

    public static DishFragment newInstance(String param1, String param2) {
        DishFragment fragment = new DishFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
    RecyclerView recyclerView;
    List<DishModel> dishModels;
    DishAdapter dishAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dish, container, false);

        recyclerView=root.findViewById(R.id.dish_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dishModels = new ArrayList<>();

        dishModels.add(new DishModel(R.drawable.breakfast,"Breakfash","Breakfast full of energy","breakfast"));
        dishModels.add(new DishModel(R.drawable.lunch,"Lunch","Light lunch","lunch"));
        dishModels.add(new DishModel(R.drawable.dinner,"Dinner","A romantic dinner","dinner"));
        dishModels.add(new DishModel(R.drawable.sweets,"Sweets","Paradise of sweetness","sweets"));
        dishModels.add(new DishModel(R.drawable.coffe,"Coffee","Enjoy a delicious cup of coffee","coffee"));

        dishAdapter = new DishAdapter(dishModels,getContext());

        recyclerView.setAdapter(dishAdapter);
        dishAdapter.notifyDataSetChanged();
        return root;
    }


}