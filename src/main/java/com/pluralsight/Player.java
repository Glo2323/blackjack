package com.pluralsight;

import java.util.ArrayList;

public class Player {

    private String name;
    private Hand hand;
    private ArrayList<Card> cards;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = new Hand();
    }

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
