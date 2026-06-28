package com.example.seva_knpc.Forms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seva_knpc.PdfViewerActivity;
import com.example.seva_knpc.R;

import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.FormViewHolder>{

    private Context context;
    private List<FormData> list;

    public FormAdapter(Context context, java.util.List<FormData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);
        return new FormViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder holder, final int position) {
      holder.ebookName.setText(list.get(position).getName());


      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(context, PdfViewerActivity.class);
              intent.putExtra("pdfurl",list.get(position).getPdfUrl());
              context.startActivity(intent);
          }
      });

      holder.ebookdownload.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
             Intent intent  = new Intent(Intent.ACTION_VIEW);
             intent.setData(Uri.parse(list.get(position).getPdfUrl()));
             context.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FormViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookName;
        private ImageView ebookdownload;

        public FormViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookdownload = itemView.findViewById(R.id.Ebook_download);
            ebookName = itemView.findViewById(R.id.Ebook_name);
        }

    }
}
