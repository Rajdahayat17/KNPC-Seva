package com.example.seva_knpc.ui.Notice;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.seva_knpc.ExamNotice.user_Exam;
import com.example.seva_knpc.Forms.user_forms;
import com.example.seva_knpc.R;
import com.example.seva_knpc.academic.user_academic;
import com.example.seva_knpc.otherNotice.user_Other;
import com.example.seva_knpc.scholarship.user_scholarship;
import com.example.seva_knpc.sports.user_sports;

public class HomeFragment extends Fragment {


    Activity Home;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Home = getActivity();
        return inflater.inflate(R.layout.fragment_home, container, false);



    }
    @Override
    public void onStart() {
        super.onStart();

        CardView cardView1 = (CardView) Home.findViewById(R.id.Academic_cd);
        CardView cardView2 = (CardView) Home.findViewById(R.id.scholarship_cd);
        CardView cardView3 = (CardView) Home.findViewById(R.id.sports_cd);
        CardView cardView4 = (CardView) Home.findViewById(R.id.forms_cd);
        CardView cardView5 = (CardView) Home.findViewById(R.id.Other_cd);
        CardView cardView6 = (CardView) Home.findViewById(R.id.Exam_cd);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home, user_academic.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home, user_scholarship.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home, user_sports.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home, user_forms.class);
                startActivity(intent);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home, user_Other.class);
                startActivity(intent);
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View view) {
           Intent intent = new Intent(Home, user_Exam.class);
            startActivity(intent);

        }
      });



        CardView Knpc = (CardView) Home.findViewById(R.id.Knpc_web);
        CardView Rgpv = (CardView) Home.findViewById(R.id.Rgpv_web);

        Knpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://knpolyjbp.ac.in/"; // Replace with your desired URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        Rgpv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.rgpvdiploma.in/Index.aspx"; // Replace with your desired URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


    }
}