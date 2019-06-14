package com.example.finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HearthstoneCardPojo {
    @SerializedName("Basic")
    public ArrayList<CardInfo> basic;
    @SerializedName("Classic")
    public ArrayList<CardInfo> classic;
    @SerializedName("Hall of Fame")
    public ArrayList<CardInfo> hallOfFame;
    @SerializedName("Naxxramas")
    public ArrayList<CardInfo> naxxRamas;
    @SerializedName("Goblins vs Gnomes")
    public ArrayList<CardInfo> goblinVsGnomes;
    @SerializedName("Blackrock Mountain")
    public ArrayList<CardInfo> blackRockMountain;
    @SerializedName("The Grand Tournament")
    public ArrayList<CardInfo> theGrandTournament;
    @SerializedName("The League of Explorers")
    public ArrayList<CardInfo> theLeagueOfExplorers;
    @SerializedName("Whispers of the Old Gods")
    public ArrayList<CardInfo> whispersOfTheOldGods;
    @SerializedName("One Night in Karazhan")
    public ArrayList<CardInfo> oneNightInKarazhan;
    @SerializedName("Journey to Un'Goro")
    public ArrayList<CardInfo> journeyToUnGoro;
    @SerializedName("Knights of the Frozen Throne")
    public ArrayList<CardInfo> knightsOfTheFrozenThrone;
    @SerializedName("Kobolds & Catacombs")
    public ArrayList<CardInfo> koboldsCatacombsPojo;
    @SerializedName("The Witchwood")
    public ArrayList<CardInfo> theWitchwood;
    @SerializedName("The Boomsday Project")
    public ArrayList<CardInfo> theBoomsdayPorject;
    @SerializedName("Rastakhan's Rumble")
    public ArrayList<CardInfo> rastakhansRumble;
    @SerializedName("Rise of Shadows")
    public ArrayList<CardInfo> riseOfShadows;

}
