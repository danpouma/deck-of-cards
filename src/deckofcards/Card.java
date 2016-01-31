package deckofcards;

class Card
{
    public static final int CLUBS = 1;
    public static final int DIAMONDS = 2;
    public static final int HEARTS = 3;
    public static final int SPADES = 4;

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 1;

    private int suit;
    private int face;
    
    // Track number of cards... Used for ID.
    private int id;
    private static int counter = 0;

    // Is this even worth having? perhaps make
    // an algorithim that wont give repeats
    public Card()
    {
        this.id = counter++;
        this.face = ACE;
        this.suit = SPADES;
    }

    public Card(int face, int suit)
    {
        this.id = counter++;
        this.face = face;
        this.suit = suit;
    }
    //equals method
    public boolean equals(Card other)
    {
        boolean suitMatched = (this.suit == other.getSuitValue());
        boolean faceMatched = (this.face == other.getFaceValue());
        boolean isEqual = (suitMatched && faceMatched);
        
        return isEqual;
    }

    public boolean faceEquals(Card other)
    {
        return this.face == other.getFaceValue();
    }

    //get methods for suit and face
    public int getSuitValue()
    {
        return suit;
    }

    public int getFaceValue()
    {
        return face;
    }

    //set methods for suit and face
    public void setSuit(int suit)
    { //test for valid data
        if (suit == CLUBS || suit == DIAMONDS || suit == HEARTS || suit == SPADES)
        {
            this.suit = suit;
        } 
        else
        {
            //the input is invalid
        }
    }

    public void setFace(int face)
    {
        if (face >= 2 && face <= 10)
        {
            this.face = face;
        } 
        else if (face == ACE || face == KING || face == QUEEN || face == JACK)
        {
            this.face = face;
        } 
        else
        {
            ; //the input is invalid
        }
    }

    //convert the suit value to a string
    public String getSuitString()
    {
        String s = "";
        switch (suit)
        {
            case CLUBS:
                s = "Clubs";
                break;
            case DIAMONDS:
                s = "Diamonds";
                break;
            case HEARTS:
                s = "Hearts";
                break;
            case SPADES:
                s = "Spades";
                break;
            default:
                ;
        }
        return s;
    }

    //convert the face valie to a string
    public String getFaceString()
    {
        String f = ""; //initialize with empty string
        switch (face)
        {
            //if the value is 2 - 10
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                f = face + "";
                break;
            //if it is a face card
            case JACK:
                f = "Jack";
                break;
            case QUEEN:
                f = "Queen";
                break;
            case KING:
                f = "King";
                break;
            case ACE:
                f = "Ace";
                break;
            default:
                System.out.println("Something when wrong. This should never print");
                break;
        }
        return f;
    }
    
    // Accessor/mutator for id
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }

    //toString method
    @Override
    public String toString()
    {
        String s;
        s = getFaceString() + " of " + getSuitString();
        return s;
    }

}
