package deckofcards;

/**
 *
 * @author dpoumakis
 */
public class Dealer
{
    // Should this be public static?
    // perhaps make it private or privates static
    public static Deck deck = new Deck();
    
    private Player[] players;
    
    public Dealer(int numberOfPlayers, int numberOfCards)
    {
        players = new Player[numberOfPlayers];
        
        for (int i = 0; i < numberOfPlayers; i++)
        {
            // Put number of cards per person in cards
            Card[] cards = new Card[numberOfCards];
            for (int j = 0; j < numberOfCards; j++)
            {
                cards[j] = deck.getTopCard();
            }
            // Create new player and pass them their hand
            players[i] = new Player(numberOfCards, cards);
        }
    }
    
    public void printPlayers()
    {
        for (int i = 0; i < players.length; i++)
        {
            System.out.println("Player" + i);
            System.out.println(players[i]);
        }
    }
}
