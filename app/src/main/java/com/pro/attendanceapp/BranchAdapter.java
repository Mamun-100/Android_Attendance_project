package com.pro.attendanceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.BranchViewHolder> {
    ArrayList<BranchItem> branchItems;
    Context context;

    public BranchAdapter(Context context, ArrayList<BranchItem> branchItems) {
        this.branchItems = branchItems;
        this.context = context;
    }

    public static class BranchViewHolder extends RecyclerView.ViewHolder{
        TextView branchName;
        TextView departmentName;

        public BranchViewHolder(@NonNull View itemView) {

            super(itemView);
            branchName = itemView.findViewById(R.id.branch_tv);
            departmentName = itemView.findViewById(R.id.department_tv);

        }
    }

    @NonNull
    @Override
    public BranchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.branch_item,parent,false);

        return new BranchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchViewHolder holder, int position) {
        holder.branchName.setText(branchItems.get(position).getBranchName());
        holder.departmentName.setText(branchItems.get(position).getDepartmentName());

    }

    @Override
    public int getItemCount() {

        return branchItems.size();
    }


}

