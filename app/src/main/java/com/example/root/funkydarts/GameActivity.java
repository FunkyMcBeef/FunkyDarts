package com.example.root.funkydarts;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends Activity {
    private Handler delayHandler = new Handler();

    static int activePlayer = 0;
    int darts = 0;
    private int multiplier = 1;

    private TextView currentPlayer, firstThrow, secondThrow, thirdThrow, scoreView, averageView;
    private Button btnDouble, btnTriple, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,
            btnBull, btnMiss, btnUndo, btnStandings;

    static ArrayList<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        players = createPlayers();

        currentPlayer = findViewById(R.id.currentPlayer);
        currentPlayer.setText(players.get(activePlayer).getPlayerName());

        firstThrow = findViewById(R.id.firstThrow);
        secondThrow = findViewById(R.id.secondThrow);
        thirdThrow = findViewById(R.id.thirdThrow);

        scoreView = findViewById(R.id.scoreView);
        scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));

        averageView = findViewById(R.id.averageView);
        averageView.setText(String.valueOf(players.get(activePlayer).getAverage()));

        //OnClickListeners for all buttons
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
                checkWin(1);
            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(2);
            }
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(3);
            }
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(4);
            }
        });

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(5);
            }
        });

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(6);
            }
        });

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(7);
            }
        });

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(8);
            }
        });

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(9);
            }
        });

        btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(10);
            }
        });

        btn11 = findViewById(R.id.btn11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(11);
            }
        });

        btn12 = findViewById(R.id.btn12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(12);
            }
        });

        btn13 = findViewById(R.id.btn13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(13);
            }
        });

        btn14 = findViewById(R.id.btn14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(14);
            }
        });

        btn15 = findViewById(R.id.btn15);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(15);
            }
        });

        btn16 = findViewById(R.id.btn16);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(16);
            }
        });

        btn17 = findViewById(R.id.btn17);
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(17);
            }
        });

        btn18 = findViewById(R.id.btn18);
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(18);
            }
        });

        btn19 = findViewById(R.id.btn19);
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(19);
            }
        });

        btn20 = findViewById(R.id.btn20);
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWin(20);
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
                    checkWin(25);
            }
        });

        btnMiss = findViewById(R.id.btnMiss);
        btnMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeThrow(multiplier, 0);
            }
        });

        btnUndo = findViewById(R.id.btnUndo);
        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset double and triple button color
                btnDouble.setBackgroundColor(Color.LTGRAY);
                btnTriple.setBackgroundColor(Color.LTGRAY);
                btnBull.setText("Bull");
                multiplier = 1;

                //nothing to undo before the first throw
                if(players.get(0).eachThrow.size() == 0) {
                    Toast.makeText(getBaseContext(), "Nothing to Undo yet", Toast.LENGTH_SHORT).show();
                }else {
                    undoThrow();
                }
            }
        });
    }

    public ArrayList<Player> createPlayers(){
        ArrayList<Player> local = new ArrayList<>();
        int id = 0;
        for(String player:SetupActivity.players) {
            local.add(new Player(player, id, SetupActivity.point));
            id++;
        }
        return local;
    }

    public void showStandings(){
        Intent intent = new Intent(this, StandingsActivity.class);
        startActivity(intent);
    }

    private void makeThrow(int mult, int number){
        switch (darts){
            case 0:
                //set the score of the active player
                players.get(activePlayer).setScore(number * mult);

                //set the "first throw" text view
                firstThrow.setText(String.valueOf(number * mult));
                //set the score view
                scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));

                //reset button bull (here i should find a better solution
                btnBull.setText("Bull");

                //darts variable show ho many darts have been thrown, so it has do be increased by 1
                darts++;

                //reset multiplier
                multiplier = 1;
                break;
            case 1:
                players.get(activePlayer).setScore(number * mult);

                secondThrow.setText(String.valueOf(number * mult));
                scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));

                btnBull.setText("Bull");

                darts++;
                multiplier = 1;
                break;
            case 2:
                players.get(activePlayer).setScore(number * mult);

                thirdThrow.setText(String.valueOf(number * mult));
                scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));
                averageView.setText(String.format("%.2f", players.get(activePlayer).getAverage()));
                btnBull.setText("Bull");

                darts = 0;
                multiplier = 1;
                if(activePlayer < players.size() - 1)
                    activePlayer++;
                else
                    activePlayer = 0;

                //lock touch during delay
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                //delay of 2 Seconds before the View switches to next Player
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //here the new player is active and the text view needs to be reset
                        currentPlayer.setText(players.get(activePlayer).getPlayerName());
                        scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));
                        firstThrow.setText("-");
                        secondThrow.setText("-");
                        thirdThrow.setText("-");
                        averageView.setText(String.format("%.2f", players.get(activePlayer).getAverage()));

                        //get touch back after delay
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
                }, 2000);
                break;
        }
    }

    private void resetView(){
        darts = 0;
        //reset multiplier
        multiplier = 1;
        //reset the View
        currentPlayer.setText(players.get(activePlayer).getPlayerName());
        scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));
        firstThrow.setText("-");
        secondThrow.setText("-");
        thirdThrow.setText("-");
        averageView.setText(String.format("%.2f", players.get(activePlayer).getAverage()));
    }

    private void resetScore(){
        //this function only is called when the player exceeded the score
        switch (darts){
            case 0:
                break;
            case 1:
                //set the last throw to 0
                players.get(activePlayer).rewriteScore(1);
                players.get(activePlayer).eachThrow.set(players.get(activePlayer).eachThrow.size() - 1, 0);
                break;
            case 2:
                //set the last 2 throws to 0
                players.get(activePlayer).rewriteScore(1);
                players.get(activePlayer).eachThrow.set(players.get(activePlayer).eachThrow.size() - 1, 0);
                players.get(activePlayer).rewriteScore(2);
                players.get(activePlayer).eachThrow.set(players.get(activePlayer).eachThrow.size() - 2, 0);
                break;
        }
    }

    private void checkWin(int number) {
        //reset double and triple button color
        btnDouble.setBackgroundColor(Color.LTGRAY);
        btnTriple.setBackgroundColor(Color.LTGRAY);

        //in this case double out is not checked
        if (!SetupActivity.doubleOut.isChecked()) {
            //active player has won
            if (players.get(activePlayer).getScore() == number * multiplier) {
                openWinDialog();

                //active player exceeded the score
            } else if (players.get(activePlayer).getScore() < number * multiplier) {
                Toast.makeText(getBaseContext(), "Exceeded the Score!", Toast.LENGTH_SHORT).show();

                //reset the score
                resetScore();

                players.get(activePlayer).setScore(0);
                scoreView.setText("EXCEEDED");

                //make buttons untouchable
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                //delay 2 Seconds and display "exceeded" in the score view
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //jump to the next player
                        if (activePlayer < players.size() - 1)
                            activePlayer++;
                        else
                            activePlayer = 0;

                        //get touch back after delay
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        resetView();
                    }
                }, 2000);

            } else
                makeThrow(multiplier, number);
        }
        //Double out
        else{
            if (players.get(activePlayer).getScore() == number * multiplier && multiplier  == 2) {
                openWinDialog();
            //active player exceeded the score OR the player didnt finish with double out AND the player did not throw sub 2
            } else if (players.get(activePlayer).getScore() <= number * multiplier || (players.get(activePlayer).getScore() - number * multiplier == 1)) {
                Toast.makeText(getBaseContext(), "Exceeded the Score!", Toast.LENGTH_SHORT).show();

                //reset the score
                resetScore();

                players.get(activePlayer).setScore(0);
                scoreView.setText("EXCEEDED");

                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //jump to the next player
                        if (activePlayer < players.size() - 1)
                            activePlayer++;
                        else
                            activePlayer = 0;

                        //get touch back after delay
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        resetView();
                    }
                }, 2000);

            } else
                makeThrow(multiplier, number);
        }
    }

    private void undoThrow(){
        switch (darts){
            case 0:
                int step = 1;
                //if first player, jump to last
                if(activePlayer == 0)
                    step = (players.size() - 1) * - 1;

                activePlayer -= step;

                currentPlayer.setText(players.get(activePlayer).getPlayerName());

                //get the view of the previous player back
                firstThrow.setText(String.valueOf(players.get(activePlayer).eachThrow.get(players.get(activePlayer).eachThrow.size() - 3)));
                secondThrow.setText(String.valueOf(players.get(activePlayer).eachThrow.get(players.get(activePlayer).eachThrow.size() - 2)));
                thirdThrow.setText("-");

                //its the third throw, so darts = 2
                darts = 2;
                multiplier = 1;

                players.get(activePlayer).decreaseScore();
                scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));

                players.get(activePlayer).setAverage();
                averageView.setText(String.valueOf(players.get(activePlayer).getAverage()));
                break;
            case 1:
                firstThrow.setText("-");

                players.get(activePlayer).decreaseScore();
                scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));

                players.get(activePlayer).setAverage();
                averageView.setText(String.valueOf(players.get(activePlayer).getAverage()));

                darts--;
                multiplier = 1;
                break;
            case 2:
                secondThrow.setText("-");

                players.get(activePlayer).decreaseScore();
                scoreView.setText(String.valueOf(players.get(activePlayer).getScore()));

                darts--;
                multiplier = 1;
                break;
        }
    }

    private void openWinDialog(){
       AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle("Winner!!!")
                .setMessage(players.get(activePlayer).getPlayerName()
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
