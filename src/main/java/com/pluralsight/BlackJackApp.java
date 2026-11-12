package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackApp {

    public static void main(String[] args) {
        //?Starting the game
       playBlackJack();

    }
    public static void playBlackJack() {
        //?Creating my scanner
        Scanner input = new Scanner(System.in);

        //*Making the hands  for the players
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        //*Creating a group for the players
        Player[] players = new Player[1];

        //*Creating the players
        Player player1 = new Player("name", hand1);
        Player player2 = new Player("name", hand2);

        //?Asking the user for their name
        System.out.println("Enter Player 1's name");
        //?Storing the players name
        player1.setName(input.next());
        //?Asking the user for their name
        System.out.println("Enter Player 2's name");
        //?Storing the players name
        player2.setName(input.next());

        input.nextLine();
        //?Running the game
        boolean menuApp = true;
        while (menuApp) {

            //*Dealing carding out to the players
            dealCards(player1.getHand());
            dealCards(player2.getHand());

            //*getting the value of the players cards
            int player1Score = player1.getHand().getValue();
            int player2Score = player2.getHand().getValue();
            //*finding out whether the players busted
            boolean Bust = player1Score > 21;
            boolean Bust2 = player2Score > 21;
            //*getting the players card's info
            String player1Cards = player1.getHand().getCardDescription() + " of " + player1.getHand().getCardSuitDescription();
            String player2Cards = player2.getHand().getCardDescription() + " of " + player2.getHand().getCardSuitDescription();

            //?Finding out who won by seeing who has the highest value without busting
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
            //?Clearing the players hands
            unDealCards(player1.getHand());
            unDealCards(player2.getHand());

            //*Asking users if they want to play again
            System.out.println("\nDo you wanna play again\n");
            String playAgain = input.nextLine();
            if (playAgain.equalsIgnoreCase("No")) {
                menuApp = false;
            }
        }
    }

    //!Creating a method to deal the  cards
    public static void dealCards(Hand hand) {
        //create the deck
        Deck deck = new Deck();
        //Shuffling the deck
        deck.shuffle();
        // deal 2 cards from the deck and add them to the hand
        for (int i = 0; i < 2; i++) {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            hand.deal(card);
        }
    }
    //!Creating a method to clear the players hand
    public static void unDealCards(Hand hand) {
        // deal 5 cards from the deck and add them to the hand
        while (hand.getSize() != 0) {
            //clearing the cards from the hand
            hand.unDeal();
        }
    }

}
