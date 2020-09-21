package com.example.root.funkydarts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StandingsActivity extends AppCompatActivity {

    ArrayList<String> standings;

    ListView standingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        standings = new ArrayList<>();

        for(Player player: GameActivity.players){
            standings.add(player.toString());
        }

        standingView = findViewById(R.id.standings_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(StandingsActivity.this, android.R.layout.simple_expandable_list_item_1, standings);
        standingView.setAdapter(adapter);
    }
}
