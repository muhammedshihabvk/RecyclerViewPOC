package com.shabsudemy.recyclerviewpoc.SwipeItemRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.SwipeViewHolder> {

    Context context;
    ArrayList<EmployeeModel> dataModelList;
    ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public SwipeAdapter(Context context, ArrayList<EmployeeModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public SwipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.swipe_item_row_layout, parent, false);
        return new SwipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SwipeAdapter.SwipeViewHolder holder, int position) {
        viewBinderHelper.setOpenOnlyOne(true);
        viewBinderHelper.bind(holder.swipeRevealLayout, dataModelList.get(position).name);
        viewBinderHelper.closeLayout(dataModelList.get(position).name);
        holder.bindData(dataModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class SwipeViewHolder extends RecyclerView.ViewHolder {

        TextView textView, editTextview, deleteTextview;
        SwipeRevealLayout swipeRevealLayout;


        public SwipeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.swipeRowText);
            editTextview = itemView.findViewById(R.id.swipeEditText);
            deleteTextview = itemView.findViewById(R.id.swipeDeleteText);
            swipeRevealLayout = itemView.findViewById(R.id.swipeLayout);

            editTextview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Edit icon clicked", Toast.LENGTH_SHORT).show();
                }
            });

            deleteTextview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "delete icon clicked" + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                    dataModelList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition()); //for for update row removed
//                    notifyItemChanged(getAdapterPosition());//for update row
//                    notifyDataSetChanged(); //to notify entire adapter data
                }
            });
        }

        public void bindData(EmployeeModel employeeModel) {
            textView.setText(employeeModel.getName());
        }
    }

    interface Communincator{
        void edit(int position);
        void delete(int postion);
    }
}
