package com.shabsudemy.recyclerviewpoc.SwipeItemRecyclerView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

//Add these lines to gradle.properties:
//        android.useAndroidX=true
//        android.enableJetifier=true
public class SwipeItemRecyclerViewActivity extends AppCompatActivity {

    RecyclerView swipeRecyclerView;
    SwipeAdapter swipeAdapter;
    ArrayList<EmployeeModel> dataModelList = new ArrayList<EmployeeModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_item_recycler_view);

        swipeRecyclerView = findViewById(R.id.swipeRecyclerView);

        generateData();

        swipeAdapter = new SwipeAdapter(this, dataModelList);

        swipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        swipeRecyclerView.setAdapter(swipeAdapter);
    }

    private void generateData() {
        for (int i = 0; i < 10; i++) {
            dataModelList.add(new EmployeeModel("shabs" + String.valueOf(i), 1000 + i));
        }
    }
}