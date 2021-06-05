package com.shabsudemy.recyclerviewpoc.CardViewRecyclerView;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.NormalRecyclerView.NormalRecyclerViewDataModel;
import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;
import java.util.Random;

public class CardViewRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView cardRecyclerView;
    private CardRecyclerAdapter cardRecyclerAdapter;
    private ArrayList<NormalRecyclerViewDataModel> dataModelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_recycler_view);

        cardRecyclerView = findViewById(R.id.cardRecyclerView);

        dataModelsList = new ArrayList<NormalRecyclerViewDataModel>();
        createListData();

        cardRecyclerAdapter = new CardRecyclerAdapter(this, dataModelsList);

        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        cardRecyclerView.setAdapter(cardRecyclerAdapter);
    }

    private void createListData() {

        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("shihab");
        nameList.add("anas");
        nameList.add("shuaib");
        nameList.add("shemeera");
        nameList.add("jahseer");
        nameList.add("kadhaer");
        Random random = new Random();

        for (int i = 0; i < 100; i++) {

            dataModelsList.add(new NormalRecyclerViewDataModel(nameList.get(random.nextInt(nameList.size() - 1)), i + 10, i + 20));
        }
    }
}