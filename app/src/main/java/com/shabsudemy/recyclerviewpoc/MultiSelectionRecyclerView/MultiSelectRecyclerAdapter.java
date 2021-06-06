package com.shabsudemy.recyclerviewpoc.MultiSelectionRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;


public class MultiSelectRecyclerAdapter extends RecyclerView.Adapter<MultiSelectRecyclerAdapter.MultiSelectViewHolder> {

    public ArrayList<MultiSelectEmployeeModel> selected = new ArrayList<MultiSelectEmployeeModel>();
    Context context;
    ArrayList<MultiSelectEmployeeModel> dataEmployeeList;

    public MultiSelectRecyclerAdapter(Context context, ArrayList<MultiSelectEmployeeModel> dataEmployeeList) {
        this.context = context;
        this.dataEmployeeList = dataEmployeeList;
    }

    public ArrayList<MultiSelectEmployeeModel> getSelected() {
        selected.clear();
        for (MultiSelectEmployeeModel employee : dataEmployeeList) {
            if (employee.isIsChecked()) {
                selected.add(employee);
            }
        }
        return selected;
    }


    public ArrayList<MultiSelectEmployeeModel> getAll() {
        return dataEmployeeList;
    }

    @NonNull
    @Override
    public MultiSelectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multi_select_item_row, parent, false);
        return new MultiSelectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiSelectRecyclerAdapter.MultiSelectViewHolder holder, int position) {
        holder.bindData(dataEmployeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataEmployeeList.size();
    }

    public class MultiSelectViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MultiSelectViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.multiselectRowNameTextview);
            imageView = itemView.findViewById(R.id.multiselectRowTickSampleIMage);
        }

        public void bindData(MultiSelectEmployeeModel multiSelectEmployeeModel) {
            textView.setText(multiSelectEmployeeModel.getName());
            imageView.setVisibility(multiSelectEmployeeModel.isIsChecked() ? View.VISIBLE : View.INVISIBLE);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    multiSelectEmployeeModel.setIsChecked(!multiSelectEmployeeModel.isIsChecked());
                    imageView.setVisibility(multiSelectEmployeeModel.isIsChecked() ? View.VISIBLE : View.INVISIBLE);
                }
            });

        }
    }
}
