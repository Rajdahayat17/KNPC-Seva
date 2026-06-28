package com.example.seva_knpc.ui.Developer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.seva_knpc.R;

public class DeveloperFragment extends Fragment {

    Activity Developer;

    public DeveloperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Developer = getActivity();
        return inflater.inflate(R.layout.fragment_developer, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        ImageView Nabeel_insta = (ImageView) Developer.findViewById(R.id.Nabeel_insta);
        ImageView raj_insta = (ImageView) Developer.findViewById(R.id.raj_insta);
        ImageView brajesh_insta = (ImageView) Developer.findViewById(R.id.brajesh_insta);


        Nabeel_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/mohdnabeel958/?utm_source=qr&r=nametag"; // Replace with your desired URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        raj_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/mr._raj._dahiya?igsh=MTFkbXY1YWNzd2Yycw=="; // Replace with your desired URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        brajesh_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/brajesh4453?igsh=MW53c3NyN2F1NWh5ZQ=="; // Replace with your desired URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        ImageView Nabeel_linked = (ImageView) Developer.findViewById(R.id.Nabeel_linked);
        ImageView raj_linked = (ImageView) Developer.findViewById(R.id.raj_linked);
        ImageView brajesh_linked = (ImageView) Developer.findViewById(R.id.brajesh_linked);


        Nabeel_linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https:www.linkedin.com/in/mohd-nabeel-9938682bb?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"; // Replace with your desired URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        raj_linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.linkedin.com/in/raj-dahayat-34876128b?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"; // Replace with your desired URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });



    }
}