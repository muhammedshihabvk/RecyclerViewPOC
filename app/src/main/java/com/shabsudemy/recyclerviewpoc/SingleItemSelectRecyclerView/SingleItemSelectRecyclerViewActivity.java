package com.shabsudemy.recyclerviewpoc.SingleItemSelectRecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class SingleItemSelectRecyclerViewActivity extends AppCompatActivity {

    Button showSelectedButton;
    RecyclerView singleSelectRecyclerView;
    ArrayList<SingleItemModel> dataModels = new ArrayList<SingleItemModel>();
    SingleItemRecycleAdapter singleItemRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_select_recycler_view);

        singleSelectRecyclerView = findViewById(R.id.singleSelectItemRecyclerview);
        showSelectedButton = findViewById(R.id.showSelectButton);

        createListData();



        singleSelectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        singleSelectRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        singleItemRecycleAdapter = new SingleItemRecycleAdapter(this,dataModels);
        singleSelectRecyclerView.setAdapter(singleItemRecycleAdapter);

        showSelectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(singleItemRecycleAdapter.getSelected()!=null){
                    Toast.makeText(SingleItemSelectRecyclerViewActivity.this, singleItemRecycleAdapter.getSelected().getName(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SingleItemSelectRecyclerViewActivity.this, "no selection", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void createListData() {
        for (int i = 0; i < 100; i++) {
            dataModels.add(new SingleItemModel("shihab" + String.valueOf(i), false, "3234" + String.valueOf(i)));
        }
    }
}