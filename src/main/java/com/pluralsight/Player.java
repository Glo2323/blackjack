package com.pluralsight;

import java.util.ArrayList;

public class Player {
    //?Attributes for the object
    private String name;
    private Hand hand;
    private ArrayList<Card> cards;
    //!Creating my object
    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = new Hand();
    }
    //?Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public Hand setHand(Hand hand) {
        this.hand = hand;
        return hand;
    }



}
