package com.shabsudemy.recyclerviewpoc.NormalRecyclerView;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class RecyclerView1Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    NormalRecyclerAdapter normalRecyclerAdapter;
    ArrayList<NormalRecyclerViewDataModel> dataModelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view1);

        recyclerView = findViewById(R.id.recyclerView1);

        dataModelsList = new ArrayList<NormalRecyclerViewDataModel>();
        createListData();
        Log.i("shihab",String.valueOf(dataModelsList.size()));

        normalRecyclerAdapter = new NormalRecyclerAdapter(this, dataModelsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(normalRecyclerAdapter);
    }

    private void createListData() {
        for (int i = 0; i < 100; i++) {
            dataModelsList.add(new NormalRecyclerViewDataModel("name" + String.valueOf(i), i + 10, i + 20));
        }
    }
}