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
    
    @Override
    public String toString()
    {
        String s = "Hand: \n";
        for (int i = 0; i < hand.length; i++)
        {
            s = s + hand[i] + "\n";
        }
        return s;
    }
}
