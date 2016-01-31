package deckofcards;

import java.util.Random;

class Deck
{
    private Card[] cards;
    private int numCardsLeft;
    private Card topCard;

    public Deck()
    {
        //set up 52 card array
        numCardsLeft = 52;
        cards = new Card[numCardsLeft];

        //initalize 52 cards in array
        // Make this better by using % operator?
        // this works for now tho.
        int count = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int value = 1; value <= 13; value++)
            {
                cards[count] = new Card(value, suit);
                count++;
            }
        }
        //shuffle the array
        shuffle();
        //topCard set in shuffle
    }
    
    // use random num and shuffle every single card
    public void shuffle()
    {
        Card[] shuffleDeck = new Card[numCardsLeft];
        int count = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int value = 1; value <= 13; value++)
            {
                shuffleDeck[count] = new Card(value, suit);
                count++;
            }
        }
        
        Random rndgen = new Random(System.currentTimeMillis());
        
        // maybe able to make this work better..?
        int numberOfCards = numCardsLeft;
        
        /* 
        Store random card into new deck
        Take last card in cards and move to that random location
        Each loop generate random number based on # of cards
        This should shuffle EACH card
        */
        for(int i = 0; i < numCardsLeft; i++)
        {
            //Generate next integer 0 to numCardsLeft
            int randNum = rndgen.nextInt(numberOfCards);
            
            // Store card to swap
            shuffleDeck[i] = cards[randNum];
            
            // Reset top card marker
            topCard = cards[numberOfCards-1];
            
            cards[randNum] = topCard;
            
            numberOfCards--;
  
        }
        
        // Copy shuffled deck into cards...
        cards = shuffleDeck;
        
        // Test if there is duplicates
        // if message doesn't print... youre good!
        for (int i = 0; i < 52; i++)
        {
            for (int j = 0; j < 52; j++)
            {
                if (cards[i] == cards[j] && i != j)
                {
                    System.out.println("duplicate...");
                }
            }
        }
    }
    
    public Card getTopCard()
    {
        Card oldTopCard;
        //change the number of cards

        numCardsLeft--;
        //set handle to top card
        oldTopCard = topCard;
        //set the topCard handle to the next card

        topCard = cards[numCardsLeft - 1];

        //return the oldTopCard
        return oldTopCard;
    }

    public int getNumCardsLeft()
    {
        return numCardsLeft;
    }

    @Override
    public String toString()
    {
        String s = "Deck: \n";
        for (int i = 0; i < numCardsLeft; i++)
        {
            s = s + cards[i] + "\n";
        }
        return s;
    }

}
