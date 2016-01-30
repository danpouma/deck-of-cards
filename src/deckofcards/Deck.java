package deckofcards;

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

        //initaliz 52 cards in array
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

    //swap two cards at random a random number of times
    public void shuffle()
    {
        int numOfSwaps = (int) (Math.random() * 100 + 25);
        for (int i = 0; i < numOfSwaps; i++)
        {
            swapRandom();
        }
        //reset the top card marker 
        //(actually the last card in array)
        topCard = cards[numCardsLeft - 1];
    }

    //private helper function for shuffle
    //no need to make public, only used for shuffle
    //swap two random cards in the array
    private void swapRandom()
    {
        //pick two random array index
        int a = (int) (Math.random() * 52);
        int b = (int) (Math.random() * 52);

        //swap one with the other
        Card temp = cards[a];
        cards[a] = cards[b];
        cards[b] = temp;
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
