package deckofcards;

import java.util.Scanner;

/**
 * This is a basic test class to show that I have a class that
 * takes input for number of players and cards per players.
 * Each player has a hand and interacts with the dealer. This
 * can be further implemented for the next labs
 *
 * @author dpoumakis
 * @date 2/8/2016
 */
public class Main
{
    public static void main(String[] args)
    {
        int numberOfPlayers;
        int numberOfCards;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter number of players: ");
        numberOfPlayers = scan.nextInt();
        
        System.out.print("Enter number of cards per player: ");
        numberOfCards = scan.nextInt();
        
        Dealer dealer = new Dealer(numberOfPlayers, numberOfCards);
        
        dealer.printPlayers();
    }
}
