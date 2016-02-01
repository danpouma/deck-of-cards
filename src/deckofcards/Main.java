package deckofcards;

import java.util.Scanner;

/**
 *
 * @author dpoumakis
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
        
    }
}
