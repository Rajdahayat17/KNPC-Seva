package com.example.seva_knpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AdminLoginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_loginpage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //noinspection deprecation
//        getWindow().setStatusBarColor(getResources().getColor(R.color.purple_500));
//        getSupportActionBar().setTitle("KNPC Admin Login ");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextInputEditText textuser= (TextInputEditText) findViewById(R.id.textusername);
        TextInputEditText textpas =(TextInputEditText) findViewById(R.id.textpas);


        MaterialButton loginbtn = (MaterialButton)  findViewById(R.id.loginbtn);

//        raj and raj
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (textuser.getText().toString().equals("JyotiG") && textpas.getText().toString().equals("JyotiG#123")){
                    Toast.makeText(AdminLoginpage.this, "login", Toast.LENGTH_SHORT).show();
                    finish();

                    Intent intent = new Intent(AdminLoginpage.this, adminpanel.class);
                    startActivity(intent);
//                     correct

                }else
                    Toast.makeText(AdminLoginpage.this, "login faild", Toast.LENGTH_SHORT).show();
//                incorrect
            }

        });

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

}