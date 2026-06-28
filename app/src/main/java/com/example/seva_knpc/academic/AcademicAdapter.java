package com.example.seva_knpc.academic;

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

public class AcademicAdapter extends RecyclerView.Adapter<AcademicAdapter.AcademicViewHolder> {

    private Context context;
    private List<AcademicData> list;

    public AcademicAdapter(Context context, List<AcademicData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AcademicAdapter.AcademicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);
        return new AcademicAdapter.AcademicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AcademicAdapter.AcademicViewHolder holder, final int position) {
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

    public class AcademicViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookName;
        private ImageView ebookdownload;
        public AcademicViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookdownload = itemView.findViewById(R.id.Ebook_download);
            ebookName = itemView.findViewById(R.id.Ebook_name);
        }
    }
}