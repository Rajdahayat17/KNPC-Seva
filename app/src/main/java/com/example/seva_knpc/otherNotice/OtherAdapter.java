package com.example.seva_knpc.otherNotice;

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

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.OtherViewHolder> {

    private Context context;
    private List<OtherData> list;


    public OtherAdapter(Context context, List<OtherData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OtherAdapter.OtherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);
        return new OtherAdapter.OtherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherAdapter.OtherViewHolder holder, final int position) {
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

    public class OtherViewHolder extends RecyclerView.ViewHolder {
        private TextView ebookName;
        private ImageView ebookdownload;
        public OtherViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookdownload = itemView.findViewById(R.id.Ebook_download);
            ebookName = itemView.findViewById(R.id.Ebook_name);
        }
    }
}
