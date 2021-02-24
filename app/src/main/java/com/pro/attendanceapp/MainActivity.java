package com.pro.attendanceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
FloatingActionButton fab;
RecyclerView recyclerView;
BranchAdapter branchAdapter;
RecyclerView.LayoutManager layoutManager;
ArrayList<BranchItem> branchItems = new ArrayList<>();

EditText branch_edt;
EditText department_edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab_main);
        fab.setOnClickListener(v->showDialog());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        branchAdapter = new BranchAdapter(this,branchItems);
        recyclerView.setAdapter(branchAdapter);

    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().from(this).inflate(R.layout.branch_dialog,null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        branch_edt = view.findViewById(R.id.branch_edt);
        department_edt = view.findViewById(R.id.department_edt);

        Button cancel = view.findViewById(R.id.cancel_btn);
        Button add = view.findViewById(R.id.add_btn);

        cancel.setOnClickListener(v -> dialog.dismiss());
        add.setOnClickListener(v -> {
            addBranch();
            dialog.dismiss();
        });
    }



    private void addBranch() {
        String branchName = branch_edt.getText().toString();
        String departmentName = department_edt.getText().toString();
        branchItems.add(new BranchItem(branchName,departmentName));
        branchAdapter.notifyDataSetChanged();
    }
}