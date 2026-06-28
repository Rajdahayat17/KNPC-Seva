package com.example.seva_knpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.seva_knpc.ExamNotice.Admin_Exam;
import com.example.seva_knpc.Forms.Admin_Forms;
import com.example.seva_knpc.academic.admin_academic;
import com.example.seva_knpc.otherNotice.Admin_Other;
import com.example.seva_knpc.scholarship.Scholarship_admin;
import com.example.seva_knpc.sports.admin_sports;
import com.example.seva_knpc.appUpdate.update;

public class adminpanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adminpanel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //noinspection deprecation
        getWindow().setStatusBarColor(getResources().getColor(R.color.purple_500));

        CardView cardView1 = (CardView) findViewById(R.id.Academicadmin) ;
        CardView cardView2 = (CardView) findViewById(R.id.scholarship_cd);
        CardView cardView3 = (CardView) findViewById(R.id.sports_cd);
        CardView cardView4 = (CardView) findViewById(R.id.forms_cd);
        CardView cardView5 = (CardView) findViewById(R.id.Other_cd);
        CardView cardView6 = (CardView) findViewById(R.id.Exam_cd);
        CardView cardView7 = (CardView) findViewById(R.id.adminlogout);
        CardView cardView8 = (CardView) findViewById(R.id.update_cd);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminpanel.this, admin_academic.class);
                startActivity(intent);
            }
        });

     cardView2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(adminpanel.this, Scholarship_admin.class);
             startActivity(intent);
         }
     });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adminpanel.this, admin_sports.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adminpanel.this, Admin_Forms.class);
                startActivity(intent);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminpanel.this, Admin_Other.class);
                startActivity(intent);

            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminpanel.this, Admin_Exam.class);
                startActivity(intent);

            }
        });

        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminpanel.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminpanel.this, update.class);
                startActivity(intent);
            }
        });


    }

    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        // Create an Intent to navigate back to MainActivity
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Optional: Call finish() to close the current activity

    }

}