package com.example.seva_knpc.appUpdate;

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

import com.example.seva_knpc.R;

import java.util.List;

public class updateAdapter extends RecyclerView.Adapter<updateAdapter.ViewHolder>{

    private Context context;
    private List<updateData> list;

    public updateAdapter(Context context, List<updateData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public updateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.app_update,parent,false);
        return new updateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull updateAdapter.ViewHolder holder, final int position) {
        holder.ebookName.setText(list.get(position).getName());


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

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ebookName;
        private ImageView ebookdownload;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookdownload = itemView.findViewById(R.id.Ebook_download);
            ebookName = itemView.findViewById(R.id.Ebook_name);
        }

    }
}
