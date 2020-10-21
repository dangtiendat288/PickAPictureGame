package com.example.pickapicturegame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;

    public static List<Player> getMockData() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Dat",1));
        players.add(new Player("Lem",2));
        players.add(new Player("A",3));
        players.add(new Player("B",4));
        players.add(new Player("C",5));
        players.add(new Player("D",3));
        players.add(new Player("E",654));
        players.add(new Player("F",12321));
        players.add(new Player("G",6432));
        players.add(new Player("H",322));
        players.add(new Player("I",2112));
        players.add(new Player("K",2120));
        players.add(new Player("L",200));
        return  players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
