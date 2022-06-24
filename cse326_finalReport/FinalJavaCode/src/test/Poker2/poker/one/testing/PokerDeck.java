package test.Poker2.poker.one.testing;
/* 4 suits, Diamond, Hearts, Clubs, Spades.
Total of 13 cards per suit. Ace, 1-10, Jack, Queen, King
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class PokerDeck {
    public PokerCards[] cards;
    private int cardsInTheDeck;

    //constructor
    public PokerDeck(){
        cards = new PokerCards[52];
        reset();
    }
    //

    public void reset(){ //potential rename to reshuffle

        PokerCards.Suit[] suits = PokerCards.Suit.values();
        cardsInTheDeck = 0;

        //starts at zero and iterates (starting at Diamonds). Fills in the values of the suit with the current value
        // in the Suits array
        int i;
        for(i = 0; i < suits.length; i++){
            PokerCards.Suit suit = suits[i];
            cards[cardsInTheDeck++] = new PokerCards(suit, PokerCards.Number.Ace); //creates a Diamond Ace value of 1
            int j;
            for(j = 1; j < 13; j++){
                cards[cardsInTheDeck++] = new PokerCards(suit, PokerCards.Number.getNumber(j)); //fills in the rest of the deck(Two through AceElev)
                //System.out.println(cards[cardsInTheDeck] + "test 33 pokerdeck \n");
            }
        }
    }

    /*public void replaceDeckWith(ArrayList<PokerCards> cards){
        this.cards = cards.toArray(new PokerCards(cards.si))
    }*/

    /*
    "replace the deck with this arrayList." In uno, have the main deck you draw cards from, but when you put cards down,
    you have a stockpile of cards. When the deck runs out, replace the current deck with the stockpile deck.
     */
    //DIEGO NOTE: I dont think we need this since we reshuffle the entirety of the deck in poker.
    public void replaceDeckWith(ArrayList<PokerCards> cards){
        this.cards = cards.toArray(new PokerCards[cards.size()]); //makes the ArrayList of cards into a normal array of cards.
        this.cardsInTheDeck = this.cards.length; //the amount of cards in the deck is the length of the array
        //the stockpile is turned into the new deck?
    }

    public void shuffle(){

        int a = cards.length;
        Random random = new Random();
        int i;
        for (i = 0; i < cards.length; i++){

            //Get a random index of the array passed the current index
            //... the argument is an exclusive bound
            // Swap the random element with the present element
            //should work fine*********
            int randomValue = i + random.nextInt(a - i);
            PokerCards randomCard = cards[randomValue];   //Uno randomCard =   ****don't know where Uno came from****
            cards[randomValue] = cards[i];
            cards[i] = randomCard;                          // = randomCard
        }
    }

    //checks if the deck is empty, will not happen in Poker but blackjack might be useful to have this
    public boolean isEmpty(){
        return cardsInTheDeck == 0;
    }

    //this method ties in the previous boolean isEmpty() no use in Poker, but maybe in Blackjack
    public PokerCards drawCard() throws IllegalArgumentException{ //in uno draw card if you can't play card
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot Draw since the deck is EMPTY");
        }
        return cards[--cardsInTheDeck];
    }


    //uno plus two plus 4
    public PokerCards[] drawCard(int n){
        //draw negative cards? Perhaps unnecessary
        if(n < 0){
            throw new IllegalArgumentException("Error in drawCard 83");
        }

        //out of cards.
        if(n > cardsInTheDeck){
            throw new IllegalArgumentException("Line 95 error PokerDeck");
        }

        PokerCards[] ret = new PokerCards[n];
        int i;
        for(i = 0; i < n; i++){
            try{
                System.out.println(ret + "line 95 PokerDeck\n");
                ret[i] = cards[--cardsInTheDeck]; //fill array with the cards from the top of the deck  /////////////////ERROR OCCURS HERE
            }catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            System.out.println(ret + "line 100 PokerDeck");
        }
        return ret;
    }
    public void printDeck(PokerDeck deck){
        for(int x = 0; x < cards.length; x++){
            System.out.print(x + ":");
            System.out.print(deck.cards[x].toString()+ "\n");
        }
    }

    public ArrayList<Player> dealCards(PokerDeck deck, int players){
        ArrayList<Player> dealing = new ArrayList<Player>();
        for(int x = 0; x < players; x++){
            dealing.add(new Player());
        }
        int x = 0;
        for(Player player : dealing) {
            player.setCard1(deck.cards[x]);
            player.setCard2(deck.cards[x + players]);
            x++;
        }
        System.out.println(x);
        return dealing;
    }


    public ImageIcon drawCardImage() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("Deck is EMPTY");
        }
        //every card in the deck will get an image and add the name of the image "Diamond_Ace.png"
        return new ImageIcon(cards[--cardsInTheDeck].toString() + ".png");   //returns the card with the name and suit

    }


}