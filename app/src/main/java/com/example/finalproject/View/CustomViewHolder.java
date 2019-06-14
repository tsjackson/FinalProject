package com.example.finalproject.View;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    CustomAdapter customAdapter;
    public ImageView iv_cardImg;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        iv_cardImg = itemView.findViewById(R.id.iv_cardImg);
    }

}
