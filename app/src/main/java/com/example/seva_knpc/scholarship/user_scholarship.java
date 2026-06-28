package com.example.seva_knpc.scholarship;

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

import com.example.seva_knpc.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class user_scholarship extends AppCompatActivity {
    private RecyclerView ebookRecyler;
    private DatabaseReference reference;
    private List<ScholarData> list;
    private ScholarshipAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_scholarship);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //noinspection deprecation
        getWindow().setStatusBarColor(getResources().getColor(R.color.purple_500));
        getSupportActionBar().setTitle("Scholarship Notice");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        ebookRecyler =findViewById(R.id.ebookRecyler);
        reference = FirebaseDatabase.getInstance().getReference().child("Scholarship");

        getData();

    }
    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshort : datasnapshot.getChildren()){
                    ScholarData data = snapshort.getValue(ScholarData.class);
                    list.add(data);
                }
                Collections.reverse(list);
                adapter = new ScholarshipAdapter(user_scholarship.this,list);
                ebookRecyler.setLayoutManager(new LinearLayoutManager(user_scholarship.this));
                ebookRecyler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(user_scholarship.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    // bacck on arrow show in toolbar
    /** @noinspection deprecation*/
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();

    }
}