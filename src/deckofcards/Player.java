package deckofcards;

/**
 *
 * @author dpoumakis
 */
public class Player
{
    private int id;
    private Card[] hand;
    
    private static int counter;
    
    public Player(int numberOfCards, Card[] cards)
    {
        this.id = counter++;
        
        hand = new Card[numberOfCards];
        
        hand = cards;
    }
}
