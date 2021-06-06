package com.shabsudemy.recyclerviewpoc.MultiViewRecyclerView;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shabsudemy.recyclerviewpoc.R;

import java.util.ArrayList;

public class MultiViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int TYPE_CALL = 1;
    private static int TYPE_EMAIl = 2;

    Context context;
    ArrayList<MultiViewModel> dataModelList;

    public MultiViewAdapter(Context context, ArrayList<MultiViewModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
        Log.i("shihab", "MultiViewAdapter");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Log.i("shihab", "onCreateViewHolder");
        if (viewType == TYPE_CALL) {
            view = LayoutInflater.from(context).inflate(R.layout.multi_view_item_call, parent, false);
            return new CallViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.multi_view_item_email, parent, false);
            return new EmailViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i("shihab", "onBindViewHolder");
        if (getItemViewType(position) == TYPE_CALL) {
            ((CallViewHolder) holder).bindCallDetails(dataModelList.get(position));
        } else {
            ((EmailViewHolder) holder).bindEmailDetails(dataModelList.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(dataModelList.get(position).getEmail())) {
            return TYPE_CALL;
        } else {
            return TYPE_EMAIl;
        }
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    class CallViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView address;

        public CallViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.callNameTextView);
            address = itemView.findViewById(R.id.callAddressTextView);
        }

        public void bindCallDetails(MultiViewModel multiSelectEmployeeModel) {
            name.setText(multiSelectEmployeeModel.getName());
            address.setText(multiSelectEmployeeModel.getAddress());
        }
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView address;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.emailNameTextview);
            address = itemView.findViewById(R.id.emailAddressTextview);
        }

        public void bindEmailDetails(MultiViewModel multiSelectEmployeeModel) {
            name.setText(multiSelectEmployeeModel.getName());
            address.setText(multiSelectEmployeeModel.getAddress());
        }
    }
}
