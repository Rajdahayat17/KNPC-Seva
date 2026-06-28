package com.example.seva_knpc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //noinspection deprecation
        getWindow().setNavigationBarColor(getResources().getColor(R.color.purple1));

//        getWindow().setNavigationBarColor(Color.TRANSPARENT); this is navigation bar / home button bar color

        ImageView imageView = findViewById(R.id.Knpclogo);
        imageView.setAlpha(0f);
        imageView.setTranslationY(50);
        imageView.animate().alpha(1f).translationYBy(-50).setDuration(1500);


        //noinspection deprecation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_screen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}