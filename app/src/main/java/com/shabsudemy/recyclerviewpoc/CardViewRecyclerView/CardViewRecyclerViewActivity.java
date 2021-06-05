package com.shabsudemy.recyclerviewpoc.CardViewRecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shabsudemy.recyclerviewpoc.NormalRecyclerView.NormalRecyclerAdapter;
import com.shabsudemy.recyclerviewpoc.NormalRecyclerView.NormalRecyclerViewDataModel;
import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class CardViewRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView cardRecyclerView;
    private CardRecyclerAdapter cardRecyclerAdapter;
    private ArrayList<NormalRecyclerViewDataModel> dataModelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_recycler_view);

        cardRecyclerView = findViewById(R.id.cardRecyclerView);
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        cardRecyclerView.setVisibility(View.INVISIBLE);

        dataModelsList = new ArrayList<NormalRecyclerViewDataModel>();
        createListData();

        cardRecyclerAdapter = new CardRecyclerAdapter(this,dataModelsList);
        cardRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        cardRecyclerView.setAdapter(cardRecyclerAdapter);

        Log.i("shihab",String.valueOf(dataModelsList.size()));

    }

    private void createListData() {
        for (int i = 0; i < 100; i++) {
            dataModelsList.add(new NormalRecyclerViewDataModel("name" + String.valueOf(i), i + 10, i + 20));
        }
    }
}