package com.example.root.funkydarts;

import java.util.ArrayList;

public class Player {

    String playerName;
    int id;
    int score;
    //to calculate the average we need a variable which adds up the throws
    int reverseScore = 0;
    double average = 0;

    //save every shot in array list for undo purposes
    ArrayList<Integer> eachThrow = new ArrayList<>();

    public Player(String playerName, int id, int score){
        this.playerName = playerName;
        this.id = id;
        this.score = score;
    }

    public String getPlayerName(){
        return playerName;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(){
        if(eachThrow.size() >= 3){
            average = (double) reverseScore / (eachThrow.size() / 3);
        }
    }

    public int getScore(){
        return score;
    }

    public void setScore(int scr){
        eachThrow.add(scr);
        setReverseScore();

        this.score = score - eachThrow.get(eachThrow.size() - 1);

        setAverage();
    }

    public void rewriteScore(int index){
        this.score = score + eachThrow.get(eachThrow.size() - index);
    }

    public void decreaseScore(){
        this.score = score + eachThrow.get(eachThrow.size() - 1);

        reverseScore = reverseScore - eachThrow.get(eachThrow.size() - 1);
        //remove last item from list
        eachThrow.remove(eachThrow.size() - 1);
    }

    public void setReverseScore(){
        reverseScore = 0;
        for(int shot : eachThrow){
            reverseScore = reverseScore + shot;
        }
    }

    public String toString(){
        String standing = String.format(playerName + ":\t\tScore: "+score+"\t\tAverage: %.2f", average);
        return standing;
    }

}
