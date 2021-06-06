package com.shabsudemy.recyclerviewpoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.shabsudemy.recyclerviewpoc.CardViewRecyclerView.CardViewRecyclerViewActivity;
import com.shabsudemy.recyclerviewpoc.MultiSelectionRecyclerView.MultiSelectionRecyclerView;
import com.shabsudemy.recyclerviewpoc.MultiViewRecyclerView.MultiViewRecyclerviewActivity;
import com.shabsudemy.recyclerviewpoc.NormalRecyclerView.RecyclerView1Activity;
import com.shabsudemy.recyclerviewpoc.SingleItemSelectRecyclerView.SingleItemSelectRecyclerViewActivity;
import com.shabsudemy.recyclerviewpoc.SwipeItemRecyclerView.SwipeItemRecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button rB1;
    Button rB2;
    Button rB3;
    Button rB4;
    Button rB5;
    Button rB6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rB1 = (Button) findViewById(R.id.recyclerviewButton1);
        rB2 = (Button) findViewById(R.id.recyclerviewButton2);
        rB3 = (Button) findViewById(R.id.recyclerviewButton3);
        rB4 = (Button) findViewById(R.id.recyclerviewButton4);
        rB5 = (Button) findViewById(R.id.recyclerviewButton5);
        rB6 = (Button) findViewById(R.id.recyclerviewButton6) ;

        rB1.setOnClickListener(this);
        rB2.setOnClickListener(this);
        rB3.setOnClickListener(this);
        rB4.setOnClickListener(this);
        rB5.setOnClickListener(this);
        rB6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.recyclerviewButton1:
                i = new Intent(this, RecyclerView1Activity.class);
                startActivity(i);
                break;
            case R.id.recyclerviewButton2:
                i = new Intent(this, CardViewRecyclerViewActivity.class);
                startActivity(i);
                break;
            case R.id.recyclerviewButton3:
                i = new Intent(this, SingleItemSelectRecyclerViewActivity.class);
                startActivity(i);
                break;
            case R.id.recyclerviewButton4:
                i = new Intent(this, MultiSelectionRecyclerView.class);
                startActivity(i);
                break;
            case R.id.recyclerviewButton5:
                i = new Intent(this, SwipeItemRecyclerViewActivity.class);
                startActivity(i);
                break;
            case R.id.recyclerviewButton6:
                i= new Intent(this, MultiViewRecyclerviewActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}