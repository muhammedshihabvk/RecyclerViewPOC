package com.shabsudemy.recyclerviewpoc.CardViewRecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.NormalRecyclerView.NormalRecyclerViewDataModel;
import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder> {

    private Context context;
    private ArrayList<NormalRecyclerViewDataModel> dataModelsList;

    public CardRecyclerAdapter(Context context, ArrayList<NormalRecyclerViewDataModel> dataModelsList) {
        Log.i("shihab","CardRecyclerAdapter constructor");
        this.context = context;
        this.dataModelsList = dataModelsList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("shihab","onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_recyclerview_row,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardRecyclerAdapter.CardViewHolder holder, int position) {
        NormalRecyclerViewDataModel normalRecyclerViewDataModel = dataModelsList.get(position);
        holder.setDetails(normalRecyclerViewDataModel);
        Log.i("shihab","onBindViewHolder"+String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return dataModelsList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView name, value1, value2, value22;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cardnameTextview);
            value1 = itemView.findViewById(R.id.cardvalue1Textview);
            value2 = itemView.findViewById(R.id.cardvalue2Textview);
            value22 = itemView.findViewById(R.id.cardvalue2Textview2);
        }

        void setDetails(NormalRecyclerViewDataModel normalRecyclerViewDataModel) {
            name.setText(normalRecyclerViewDataModel.getName());
            value1.setText("Serial No:0986"+String.valueOf(normalRecyclerViewDataModel.getValue1()));
            value2.setText("Seat Number:536"+String.valueOf(normalRecyclerViewDataModel.getValue2()));
            value22.setText(String.valueOf(normalRecyclerViewDataModel.getValue2()));
        }
    }
}

