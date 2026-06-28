package com.example.seva_knpc.sports;

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

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.SportsViewHolder> {

    private Context context;
    private List<sportsData> list;

    public SportsAdapter(Context context, List<sportsData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SportsAdapter.SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);
        return new SportsAdapter.SportsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.SportsViewHolder holder, int position) {
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

    public class SportsViewHolder extends RecyclerView.ViewHolder {
        private TextView ebookName;
        private ImageView ebookdownload;
        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);
            ebookdownload = itemView.findViewById(R.id.Ebook_download);
            ebookName = itemView.findViewById(R.id.Ebook_name);
        }
    }
}
