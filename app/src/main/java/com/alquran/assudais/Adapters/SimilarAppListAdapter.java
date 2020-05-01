package com.alquran.assudais.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alquran.assudais.Models.SimilarAppsList;
import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.AutoScrollableTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimilarAppListAdapter extends RecyclerView.Adapter<SimilarAppListAdapter.ViewHolder> {
    Context context;
    ArrayList<SimilarAppsList> allAppsList;

    public SimilarAppListAdapter(Context context, ArrayList<SimilarAppsList> allAppsList) {
        this.context = context;
        this.allAppsList = allAppsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lyt_similar_apps, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get().load(allAppsList.get(position).getAppIcon()).into(holder.img_app_icon);
        holder.txt_app_name.setText(allAppsList.get(position).getAppName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(allAppsList.get(position).getAppLink()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return allAppsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_app_icon)
        ImageView img_app_icon;
        @BindView(R.id.txt_app_name)
        AutoScrollableTextView txt_app_name;
        @BindView(R.id.txt_install_app)
        AutoScrollableTextView txt_install_app;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
