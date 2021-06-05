package com.shabsudemy.recyclerviewpoc.SingleItemSelectRecyclerView;

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

public class SingleItemRecycleAdapter extends RecyclerView.Adapter<SingleItemRecycleAdapter.SingleItemViewHolder> {

    Context context;
    private ArrayList<SingleItemModel> dataModelsList;
    private int checkedPosition = 0;

    public SingleItemRecycleAdapter(Context context, ArrayList<SingleItemModel> dataModelsList) {
        this.context = context;
        this.dataModelsList = dataModelsList;
    }

    public void setEmployees(ArrayList<SingleItemModel> data) {
        dataModelsList = new ArrayList<>();
        dataModelsList = data;
        notifyDataSetChanged();
    }

    @Override
    public SingleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_select_item_row, parent, false);
        return new SingleItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleItemRecycleAdapter.SingleItemViewHolder holder, int position) {
        holder.bindData(dataModelsList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataModelsList.size();
    }

    public SingleItemModel getSelected() {
        if (checkedPosition != -1) {
            return dataModelsList.get(checkedPosition);
        }
        return null;
    }

    public class SingleItemViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public SingleItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rowNameTextview);
            imageView = itemView.findViewById(R.id.tickSampleIMage);

        }

        public void bindData(SingleItemModel singleItemModel) {

            if (checkedPosition == -1) {
                imageView.setVisibility(View.VISIBLE);
            } else {
                if (checkedPosition == getAdapterPosition()) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.GONE);
                }
            }

            textView.setText(singleItemModel.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition=getAdapterPosition();
                    }
                }
            });


        }
    }
}
