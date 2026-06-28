package com.example.seva_knpc.ExamNotice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.seva_knpc.Forms.Admin_Forms;
import com.example.seva_knpc.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.HashMap;

public class Admin_Exam extends AppCompatActivity {

    private CardView addPdf;
    private final  int REQ = 1;

    private TextView pdfTextView;


    private EditText pdfTitle;
    private Button uploadPdfBtn;
    private Uri pdfData;

    private String pdfName, title;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    String downlaodUrl = "";
    private ProgressDialog pd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_exam);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //noinspection deprecation
        getWindow().setStatusBarColor(getResources().getColor(R.color.purple_500));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Exam Notice Upload");




        databaseReference= FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        //noinspection deprecation
        pd = new ProgressDialog(this);

        addPdf = findViewById(R.id.Exam_addpdf);
        pdfTitle = findViewById(R.id.Exam_pdfTitle);
        uploadPdfBtn = findViewById(R.id.Exam_uploadPdfBtn);
        pdfTextView = findViewById(R.id.Exam_pdfTextView);

        addPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        uploadPdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = pdfTitle.getText().toString();
                if (title.isEmpty()){
                    pdfTitle.setError("Please Enter Title");
                    pdfTitle.requestFocus();

                } else if (pdfData == null) {
                    Toast.makeText(Admin_Exam.this, "upload form pdf", Toast.LENGTH_SHORT).show();

                }else {
                    uploadPdf();
                }
            }
        });
    }

    private void uploadPdf() {
        pd.setTitle("Please Wait....");
        //noinspection deprecation
        pd.setMessage("Uploading pdf");
        pd.show();
        StorageReference  reference = storageReference.child("Exam/"+pdfName+"-"+System.currentTimeMillis()+".pdf");
        reference.putFile(pdfData)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri = uriTask.getResult();
                        uploadData(String.valueOf(uri));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(Admin_Exam.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void uploadData(String downlaodUrl) {

        String uniquekey = databaseReference.child("Exam").push().getKey();

        HashMap data = new HashMap();
        data.put("name",title);
        data.put("pdfUrl",downlaodUrl);


        databaseReference.child("Exam").child(uniquekey).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                pd.dismiss();
                Toast.makeText(Admin_Exam.this, "PDF Uploading Successfuliy", Toast.LENGTH_SHORT).show();
                pdfTitle.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(Admin_Exam.this, "Failed To Upload PDF", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //noinspection deprecation
        startActivityForResult(Intent.createChooser(intent, "Select PDF File"),REQ);
    }

    /** @noinspection ReassignedVariable*/
    @Override
    protected void onActivityResult(int requestcode, int resultcode, @Nullable Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if (requestcode == REQ && resultcode == RESULT_OK){
            pdfData = data.getData();

            if (pdfData.toString().startsWith("content://")){

                Cursor cursor = null;
                try {
                    cursor= Admin_Exam.this.getContentResolver().query(pdfData,null,null,null,null);
                    if (cursor != null && cursor.moveToFirst()){
                        pdfName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (pdfData.toString().startsWith("file://")) {
                pdfName = new File(pdfData.toString()).getName();
            }
            pdfTextView.setText(pdfName);

        }
    }
    // bacck on arrow show in toolbar
    /** @noinspection deprecation*/
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();

    }
}