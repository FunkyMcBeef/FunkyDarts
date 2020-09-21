package com.example.root.funkydarts;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class EliminationActivity extends AppCompatActivity {

    static int activeEliminator = 0;
    private int multiplier = 1;

    private TextView currentPlayer, firstThrow, secondThrow, thirdThrow, scoreView, averageView, closestPlayer, toGo, toWin;

    private Button btnDouble, btnTriple, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,
            btnBull, btnMiss, btnUndo, btnStandings;

    static ArrayList<Eliminator> eliminators;
    static ArrayList<Eliminator> sortedElim  = new ArrayList<>();

    private Handler delayHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elimination);

        eliminators = createEliminators();
        for(Eliminator tmp : eliminators) {
            sortedElim.add(tmp);
        }

        currentPlayer = findViewById(R.id.current_player);
        currentPlayer.setText(eliminators.get(activeEliminator).getName());

        firstThrow = findViewById(R.id.first_throw);
        secondThrow = findViewById(R.id.second_throw);
        thirdThrow = findViewById(R.id.third_throw);

        scoreView = findViewById(R.id.score_view);
        scoreView.setText(String.valueOf(eliminators.get(activeEliminator).getScore()));

        averageView = findViewById(R.id.average_view);
        averageView.setText(String.valueOf(eliminators.get(activeEliminator).getAverage()));

        closestPlayer = findViewById(R.id.closest_player_view);
        closestPlayer.setText("You're the 1st");
        toGo = findViewById(R.id.togo_view);
        toGo.setText("-");

        toWin = findViewById(R.id.towin_view);
        toWin.setText(String.valueOf(eliminators.get(activeEliminator).getGoal() - eliminators.get(activeEliminator).getScore()));

        btnStandings = findViewById(R.id.btnStandings);
        btnStandings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStandings();
            }
        });

        btnDouble = findViewById(R.id.btnDouble);
        btnDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(multiplier == 2) {
                    btnDouble.setBackgroundColor(Color.LTGRAY);
                    multiplier = 1;
                    btnBull.setText("Bull");
                }else {
                    btnTriple.setBackgroundColor(Color.LTGRAY);
                    btnDouble.setBackgroundColor(Color.GREEN);
                    multiplier = 2;
                    btnBull.setText("Bull's-Eye");
                }
            }
        });

        btnTriple = findViewById(R.id.btnTriple);
        btnTriple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(multiplier == 3) {
                    multiplier = 1;
                    btnTriple.setBackgroundColor(Color.LTGRAY);
                }else {
                    multiplier = 3;
                    btnDouble.setBackgroundColor(Color.LTGRAY);
                    btnTriple.setBackgroundColor(Color.GREEN);
                }
            }
        });

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(1);
            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(2);
            }
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(3);
            }
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(4);
            }
        });

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(5);
            }
        });

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(6);
            }
        });

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(7);
            }
        });

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(8);
            }
        });

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(9);
            }
        });

        btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(10);
            }
        });

        btn11 = findViewById(R.id.btn11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(11);
            }
        });

        btn12 = findViewById(R.id.btn12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(12);
            }
        });

        btn13 = findViewById(R.id.btn13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(13);
            }
        });

        btn14 = findViewById(R.id.btn14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(14);
            }
        });

        btn15 = findViewById(R.id.btn15);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(15);
            }
        });

        btn16 = findViewById(R.id.btn16);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(16);
            }
        });

        btn17 = findViewById(R.id.btn17);
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(17);
            }
        });

        btn18 = findViewById(R.id.btn18);
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(18);
            }
        });

        btn19 = findViewById(R.id.btn19);
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(19);
            }
        });

        btn20 = findViewById(R.id.btn20);
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(20);
            }
        });

        btnBull = findViewById(R.id.btnBull);
        btnBull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(multiplier == 3) {
                    Toast.makeText(getBaseContext(), "Triple Bull? Bad Joke!", Toast.LENGTH_SHORT).show();
                    multiplier = 1;
                }else
                    makeThrow(25);
            }
        });

        btnMiss = findViewById(R.id.btnMiss);
        btnMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(0);
            }
        });
    }

    public ArrayList<Eliminator> createEliminators(){
        ArrayList<Eliminator> local = new ArrayList<>();
        int id = 0;
        for(String eli : SetupActivity.players) {
            local.add(new Eliminator(eli, id, SetupActivity.point));
            id++;
        }
        return local;
    }

    private void makeThrow(int number){

        btnDouble.setBackgroundColor(Color.LTGRAY);
        btnTriple.setBackgroundColor(Color.LTGRAY);

        //Step one: check whether the player won the game or exceeded the score
        checkWin(number);

        //Step two: set the Score of the player (the function only gets here if the player neither won nor exceeded
        eliminators.get(activeEliminator).setScore(number * multiplier);

        //Step three: update the view
        updateView();
        Collections.sort(sortedElim);
        updateElimView();
    }

    private void checkWin(int number){
        if(!SetupActivity.doubleOut.isChecked()) {
            //single out
            if (eliminators.get(activeEliminator).getScore() + (number * multiplier) == eliminators.get(activeEliminator).getGoal()) {
                //player won
                openWinDialog();
            }else if(eliminators.get(activeEliminator).getScore() + (number * multiplier) > eliminators.get(activeEliminator).getGoal()){
                //player exceeded
            }else{
                //exit checkWin() to continue in makeThrow()
                return;
            }

        }else{
            //double out
            if(eliminators.get(activeEliminator).getScore() + (2 * number * multiplier) == eliminators.get(activeEliminator).getGoal()){
                //player won
                openWinDialog();
            }else if(eliminators.get(activeEliminator).getScore() + (number * multiplier) >= eliminators.get(activeEliminator).getGoal() - 1){
                //player exceeded or got to 1 to go
            }else {
                //exit checkWin() to continue in makeThrow()
                return;
            }
        }
    }

    private void updateView(){
        //if the size of (eachThrow - 1) % 3 is 0 it is the first throw. 1 the second and 2 the third
        switch ((eliminators.get(activeEliminator).eachThrow.size() - 1) % 3 ){
            case 0:
                firstThrow.setText(String.valueOf(eliminators.get(activeEliminator).eachThrow.get(eliminators.get(activeEliminator).eachThrow.size() - 1)));

                scoreView.setText(String.valueOf(eliminators.get(activeEliminator).getScore()));
                averageView.setText(String.valueOf(eliminators.get(activeEliminator).getAverage()));

                toWin.setText(String.valueOf(eliminators.get(activeEliminator).getGoal() - eliminators.get(activeEliminator).getScore()));

                //reset multiplier and the Bull button
                btnBull.setText("Bull");
                multiplier = 1;
                break;
            case 1:
                secondThrow.setText(String.valueOf(eliminators.get(activeEliminator).eachThrow.get(eliminators.get(activeEliminator).eachThrow.size() - 1)));

                scoreView.setText(String.valueOf(eliminators.get(activeEliminator).getScore()));
                averageView.setText(String.valueOf(eliminators.get(activeEliminator).getAverage()));

                toWin.setText(String.valueOf(eliminators.get(activeEliminator).getGoal() - eliminators.get(activeEliminator).getScore()));

                //reset multiplier and the Bull button
                btnBull.setText("Bull");
                multiplier = 1;
                break;
            case 2:
                thirdThrow.setText(String.valueOf(eliminators.get(activeEliminator).eachThrow.get(eliminators.get(activeEliminator).eachThrow.size() - 1)));

                scoreView.setText(String.valueOf(eliminators.get(activeEliminator).getScore()));
                averageView.setText(String.valueOf(eliminators.get(activeEliminator).getAverage()));

                toWin.setText(String.valueOf(eliminators.get(activeEliminator).getGoal() - eliminators.get(activeEliminator).getScore()));

                //reset multiplier and the Bull button
                btnBull.setText("Bull");
                multiplier = 1;

                //lock touch during delay
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                //delay of 2 Seconds before the View switches to next Player
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //reset the view and jump to the next player
                        nextPlayer();

                        //get touch back after delay
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
                }, 2000);
                break;
        }

    }

    private void nextPlayer(){
        //Check if the current player was not the last one. jump to first player if so.
        if(activeEliminator < eliminators.size() - 1){
            activeEliminator++;
        }else
            activeEliminator = 0;

        currentPlayer.setText(eliminators.get(activeEliminator).getName());
        firstThrow.setText("-");
        secondThrow.setText("-");
        thirdThrow.setText("-");
        scoreView.setText(String.valueOf(eliminators.get(activeEliminator).getScore()));
        averageView.setText(String.valueOf(eliminators.get(activeEliminator).getAverage()));

        toWin.setText(String.valueOf(eliminators.get(activeEliminator).getGoal() - eliminators.get(activeEliminator).getScore()));

        updateElimView();
    }

    private void updateElimView() {
        int position = 0;
        int counter = 0;
        //here we compare all id's of the eliminators arraylist to the ones in the sorted eliminators to find the postion of the active player in the sorted list
        for(Eliminator elim : sortedElim){
            if(eliminators.get(activeEliminator).getId() == elim.getId())
                position = sortedElim.indexOf(elim);
        }

        //first Step: check if active player is the leader
        //i compare the id of the active player to the id of the player in the last position of the sorted array. hes the leader
        if(eliminators.get(activeEliminator).getId() == sortedElim.get(sortedElim.size() - 1).getId()){
            //current player is leader
            closestPlayer.setText("You're the 1st");
            toGo.setText("-");
        }else if(eliminators.get(activeEliminator).getScore() > sortedElim.get(position + 1).getScore()){
            //current Player exceeded the closest. We need to run checkElimination method to see whether he eliminated the next but one
            checkElimination();
            closestPlayer.setText("To: " + sortedElim.get(position + 1).getName());
            toGo.setText(String.valueOf(sortedElim.get(position + 1).getScore()
                    - sortedElim.get(position).getScore()));
        } else if (eliminators.get(activeEliminator).getScore() == sortedElim.get(position + 1).getScore()){
            //player got the same score as next one --> perform checkElimination() to eliminate the player
            checkElimination();
            //Collections.sort(sortedElim);
            //now we have to check again whether the current player is the leader
            if(eliminators.get(activeEliminator).getId() == sortedElim.get(sortedElim.size() - 1).getId()) {
                //current player is leader
                closestPlayer.setText("You're the 1st");
                toGo.setText("-");
            }else{
                closestPlayer.setText("To: " + sortedElim.get(position + 1).getName());
                toGo.setText(String.valueOf(sortedElim.get(position + 1).getScore()
                                - sortedElim.get(position).getScore()));
            }
        }else{
            //player ist still chasing
            closestPlayer.setText("To: " + sortedElim.get(position + 1).getName());
            toGo.setText(String.valueOf(sortedElim.get(position + 1).getScore()
                                        - sortedElim.get(position).getScore()));
        }
    }

    public void checkElimination(){
        for(Eliminator victim : eliminators){
            //at first we check that the victim is not the active player by comparing their id's
            if(eliminators.get(activeEliminator).getId() != victim.getId()) {
                //now we check if the score of the active player is the same as the victim AND the score is not null.
                if (eliminators.get(activeEliminator).getScore() == victim.getScore() && eliminators.get(activeEliminator).getScore() != 0) {
                    //we got a victim to eliminate
                    victim.eliminate();
                    openElimDialog(victim);
                    Collections.sort(sortedElim);
                }
            }
        }
    }

    private void openElimDialog(Eliminator victim){
        AlertDialog.Builder builder = new AlertDialog.Builder(EliminationActivity.this);
        builder.setTitle("Elimination!")
                .setMessage(victim.getName()
                        + " got eliminated!")
                .setPositiveButton("Great", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       updateElimView();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showStandings(){
        Intent intent = new Intent(this, StandingsElimination.class);
        startActivity(intent);
    }

    private void openWinDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(EliminationActivity.this);
        builder.setTitle("Winner!!!")
                .setMessage(eliminators.get(activeEliminator).getName()
                        + " won the Game!")
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
