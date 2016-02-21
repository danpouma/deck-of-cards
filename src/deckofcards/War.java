package deckofcards;

import java.util.Stack;

/**
 * 
 * @author dpoumakis
 */
public class War
{
    private Deck deck;  
    private Player player1;
    private Player player2;
    private Stack<Card> table;
    
    // Variables for testing
    private int player1Wins;
    private int player2Wins;
    private int cardsTrashed;
    private Stack<Card> trash;
    
    public War()
    {
        // Variables for testing initialization
        player1Wins = 0;
        player2Wins = 0;
        cardsTrashed = 0;
        trash = new Stack<>();
        
        deck = new Deck();
        
        Stack<Card> hand1 = new Stack<>();
        Stack<Card> hand2 = new Stack<>();
        
        // To make this work had to modify getTopCard.
        // make sure it didn't break anything!
        for (int card = 0; card < 26; card++)
        {
            hand1.push(deck.getTopCard());
            hand2.push(deck.getTopCard());
        }
        
        player1 = new Player(hand1);
        player2 = new Player(hand2);
        
        table = new Stack<>();
    }
    
    public void play()
    {
        int roundCount = 0;
        while (player1.hasCards() && player2.hasCards())
        {
            playRound();
            roundCount++;
        }
        
        System.out.println("Rounds: " + roundCount);
        System.out.println("p1wins: " + player1Wins);
        System.out.println("p1size: " + player1.getHandCount());
        System.out.println("p2wins: " + player2Wins);
        System.out.println("p2size: " + player2.getHandCount());
        System.out.println("#trash: " + cardsTrashed);
        System.out.println("tSize : " + trash.size());
        System.out.println("table#: " + table.size());
    }
    
    public void playRound()
    {
        // Get top cards from players
        Card card1 = player1.removeCard();
        Card card2 = player2.removeCard();
        
        // Add cards to table stack
        table.push(card1);
        table.push(card2);
        
        // If cards are equal clear table
        if (card1.getFaceValue() == card2.getFaceValue())
        {
            for (int card = 0; card < table.size(); card++)
            {
                cardsTrashed++;
                trash.push(table.pop());
            }
        }
        else if (card1.getFaceValue() > card2.getFaceValue())
        {
            player1Wins++;
            
            for (int card = 0; card < table.size(); card++)
            {
                player1.addToWinnings(table.pop());
            }
        }
        else
        {
            player2Wins++;
            
            for (int card = 0; card < table.size(); card++)
            {
                player2.addToWinnings(table.pop());
            }
        }
    }
    
    public static void main(String[] args)
    {
        War war = new War();
        
        war.play();
        
    }
}
