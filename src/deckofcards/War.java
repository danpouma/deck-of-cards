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
    private Stack<Card> table;
    
    // Variables for testing
    private int cardCount;
    private int warCount;
    private int player1Wins;
    private int player2Wins;
    private int cardsTrashed;
    private Stack<Card> trash;
    
    public War()
    {
        // Variables for testing initialization
        cardCount = 0;
        warCount = 0;
        player1Wins = 0;
        player2Wins = 0;
        cardsTrashed = 0;
        trash = new Stack<>();
        
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
        
        table = new Stack<>();
    }
    
    public void play()
    {
        int roundCount = 0;
        while (player1.hasCards() && player2.hasCards())
        {
            playRound();
            roundCount++;
        }
        
        
        
        
        
        System.out.println("Rounds: " + roundCount);
        System.out.println("p1wins: " + player1Wins);
        System.out.println("p1size: " + player1.getHandCount());
        System.out.println("p1pool: " + player1.getWinningsCount());
        System.out.println("p2wins: " + player2Wins);
        System.out.println("p2size: " + player2.getHandCount());
        System.out.println("p2pool: " + player2.getWinningsCount());
        System.out.println("#trash: " + cardsTrashed);
        System.out.println("tSize : " + trash.size());
        System.out.println("table#: " + table.size());
        System.out.println("#wars : " + warCount);
        
        // Use this total up the cards in play
        cardCount += player1.getHandCount();
        cardCount += player1.getWinningsCount();
        
        cardCount += player2.getHandCount();
        cardCount += player2.getWinningsCount();
        
        cardCount += trash.size();
        cardCount += table.size();
        
        // Output card total
        System.out.println("count: " + cardCount);
        
        
        // Determine then output winner
        if (player1.handIsEmpty())
        {
            System.out.println("player2 wins");
        }
        else
        {
            System.out.println("player1 wins");
        }
    }
    
    public void checkHands()
    {
        if (player1.handIsEmpty())
        {
            player1.addWinningsToHand();
        }
        
        if (player2.handIsEmpty())
        {
            player2.addWinningsToHand();
        }
    }
    
    public void playRound()
    {
        if (player1.handIsEmpty() || player2.handIsEmpty())
        {
            System.out.println("hand empty playRound");
            checkHands();
        }
        
        // Get top cards from players
        Card card1 = player1.removeCard();
        Card card2 = player2.removeCard();
        
        // Add cards to table stack
        table.push(card1);
        table.push(card2);
        
        // If cards are equal clear table
        if (card1.getFaceValue() == card2.getFaceValue())
        {
            if (player1.handIsEmpty() || player2.handIsEmpty())
            {
                System.out.println("hand empty ==");
            }
            playWar();
            /*
            // Instead of playing war... trash the cards
            for (int card = 0; card < table.size(); card++)
            {
                cardsTrashed++;
                trash.push(table.pop());
            }
            */
        }
        else if (card1.getFaceValue() > card2.getFaceValue())
        {
            player1Wins++;
            
            for (int card = 0; card < table.size(); card++)
            {
                player1.addToWinnings(table.pop());
            }
        }
        else
        {
            player2Wins++;
            
            for (int card = 0; card < table.size(); card++)
            {
                player2.addToWinnings(table.pop());
            }
        }
    }
    
    public void playWar()
    {
        if (player1.handIsEmpty() || player2.handIsEmpty())
        {
            System.out.println("hand empty war");
            checkHands();
        }
        
        warCount++;
        
        // Each player puts 3 cards down
        for (int card = 0; card < 3; card++)
        {
            // Ohhh.. its loop 3 times.. maybe that's it!
            // Woo this fixes it
            checkHands();
            table.push(player1.removeCard());
            table.push(player2.removeCard());
        }
        
        // Would it be valid to playRound() again?
        playRound();
    }
    
    public static void main(String[] args)
    {
        War war = new War();
        
        war.play();
        
    }
}
