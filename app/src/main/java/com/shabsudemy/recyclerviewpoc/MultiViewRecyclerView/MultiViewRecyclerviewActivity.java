package com.shabsudemy.recyclerviewpoc.MultiViewRecyclerView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class MultiViewRecyclerviewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MultiViewAdapter multiViewAdapter;
    ArrayList<MultiViewModel> dataModelList = new ArrayList<MultiViewModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_view_recyclerview);

        recyclerView = findViewById(R.id.multiViewRecyclerview);

        generateData();

        multiViewAdapter = new MultiViewAdapter(this, dataModelList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(multiViewAdapter);
    }

    public void generateData() {
        MultiViewModel multiViewModel = new MultiViewModel();
        multiViewModel.setName("shihab1");
        multiViewModel.setAddress("ABC school");
        multiViewModel.setPhone("+1-68362982" + String.valueOf(1));
        dataModelList.add(multiViewModel);

        MultiViewModel multiViewModel1 = new MultiViewModel();
        multiViewModel1.setName("shihab2");
        multiViewModel1.setPhone("+1-68362982" + String.valueOf(2));
        multiViewModel1.setEmail("email@google.com" + String.valueOf(2));
        dataModelList.add(multiViewModel1);

        MultiViewModel multiViewModel3 = new MultiViewModel();
        multiViewModel3.setName("shihab3");
        multiViewModel3.setAddress("ABC school");
        multiViewModel3.setPhone("+1-68362982" + String.valueOf(1));
        dataModelList.add(multiViewModel3);

        MultiViewModel multiViewModel4 = new MultiViewModel();
        multiViewModel4.setName("shihab4");
        multiViewModel4.setPhone("+1-68362982" + String.valueOf(2));
        multiViewModel4.setEmail("email@google.com" + String.valueOf(2));
        dataModelList.add(multiViewModel4);

        MultiViewModel multiViewModel6 = new MultiViewModel();
        multiViewModel6.setName("shihab5");
        multiViewModel6.setPhone("+1-68362982" + String.valueOf(2));
        multiViewModel6.setEmail("email@google.com" + String.valueOf(2));
        dataModelList.add(multiViewModel6);

        MultiViewModel multiViewModel5 = new MultiViewModel();
        multiViewModel5.setName("shihab3");
        multiViewModel5.setAddress("ABC school");
        multiViewModel5.setPhone("+1-68362982" + String.valueOf(1));
        dataModelList.add(multiViewModel5);

        MultiViewModel multiViewModel7 = new MultiViewModel();
        multiViewModel7.setName("shihab3");
        multiViewModel7.setAddress("ABC school");
        multiViewModel7.setPhone("+1-68362982" + String.valueOf(1));
        dataModelList.add(multiViewModel7);
    }
}