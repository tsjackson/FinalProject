package com.example.finalproject.View;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Model.CardInfo;
import com.example.finalproject.Model.HearthstoneCardPojo;
import com.example.finalproject.Model.HearthstoneCardResults;
import com.example.finalproject.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.http2.Http2Connection;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    Listener listener;

    private List<CardInfo>dataSet = new ArrayList<>();


    public void setDataSet(List<CardInfo> dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        try {
            setImage(holder.iv_cardImg, position);
            holder.iv_cardImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(dataSet.get(position));

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setImage(ImageView imageView, int position) throws IOException {

        Picasso.get().load(dataSet.get(position).img)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.hearthstoneicon)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
    public interface Listener{
        void onClick(CardInfo cardInfo);
    }
    public CustomAdapter(Listener listener){
        this.listener = listener;
    }
}
