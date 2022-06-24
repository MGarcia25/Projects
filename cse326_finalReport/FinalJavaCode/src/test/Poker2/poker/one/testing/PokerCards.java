package test.Poker2.poker.one.testing;
public class PokerCards {

    public PokerCards[] cards;

    public void printDeck(PokerCards deck) {
    }

    enum Suit {
        Diamonds, Hearts, Clubs, Spades;

        private static final Suit[] suits = Suit.values();
        public static Suit getSuit(int s){
            return Suit.suits[s];
        }
    }


    enum Number {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
        //ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;


        private static final Number[] numbers = Number.values();
        public static Number getNumber(int n){
            return Number.numbers[n];
        }
    }

    private final Suit suit;
    private final Number number;

    //constructor
    public PokerCards(final Suit suit, final Number number){
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Number getNumber(){
        return this.number;
    }

    public String toString(){
        return suit + "_" + number;
    }
}

