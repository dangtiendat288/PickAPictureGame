package com.example.pickapicturegame;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    private String name;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Animals(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public static ArrayList<Animals> getMockData(){
        ArrayList<Animals> animals = new ArrayList<>();
        animals.add(new Animals("spider",R.drawable.spider));
        animals.add(new Animals("squid",R.drawable.squid));
        animals.add(new Animals("tiger",R.drawable.tiger));
        animals.add(new Animals("turkey",R.drawable.turkey));
        animals.add(new Animals("turtle",R.drawable.turtle));
        animals.add(new Animals("koala",R.drawable.koala));
        animals.add(new Animals("ladybug",R.drawable.ladybug));
        animals.add(new Animals("leopard",R.drawable.leopard));
        animals.add(new Animals("lizard",R.drawable.lizard));
        animals.add(new Animals("octopus",R.drawable.octopus));
        animals.add(new Animals("ox",R.drawable.ox));
        animals.add(new Animals("panda",R.drawable.panda));
        animals.add(new Animals("rabbit",R.drawable.rabbit));
        animals.add(new Animals("rat",R.drawable.rhinoceros));
        animals.add(new Animals("scorpion",R.drawable.scorpion));
        animals.add(new Animals("shark",R.drawable.shark));
        animals.add(new Animals("shrimp",R.drawable.shrimp));
        animals.add(new Animals("bear",R.drawable.bear));
        animals.add(new Animals("buffalo",R.drawable.buffalo));
        animals.add(new Animals("camel",R.drawable.camel));
        animals.add(new Animals("cat",R.drawable.cat));
        animals.add(new Animals("chipmunk",R.drawable.chipmunk));
        animals.add(new Animals("cow",R.drawable.cow));
        animals.add(new Animals("crab",R.drawable.crab));
        animals.add(new Animals("cricket",R.drawable.cricket));
        animals.add(new Animals("crocodile",R.drawable.crocodile));
        animals.add(new Animals("dog",R.drawable.dog));
        animals.add(new Animals("dolphin",R.drawable.dolphin));
        return animals;
    }
}
