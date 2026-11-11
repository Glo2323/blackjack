package com.pluralsight;

import java.util.ArrayList;

public class BlackJackApp {

    public static void main(String[] args) {

        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        Player[] players = new Player[1];

        Player player1 = new Player("Messi", hand1);
        Player player2 = new Player("Logan", hand2);




        dealCards(player1.getHand());
        dealCards(player2.getHand());




        int player1Score = player1.getHand().getValue();
        int player2Score = player2.getHand().getValue();

        boolean Bust = player1Score > 21;
        boolean Bust2 = player2Score > 21;

        if (player1Score > player2Score && !Bust) {
            System.out.println("Winner is " + player1.getName());
        }
        else if (player2Score > player1Score && !Bust2) {
            System.out.println("Winner is " + player2.getName());
        }
        else if (Bust) {
            System.out.println(player1.getName() + " Busted!!");
            System.out.println("Winner is " + player2.getName());

        }
        else if ( Bust2) {
            System.out.println(player2.getName() + " Busted!!");
            System.out.println("Winner is " + player1.getName());

        } else if (player1Score == player2Score) {
            System.out.println("Tied");

        }


    }

    public static void dealCards(Hand hand) {

        //create the deck
        Deck deck = new Deck();

        deck.shuffle();


//        Hand hand = new Hand();

        // deal 5 cards from the deck and add them to the hand
        for (int i = 0; i < 2; i++) {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            hand.deal(card);
        }
    }

}
