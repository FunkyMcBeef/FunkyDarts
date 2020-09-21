package com.example.root.funkydarts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SetupActivity extends AppCompatActivity {

    static ArrayList<String> players = new ArrayList<>();
    static int point;

    Button addPlayer, clearList, startGame;
    EditText name;
    Spinner spinner;
    static CheckBox doubleOut;
    CheckBox elimination;
    ListView viewPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(SetupActivity.this, android.R.layout.simple_expandable_list_item_1, players);

        name = findViewById(R.id.playerName);
        name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)){
                    String getName = name.getText().toString();

                    //check if player already exists
                    if(players.contains(getName)){
                        hideKeyboard();
                        Toast.makeText(getBaseContext(), "Same dude plays twice? Nah!", Toast.LENGTH_SHORT).show();
                    }else if(getName == null || getName.trim().equals("")){
                        hideKeyboard();
                        Toast.makeText(getBaseContext(), "No Name No Player bro!", Toast.LENGTH_SHORT).show();
                    }else{
                        hideKeyboard();

                        players.add(getName);

                        viewPlayers.setAdapter(adapter);
                        ((EditText)findViewById(R.id.playerName)).setText(" ");
                    }
                    return true;
                }
                return false;
            }
        });

        //get the points to reduce. e.G. 501
        spinner = findViewById(R.id.spinnerPoints);

        doubleOut = findViewById(R.id.doubleOutBox);
        elimination = findViewById(R.id.eliminatinBox);

        viewPlayers = findViewById(R.id.playerListView);

        //add player button activity
        addPlayer = findViewById(R.id.addPlayerBtn);
        addPlayer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String getName = name.getText().toString();

                //check if player already exists
                if(players.contains(getName)){
                    Toast.makeText(getBaseContext(), "Same dude plays twice? Nah!", Toast.LENGTH_SHORT).show();
                }else if(getName == null || getName.trim().equals("")){
                    Toast.makeText(getBaseContext(), "No Name No Player bro!", Toast.LENGTH_SHORT).show();
                }else{
                    players.add(getName);

                    viewPlayers.setAdapter(adapter);
                    ((EditText)findViewById(R.id.playerName)).setText(" ");
                }
            }
        });

        //clear the ListView
        clearList = findViewById(R.id.btnClear);
        clearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                players.clear();
                adapter.notifyDataSetChanged();
            }
        });

        //start game button activity
        startGame = findViewById(R.id.startGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point = Integer.parseInt(spinner.getSelectedItem().toString());

                if(players.isEmpty()){
                    Toast.makeText(getBaseContext(), "No Players No Game bro!", Toast.LENGTH_SHORT).show();
                }else {
                    if(!elimination.isChecked())
                        openGameActivity();
                    else
                        openEliminationActivity();
                }
            }
        });
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void openGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void openEliminationActivity(){
        Intent intent = new Intent(this, EliminationActivity.class);
        startActivity(intent);
    }
}
