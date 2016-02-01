package deckofcards;

/**
 *
 * @author dpoumakis
 */
public class Dealer
{
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
}
