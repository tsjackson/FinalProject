package com.example.finalproject.View;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.Model.CardInfo;
import com.example.finalproject.Model.HearthstoneCardPojo;
import com.example.finalproject.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class    DialogFragment extends androidx.fragment.app.DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_CARDSET = "cardSet";
    private static final String ARG_TYPE = "type";
    private static final String ARG_RARITY = "rarity";
    private static final String ARG_TEXT = "text";
    private static final String ARG_FLAVOR = "flavor";
    private static final String ARG_PLAYERCLASS = "playerClass";
    private static final String ARG_IMG = "img";
    private static final String ARG_IMGGOLD = "imgGold";

    // TODO: Rename and change types of parameters
    private TextView name;
    private TextView cardSet;
    private TextView type;
    private TextView rarity;
    private TextView text;
    private TextView flavor;
    private TextView playerClass;
    private String imgURL;
    private ImageView img;

    private static final String TAG = "DialogFragment";
    public DialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DialogFragment newInstance(CardInfo cardpojo, Bundle bundle) {
        DialogFragment fragment = new DialogFragment();

        bundle.putString(ARG_NAME, cardpojo.name);
        bundle.putString(ARG_CARDSET, cardpojo.cardSet);
        bundle.putString(ARG_TYPE, cardpojo.type);
        bundle.putString(ARG_RARITY, cardpojo.rarity);
        bundle.putString(ARG_TEXT, cardpojo.text);
        bundle.putString(ARG_FLAVOR, cardpojo.flavor);
        bundle.putString(ARG_PLAYERCLASS, cardpojo.playerClass);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgURL = getArguments().getString("url");


        //todo get all text views and populate
        if (getArguments() != null) {

            name = view.findViewById(R.id.tv_cardName);
            cardSet = view.findViewById(R.id.tv_cardSet);
            type = view.findViewById(R.id.tv_type);
            rarity = view.findViewById(R.id.tv_rarity);
            text = view.findViewById(R.id.tv_text);
            flavor = view.findViewById(R.id.tv_flavor);
            playerClass = view.findViewById(R.id.tv_playerClass);

            img = view.findViewById(R.id.iv_cardImage);
            if(img.equals("'unimplemented'")){
                img.setImageResource(R.drawable.hearthstoneicon);
            }
            else {
                Picasso.get().load(imgURL)
                        .into(img);
            }

            name.setText(getArguments().getString(ARG_NAME));
            cardSet.setText(getArguments().getString(ARG_CARDSET));
            type.setText(getArguments().getString(ARG_TYPE));
            rarity.setText(getArguments().getString(ARG_RARITY));
            text.setText(getArguments().getString(ARG_TEXT));
            flavor.setText(getArguments().getString(ARG_FLAVOR));
            playerClass.setText(getArguments().getString(ARG_PLAYERCLASS));
        }
    }
}
