package com.example.finalproject.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.finalproject.Model.CardInfo;
import com.example.finalproject.Model.HearthstoneCardPojo;
import com.example.finalproject.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomAdapter.Listener {
    private static final String TAG = "MainActivity";
    CustomViewModel customViewModel;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    public ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.progressBar1);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomAdapter(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        customViewModel = ViewModelProviders.of(this)
                .get(CustomViewModel.class);
        customViewModel.initRetrofit(this).observe(this,
                this::getResult);

    }

    private void getResult(HearthstoneCardPojo hearthstoneCardPojo) {
        ArrayList<CardInfo> newList = new ArrayList<>();
        newList.addAll(hearthstoneCardPojo.basic);
        newList.addAll(hearthstoneCardPojo.classic);
        newList.addAll(hearthstoneCardPojo.blackRockMountain);
        newList.addAll(hearthstoneCardPojo.goblinVsGnomes);
        newList.addAll(hearthstoneCardPojo.hallOfFame);
        newList.addAll(hearthstoneCardPojo.journeyToUnGoro);
        newList.addAll(hearthstoneCardPojo.knightsOfTheFrozenThrone);
        newList.addAll(hearthstoneCardPojo.koboldsCatacombsPojo);
        newList.addAll(hearthstoneCardPojo.naxxRamas);
        newList.addAll(hearthstoneCardPojo.oneNightInKarazhan);
        newList.addAll(hearthstoneCardPojo.rastakhansRumble);
        newList.addAll(hearthstoneCardPojo.riseOfShadows);
        newList.addAll(hearthstoneCardPojo.theBoomsdayPorject);
        newList.addAll(hearthstoneCardPojo.theGrandTournament);
        newList.addAll(hearthstoneCardPojo.theLeagueOfExplorers);
        newList.addAll(hearthstoneCardPojo.theWitchwood);
        newList.addAll(hearthstoneCardPojo.whispersOfTheOldGods);

        for (int i = 0; i < newList.size(); i++) {

            if(newList.get(i).collectible == null || newList.get(i).collectible.equals("")) {
                newList.remove(i);
                i--;
            }
            else if (newList.get(i).img == null || newList.get(i).img.equals("")){
                newList.remove(i);
                i--;
            }
        }
        adapter.setDataSet(newList);
        spinner.setVisibility(View.GONE);
    }
    @Override
    public void onClick(CardInfo cardPojo) {
        String url = cardPojo.img;
                showDialogFragment(cardPojo, url);
    }

    private void showDialogFragment(CardInfo cardPojo, String url) {
        Log.d(TAG, "showDialogFragment: ");
        FragmentManager fm = getSupportFragmentManager();
        Bundle b = new Bundle();
        b.putString("url",cardPojo.img);
        DialogFragment dialogFragment = DialogFragment.newInstance(cardPojo, b);

        dialogFragment.show(getSupportFragmentManager(), "dialog");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
