package com.example.root.funkydarts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StandingsElimination extends AppCompatActivity {

    ArrayList<String> standings;

    ListView standingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings_elimination);

        standings = new ArrayList<>();

        for(Eliminator eliminator : EliminationActivity.eliminators){
            standings.add(eliminator.toString());
        }

        standingView = findViewById(R.id.standings_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(StandingsElimination.this, android.R.layout.simple_expandable_list_item_1, standings);
        standingView.setAdapter(adapter);
    }
}
