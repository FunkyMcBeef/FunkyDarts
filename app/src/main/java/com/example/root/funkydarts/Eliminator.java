package com.example.root.funkydarts;

import java.util.ArrayList;

public class Eliminator implements Comparable {

    String playerName;
    int id;
    int score = 0;
    int goal;
    double average = 0;

    ArrayList<Integer> eachThrow = new ArrayList<>();

    public Eliminator(String name, int id, int goal){
        this.playerName = name;
        this.id = id;
        this.goal = goal;
    }

    public String getName(){
        return playerName;
    }

    public int getId(){
        return id;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int points){
        eachThrow.add(points);
        this.score = eachThrowSum();
    }

    public int getGoal(){
        return goal;
    }

    public double getAverage(){
        return average;
    }

    public void eliminate() {
        for (int i = 0; i < eachThrow.size(); i++) {
            eachThrow.set(i, 0);
        }
        this.score = eachThrowSum();
    }

    public int eachThrowSum(){
        int sum = 0;
        for(int scr : eachThrow){
            sum = sum + scr;
        }
        return sum;
    }

    public String toString(){
        String str = "Score of " + this.getName() + " is: " + this.getScore();
        return str;
    }

    @Override
    public int compareTo(Object tmp) {
        Eliminator eliminator = (Eliminator) tmp;

        int comp = eliminator.getScore();
        return this.score - comp;
    }
}
