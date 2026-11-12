package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackApp {

    public static void main(String[] args) throws InterruptedException {
        //?Title screen
        System.out.println("\nWelcome to Messi's BlackJack Table\n");
        Thread.sleep(500);
        //?Starting the game
        playBlackJack();

    }
    //!Creating a method to run/play the game
    public static void playBlackJack() throws InterruptedException {
        //?Creating my scanner
        Scanner input = new Scanner(System.in);

        //*Making the hands  for the players
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        //*Creating a group for the players
        Player[] players = new Player[1];
//        ArrayList<Player> playersList = new ArrayList<>();

        //*Creating the players
//        players(playersList);
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

            Thread.sleep(500);
            System.out.println("Dealing cards");
            Thread.sleep(500);

            //*Dealing carding out to the players
            dealCards(player1.getHand());
            dealCards(player2.getHand());

            //*getting the players card's info
            String player1Cards = player1.getHand().getCardDescription() + " of " + player1.getHand().getCardSuitDescription();
            String player2Cards = player2.getHand().getCardDescription() + " of " + player2.getHand().getCardSuitDescription();

            //*Displaying the users scores
            System.out.println(player1.getName() + "'s card value " + player1.getHand().getValue());

            System.out.println(player2.getName() + "'s card value  " + player2.getHand().getValue());

            //*Asking users if they want to hit
            System.out.println(player1.getName());
            hitOrStand(player1.getHand());
            if (player1.getHand().getValue() > 21) {
                System.out.println(player1.getName() + " Bust ");
            }

            //*Asking users if they want to hit
            System.out.println(player2.getName());
            hitOrStand(player2.getHand());
            if (player2.getHand().getValue() > 21) {
                System.out.println(player2.getName() + " Bust ");
            }

            //*getting the value of the players cards
            int player1Score = player1.getHand().getValue();
            int player2Score = player2.getHand().getValue();

            //*finding out whether the players busted
            boolean Bust = player1Score > 21;
            boolean Bust2 = player2Score > 21;

            //?Finding out who won by seeing who has the highest value without busting
            if (Bust && Bust2) {
                System.out.println("Both players Bust House Wins!!! ");
                System.out.println(player1.getName() + "'s cards " + player1Cards + " " + player1Score + "\n"
                        + player2.getName() + "'s cards " + player2Cards + " " + player2Score);
            }else if (player1Score > player2Score && !Bust) {
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

    //!Creating a method that creates the players
    public static void players(ArrayList<Player>players){
        //?Creating a Scanner
        Scanner input = new Scanner(System.in);
        Hand hand = new Hand();

        //*Asking users how many players are playing
        System.out.println("How many players?");
        int playersCount = input.nextInt();
        for (int i = 0; i < playersCount; i++) {
            System.out.println("What's your name");
            String playerName = input.next();
            players.add(new Player(playerName,hand));

        }

    }

    //!Creating a method to ask users
    public static void hitOrStand(Hand hand) {
        //?creating my scanner
        Scanner input = new Scanner(System.in);

        //create the deck
        Deck deck = new Deck();
        //Shuffling the deck
        deck.shuffle();

        boolean menuApp = true;
        while (menuApp){

        //*Asking if users wants to hit or stand
        System.out.println("Hit or Stand");
        String userInput = input.nextLine();
        if (userInput.equalsIgnoreCase("Hit")) {
            for (int i = 0; i < 1; i++) {
                // get a card from the deck
                Card card = deck.deal();
                // deal that card to the hand
                hand.deal(card);

            }
            System.out.println( "Card value " + hand.getValue());
        } else if (userInput.equalsIgnoreCase("Stand")) {
            menuApp = false;
        }
        }




    }

}
