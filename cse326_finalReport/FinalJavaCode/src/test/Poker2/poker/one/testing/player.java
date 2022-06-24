package test.Poker2.poker.one.testing;


class Player {
    public PokerCards card1;
    public PokerCards card2;

    public Player() {
        //setCard1(PokerCards.Suit.Clubs, PokerCards.Number.Two);
        //setCard2(PokerCards.Suit.Clubs, PokerCards.Number.Three);
    }

    public void setCard2(PokerCards.Suit clubs, PokerCards.Number three) {
    }

    public void setCard1(PokerCards.Suit clubs, PokerCards.Number two) {
    }

    public Player(PokerCards card1, PokerCards card2){
        setCard1(card1);
        setCard2(card2);
    }
    public PokerCards getCard2() {
        return card2;
    }

    public Player setCard2(PokerCards card2) {
        this.card2 = card2;
        return null;
    }

    public PokerCards getCard1() {
        return card1;
    }

    public Player setCard1(PokerCards card1) {
        this.card1 = card1;
        return null;
    }

    public void PrintHand(){
        card1.toString();
        card2.toString();
    }
}
