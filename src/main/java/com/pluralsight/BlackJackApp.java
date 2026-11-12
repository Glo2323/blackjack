package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackApp {

    public static void main(String[] args) {

       playBlackJack();

    }
    public static void playBlackJack() {
        Scanner input = new Scanner(System.in);

        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        Player[] players = new Player[1];

        Player player1 = new Player("name", hand1);
        Player player2 = new Player("name", hand2);

        System.out.println("Enter Player 1's name");
        player1.setName(input.next());

        System.out.println("Enter Player 2's name");
        player2.setName(input.next());

        input.nextLine();

        boolean menuApp = true;
        while (menuApp) {


            dealCards(player1.getHand());
            dealCards(player2.getHand());


            int player1Score = player1.getHand().getValue();
            int player2Score = player2.getHand().getValue();

            boolean Bust = player1Score > 21;
            boolean Bust2 = player2Score > 21;

            String player1Cards = player1.getHand().getCardDescription() + " of " + player1.getHand().getCardSuitDescription();
            String player2Cards = player2.getHand().getCardDescription() + " of " + player2.getHand().getCardSuitDescription();

            if (player1Score > player2Score && !Bust) {
                System.out.println(player1.getName() + "'s cards " + player1Cards + " " + player1Score + "\n"
                        + player2.getName() + "'s cards " + player2Cards + " " + player2Score);
                System.out.println("Winner is " + player1.getName());
            } else if (player2Score > player1Score && !Bust2) {
                System.out.println(player1.getName() + "'s cards " + player1Cards + " " + player1Score + "\n"
                        + player2.getName() + "'s cards " + player2Cards + " " + player2Score);
                System.out.println("Winner is " + player2.getName());
            } else if (Bust) {
                System.out.println(player1.getName() + "'s cards " + player1Cards + " " + player1Score + "\n"
                        + player2.getName() + "'s cards " + player2Cards + " " + player2Score);
                System.out.println(player1.getName() + " Busted!!");
                System.out.println("Winner is " + player2.getName());

            } else if (Bust2) {
                System.out.println(player1.getName() + "'s cards " + player1Cards + " " + player1Score + "\n"
                        + player2.getName() + "'s cards " + player2Cards + " " + player2Score);
                System.out.println(player2.getName() + " Busted!!");
                System.out.println("Winner is " + player1.getName());

            } else if (player1Score == player2Score) {
                System.out.println(player1.getName() + "'s cards " + player1Cards + " " + player1Score + "\n"
                        + player2.getName() + "'s cards " + player2Cards + " " + player2Score);
                System.out.println("Tied");

            }
            unDealCards(player1.getHand());
            unDealCards(player2.getHand());

            System.out.println("Do you wanna play again");
            String playAgain = input.nextLine();
            if (playAgain.equalsIgnoreCase("No")) {
                menuApp = false;
            }
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

    public static void unDealCards(Hand hand) {


        // deal 5 cards from the deck and add them to the hand
        while (hand.getSize() != 0) {
            // get a card from the deck

            // deal that card to the hand
            hand.unDeal();
        }
    }

}
