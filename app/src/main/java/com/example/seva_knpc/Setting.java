package com.example.seva_knpc;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seva_knpc.appUpdate.updateAdapter;
import com.example.seva_knpc.appUpdate.updateData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Setting extends AppCompatActivity {

    private RecyclerView ebookRecyler;
    private DatabaseReference reference;
    private List<updateData> list;
    private updateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.setting);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //noinspection deprecation
        getWindow().setStatusBarColor(getResources().getColor(R.color.purple_500));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Setting");

        ebookRecyler =findViewById(R.id.recyclerView);
        reference = FirebaseDatabase.getInstance().getReference().child("Update");

        getData();

    }
    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshort : datasnapshot.getChildren()){
                    updateData data = snapshort.getValue(updateData.class);
                    list.add(data);
                }
                Collections.reverse(list);
                adapter = new updateAdapter(Setting.this,list);
                ebookRecyler.setLayoutManager(new LinearLayoutManager(Setting.this));
                ebookRecyler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Setting.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //    bacck on arrow show in toolbar
    /** @noinspection deprecation*/
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}