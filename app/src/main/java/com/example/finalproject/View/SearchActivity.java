package com.example.finalproject.View;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SearchActivity extends Activity {
//
//    ListView l;
//
//    String[] testArray;
//    List<String> testArrayList;
//    ArrayAdapter<String> adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        testArray = getResources().getStringArray(R.array.list);
//        testArrayList = new ArrayList<String>(Arrays.asList(testArray));
//
//        l = (ListView) findViewById(R.id.progressBar1);
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testArrayList);
//        l.setAdapter(adapter);
//
//        handleIntent(getIntent());
//    }
//
//    protected void onNewIntent(Intent intent) {
//        handleIntent(intent);
//    }
//
//    private void handleIntent(Intent intent) {
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            //Log.d("Event", query);
//
//            search(query);
//        }
//    }
//
//    private boolean search(String query) {
//
//        Iterator<String> iter = testArrayList.iterator();
//        while (iter.hasNext()) {
//            if (!iter.next().contains(query)) {
//                iter.remove();
//            }
//        }
//
//        //@Override
////        public boolean onCreateOptionsMenu (){
////            // Inflate the menu; this adds items to the action bar if it is present.
////            getMenuInflater().inflate(R.menu.options_menu, menu);
////
////            return true;
////        }true
//   // }
}