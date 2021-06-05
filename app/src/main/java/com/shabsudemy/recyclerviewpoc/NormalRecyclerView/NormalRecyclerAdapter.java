package com.shabsudemy.recyclerviewpoc.NormalRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class NormalRecyclerAdapter extends RecyclerView.Adapter<NormalRecyclerAdapter.NormalViewHolder> {

    private Context context;
    private ArrayList<NormalRecyclerViewDataModel> dataModelsList;

    public NormalRecyclerAdapter(Context context, ArrayList<NormalRecyclerViewDataModel> dataModelsList) {
        this.context = context;
        this.dataModelsList = dataModelsList;
    }

    @NonNull
    @Override
    public NormalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.normal_recyclerview_row,parent,false);
        return new NormalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  NormalRecyclerAdapter.NormalViewHolder holder, int position) {
        NormalRecyclerViewDataModel normalRecyclerViewDataModel = dataModelsList.get(position);
        holder.setDetails(normalRecyclerViewDataModel);

//        one way of doing it
//        holder.name.setText(normalRecyclerViewDataModel.getName());
//        holder.value1.setText(String.valueOf(normalRecyclerViewDataModel.getValue1()));
//        holder.value2.setText(String.valueOf(normalRecyclerViewDataModel.getValue2()));
    }

    @Override
    public int getItemCount() {
        return dataModelsList.size();
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder {

        private  TextView name,value1,value2;

        public NormalViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.nameTextview);
            value1=itemView.findViewById(R.id.value1Textview);
            value2=itemView.findViewById(R.id.value2Textview);
        }

        void setDetails(NormalRecyclerViewDataModel normalRecyclerViewDataModel){
            name.setText(normalRecyclerViewDataModel.getName());
            value1.setText(String.valueOf(normalRecyclerViewDataModel.getValue1()));
            value2.setText(String.valueOf(normalRecyclerViewDataModel.getValue2()));
        }
    }
}
