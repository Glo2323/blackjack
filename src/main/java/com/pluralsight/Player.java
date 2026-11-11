package com.pluralsight;

public class Player {

    private String name;
    private Hand hand;


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
