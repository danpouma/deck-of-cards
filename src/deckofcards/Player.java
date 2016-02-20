package deckofcards;

import java.util.Stack;

/**
 *
 * @author dpoumakis
 */
public class Player
{
    private int id;
    private Stack<Card> hand;
    private Stack<Card> winnings;
    
    private static int counter;
    
    public Player(Stack<Card> hand)
    {
        id = counter++;
        this.hand = hand;
        winnings = new Stack<>();
    }
    
    public void addCard(Card card)
    {
        hand.push(card);
    }
    
    public Card removeCard()
    {
        return hand.pop();
    }
    
    public void addToWinnings(Card card)
    {
        winnings.push(card);
    }
    
    public Card removeFromWinnings()
    {
        return winnings.pop();
    }
    
    public int getCardCount()
    {
        return hand.size();
    }
    
    
    
    /*
    @Override
    public String toString()
    {
        // Will need to figure out how to print stack
        String s = "Hand: \n";
        for (int i = 0; i < hand.size(); i++)
        {
            //s = s + hand[i] + "\n";
        }
        return s;
    }
    */
}
