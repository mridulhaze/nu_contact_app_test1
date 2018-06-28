package com.example.mridul.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.mridul.myapplication.Database.Database;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

import Adapter.SearchAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapter adapter;
    MaterialSearchBar materialSearchBar;
    List<String> suggestList = new ArrayList<>();

    Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initializing views

        recyclerView =(RecyclerView)findViewById(R.id.recyeler_search);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        materialSearchBar = (MaterialSearchBar)findViewById(R.id.search_bar);

        // initialization database


        database = new Database(this);

        // setup search bar

        materialSearchBar.setHint("Search");
        materialSearchBar.setCardViewElevation(10);
        loadSuggestList();
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<String> suggest = new ArrayList<>();
                for(String search:suggestList){
                    if(search.toLowerCase().contains(materialSearchBar.getText().toLowerCase()))
                        suggest.add(search);
                }
                materialSearchBar.setLastSuggestions(suggest);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if(!enabled) recyclerView.setAdapter(adapter);
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString());

            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });

        // initialization adapter default set all result

        adapter = new SearchAdapter(this,database.getFriend());
        recyclerView.setAdapter(adapter);

    }

    private void startSearch(String text) {
        adapter = new SearchAdapter(this,database.getFriendsByName(text));
        recyclerView.setAdapter(adapter);
    }


    private void loadSuggestList() {

        suggestList = database.getNames();
        materialSearchBar.setLastSuggestions(suggestList);

    }
}
