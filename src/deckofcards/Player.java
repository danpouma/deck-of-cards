package deckofcards;

/**
 *
 * @author dpoumakis
 */
public class Player
{
    private Card[] hand;
    
    public Player(int numberOfCards, Card[] cards)
    {
        hand = new Card[numberOfCards];
        
        hand = cards;
    }
}
