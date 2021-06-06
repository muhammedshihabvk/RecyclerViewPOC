package com.shabsudemy.recyclerviewpoc.MultiSelectionRecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class MultiSelectionRecyclerView extends AppCompatActivity {

    RecyclerView multiSelectRecyclerview;
    Button showSelectionButton;
    MultiSelectRecyclerAdapter multiSelectRecyclerAdapter;

    ArrayList<MultiSelectEmployeeModel> dataModelList = new ArrayList<MultiSelectEmployeeModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_selection_recycler_view);

        multiSelectRecyclerview = findViewById(R.id.multiSelectRecyclerView);
        showSelectionButton = findViewById(R.id.showSelectionButton);

        generateData();

        multiSelectRecyclerAdapter = new MultiSelectRecyclerAdapter(this, dataModelList);

        multiSelectRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        multiSelectRecyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        multiSelectRecyclerview.setAdapter(multiSelectRecyclerAdapter);

        showSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MultiSelectionRecyclerView.this, String.valueOf(multiSelectRecyclerAdapter.getSelected().size()), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void generateData() {
        for (int i = 0; i < 100; i++) {
            dataModelList.add(new MultiSelectEmployeeModel("shihab", 9999 + i, 1000 + i, false));
        }
    }
}