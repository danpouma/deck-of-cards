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
    
    public War()
    {
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
    }
    
    public void playRound()
    {
        //System.out.println("Player1 hand count: " + player1.getCardCount());
        //System.out.println("Player2 hand count: " + player2.getCardCount());
        
        Card card1 = player1.removeCard();
        Card card2 = player2.removeCard();
        
        //System.out.println(card1);
        //System.out.println(card2);
        
        if (card1.getFaceValue() > card2.getFaceValue())
        {
            //System.out.println("Player 1 wins round");
            player1.addToWinnings(card1);
            player1.addToWinnings(card2);
        }
        else
        {
            //System.out.println("Player 2 wins round");
            player2.addToWinnings(card1);
            player2.addToWinnings(card2);
        }
    }
    
    public int getPlayerScore(Player player)
    {
        int score = 0;
        
        Stack<Card> winnings = player.getWinnings();
        
        for (int card = 0; card < player.getWinningsCount(); card++)
        {
            score += winnings.pop().getFaceValue();
        }
        
        return score;
    }
    
    public void determineWinner()
    {
        if (getPlayerScore(player1) > getPlayerScore(player2))
        {
            System.out.println("Player1 wins");
        }
        else
        {
            System.out.println("Player2 wins");
        }
    }
    
    public static void main(String[] args)
    {
        War war = new War();
        
        for (int i = 0; i < 26; i++)
        {
            war.playRound();
        }
        
        war.determineWinner();
    }
}
