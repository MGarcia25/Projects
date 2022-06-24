package test.Poker2.poker.one.testing;

import test.Poker2.poker.one.testing.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Poker extends PokerDeck{
    public static int player;
    public PokerDeck deck = new PokerDeck();
    private ArrayList<ArrayList<PokerCards>> playerHand;  //actually accounts for ALL the players hands
    private ArrayList<PokerCards> stockpile;  //put down cards.....
    protected static PokerCards flop1;
    protected static PokerCards flop2;
    protected static PokerCards flop3;
    protected static PokerCards river;
    protected static PokerCards turn;
    boolean clockwiseDirection;
    private int cardRevealTurns;
    int playersTotal = 0;


    //constructor
    //public Poker(){
    //public Poker(int players, PokerCards card1, PokerCards card2){
    public Poker(int players){
        System.out.println("Number of Players: " + players);

        stockpile = new ArrayList<PokerCards>();
        playerHand = new ArrayList<ArrayList<PokerCards>>();
        player = 0;
        clockwiseDirection = true;


        //fills the hand
        for(int i = 0; i < players; i++){
            //creates a hand of poker cards
            //deck.drawCard() works an array (of 2 cards) and we then turn in into a list to finally make a hand of 2 cards
            ArrayList<PokerCards> hand = new ArrayList<PokerCards>(Arrays.asList(deck.drawCard(2)));

            //keep tracks of all the players hands!!
            playerHand.add(hand); //REMEMBER THIS GOES FOR ALL PLAYERS HANDS. ALL PLAYERS SHOULD BE GETTING 2 CARDS
        }
        startPoker();
    }


    public void startPoker(){
        System.out.println("START OF POKER GAME: \n");

        deck.printDeck(deck);

        // burns the first card
        PokerCards burn1 = deck.drawCard();
        System.out.println("Burn 1 Card");
        System.out.println(burn1.toString());

        // Difficulty drawing the flop and figuring out how to deal with it.
        /*ArrayList<PokerCards> flop = new ArrayList<PokerCards>(Arrays.asList(deck.drawCard(3)));  ////////option 1
        suitFlop1 = flop.get(0).getSuit();
        numberFlop1 = flop.get(0).getNumber();
        suitFlop2 = flop.get(1).getSuit();
        numberFlop2 = flop.get(1).getNumber();
        suitFlop3 = flop.get(2).getSuit();
        numberFlop3 = flop.get(2).getNumber();

        //Print the FLOP
        System.out.println("FLOP BOOTLEG");
        System.out.println(suitFlop1 + "_" + numberFlop1);
        System.out.println(suitFlop2 + "_" + numberFlop2);
        System.out.println(suitFlop3 + "_" + numberFlop3);*/

        /*PokerCards flop1 = deck.drawCard(); /////////////////////option 2
        PokerCards flop2 = deck.drawCard();
        PokerCards flop3 = deck.drawCard();*/
        flop1 = deck.drawCard();
        flop2 = deck.drawCard();
        flop3 = deck.drawCard();


        /*suitFlop1 = flop1.getSuit();
        numberFlop1 = flop1.getNumber();
        suitFlop2 = flop2.getSuit();
        numberFlop2 = flop2.getNumber();
        suitFlop3 = flop3.getSuit();
        numberFlop3 = flop3.getNumber();*/
        System.out.println("Flop 1 Card");
        System.out.println(flop1.toString());
        System.out.println("Flop 2 Card");
        System.out.println(flop2.toString());
        System.out.println("Flop 3 Card");
        System.out.println(flop3.toString());

        //System.out.println(flop1.toString() + " Test 101"); WORKS


        PokerCards burn2 = deck.drawCard();
        river = deck.drawCard();
        System.out.println("River Card");
        System.out.println(river.toString());

        PokerCards burn3 = deck.drawCard();
        turn = deck.drawCard();
        System.out.println("Turn Card");
        System.out.println(turn.toString());


        //stockpile.add(burn1);
        //stockpile.add(flop1);
        //stockpile.add(flop2);
        //stockpile.add(flop3);
    }

    public PokerCards getTopCard(){
        /*PokerCards tc1 = new PokerCards(suitFlop1, numberFlop1);
        PokerCards tc2 = new PokerCards(suitFlop2, numberFlop2);
        PokerCards tc3 = new PokerCards(suitFlop3, numberFlop3);
        return tc1;*/
        return new PokerCards(flop1.getSuit(), flop1.getNumber());
        //return Arrays.asList(suitFlop1, numberFlop1, suitFlop2, numberFlop2, suitFlop3, numberFlop3);
    }

    public PokerCards getTopCard2(){
        return new PokerCards(flop2.getSuit(), flop2.getNumber());
    }

    public PokerCards getTopCard3(){
        return new PokerCards(flop3.getSuit(), flop3.getNumber());
    }

    public ImageIcon getTopCardImage(){
        //return new ImageIcon(suitFlop1 + "-" + numberFlop1 + ".png");
        return new ImageIcon(flop1.toString() + ".png");

    }

    public boolean isGameOver(){
        if (cardRevealTurns == 3){
            return true;
        } else{
            return false;
        }
    }

    ///added last second////////////////////////////////
    public int getPlayer(){
        return player;
    }

    public int getCurrentPlayer(){
        return this.player;
    }

    /////////////////////////MUST EDIT IF WE WANT TO SEE OTHER PLAYERS HANDS POTENTIALLY uno uses strings (vid5)//////////////////////////////////
    //single array list of poker cards that is a particular players hand
    //public ArrayList<PokerCards> getPlayerHand(int pid){
    public ArrayList<PokerCards> getPlayerHand(int n){
        //int index = Arrays.asList(playerid).indexof(pid);
        int index = Arrays.asList(player).indexOf(n);
        return playerHand.get(index);
    }

    public int getPlayerHandSize(int play){
        return getPlayerHandSize(play);
    }


    //finds a particular card in a players(any players) hand
    public PokerCards getPlayerCard(int player, int choice){
        ArrayList<PokerCards> hand = getPlayerHand(player);
        return hand.get(choice);
    }

    //don't think we will need this
    /*public void setSuitCard(PokerCards.Suit suitCard){
        suitFlop1 = suitCard;
    }*/
    //////////////////////end of material of vid5///////////////////////////////////////////////////////


    //Potentially a method here to conduct comparisons///
    //in uno, this is where the game is conducted such as playing cards




    /*public static void main(String[] args){

    }*/

}
