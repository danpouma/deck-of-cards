package deckofcards;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author dpoumakis
 */
public class War
{
    // Should this be public static?
    // perhaps make it private or privates static
    public static Deck deck;
    
    private Player player1;
    private Player player2;
    
    public War()
    {
        deck = new Deck();
        
        Stack<Card> hand1 = new Stack<>();
        Stack<Card> hand2 = new Stack<>();
        
        // To make this work had to modify getTopCard.
        // make it didn't break anything!
        for (int card = 0; card < 26; card++)
        {
            hand1.push(deck.getTopCard());
            hand2.push(deck.getTopCard());
        }
        
        player1 = new Player(hand1);
        player2 = new Player(hand2);
        
        System.out.println("Player1 hand count: " + player1.getCardCount());
        
        System.out.println("Player2 hand count: " + player2.getCardCount());
    }
    
    public void playRound()
    {
        Card card1 = player1.removeCard();
        Card card2 = player2.removeCard();
        
        System.out.println(card1);
        System.out.println(card2);
        
        if (card1.getFaceValue() > card2.getFaceValue())
        {
            System.out.println("Player 1 wins round");
        }
        else
        {
            System.out.println("Player 2 wins round");
        }
        
        // Add card1 and card2 to winners winnings
    }
    
    public static void main(String[] args)
    {
        War war = new War();
        
        war.playRound();
        
        
    }
}
