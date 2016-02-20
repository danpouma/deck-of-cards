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
    
    public void play()
    {
        int rounds = 0;
        while (player1.hasCards() && player2.hasCards())
        {
            playRound();
            rounds++;
        }
        
        System.out.println("rounds: " + rounds);
        
        // Determine winner
        if (player1.handIsEmpty())
        {
            System.out.println("player2 won");
        }
        else
        {
            System.out.println("player1 won");
        }
    }
    
    public void playRound()
    {
        checkHands();
        
        Card card1 = player1.removeCard();
        Card card2 = player2.removeCard();
        
        if (card1.getFaceValue() == card2.getFaceValue())
        {
            System.out.println("War!");
            // I declare war...
            playWar();
        }
        else if (card1.getFaceValue() > card2.getFaceValue())
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
    
    // There is a bug here... Probably when they're equal?
    // woudl that mean this function will be recursive? lets try
    public void playWar()
    {
        // Add a catch for running out of cards
        checkHands();
        
        Card card2 = player1.removeCard();
        Card card3 = player2.removeCard();
        
        Card card4 = player1.removeCard();
        Card card5 = player2.removeCard();
        
        if (card4.getFaceValue() == card5.getFaceValue())
        {
            // need to pass it all these cards? hmm maybe have it return int?
            // 0 lost 1 won -- if 1 add cards?
            System.out.println("Playing war again!");
            //playWar();
        }
        else if (card4.getFaceValue() > card5.getFaceValue())
        {
            player1.addToWinnings(card2);
            player1.addToWinnings(card3);
            player1.addToWinnings(card4);
            player1.addToWinnings(card5);
        }
        else
        {
            player2.addToWinnings(card2);
            player2.addToWinnings(card3);
            player2.addToWinnings(card4);
            player2.addToWinnings(card5);
        }
    }
    
    public void checkHands()
    {
        if (player1.getHandCount() < 2)
        {
            player1.addWinningsToHand();
        }
        if (player2.getHandCount() < 2)
        {
            player2.addWinningsToHand();
        }
    }
    
     public static void main(String[] args)
    {
        War war = new War();
        
        war.play();
    }
}
