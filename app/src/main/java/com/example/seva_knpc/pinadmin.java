package com.example.seva_knpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seva_knpc.databinding.ActivityPinadminBinding;
import com.google.android.material.textfield.TextInputEditText;

public class pinadmin extends AppCompatActivity {

    private ActivityPinadminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPinadminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       View Button = findViewById(R.id.verfybtn);
        Button.setAlpha(0f);
        Button.setTranslationY(50);
        Button.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        View TextInputLayout = findViewById(R.id.key);
        TextInputLayout.setAlpha(0f);
        TextInputLayout.setTranslationY(50);
        TextInputLayout.animate().alpha(1f).translationYBy(-50).setDuration(1500);


        getSupportActionBar().setTitle("Secturity Verification");
        //noinspection deprecation
        getWindow().setStatusBarColor(getResources().getColor(R.color.purple_500));

// login ki liye

        TextInputEditText key =(TextInputEditText) findViewById(R.id.textkey3);

        Button button = (Button) findViewById(R.id.verfybtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.getText().toString().equals("JGNNRRB24") ){
                    Toast.makeText(pinadmin.this, "verifed", Toast.LENGTH_SHORT).show();
                    //noinspection deprecation


                    Intent intent = new Intent(pinadmin.this, AdminLoginpage.class);
                    startActivity(intent);
                    finish();


                }else
                    Toast.makeText(pinadmin.this, "Retry", Toast.LENGTH_SHORT).show();
//                incorrect
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
//    backpresd botom back button

    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        // Create an Intent to navigate back to MainActivity
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Optional: Call finish() to close the current activity

    }
//    bacck on arrow show in toolbar
        /** @noinspection deprecation*/
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
