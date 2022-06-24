package test.Poker2.poker.one.testing;

import test.Poker2.poker.one.testing.Poker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;


public class PokerTable extends JComponent {
    public Poker poker;
    private int numPlay = 0;
    public static int cardsRevealNum = 0;
    private static boolean gameOver;
    //PopUp window;
    String path = "Poker\\GreenTable.jpg";

    /*public String[] getPID(){

    }*/


    public boolean getGameOver(){
        return gameOver;
    }

    //constructor
    //public PokerTable(int players, PokerCards card1, PokerCards card2){
    public PokerTable(int players){
        numPlay = players;
        setPreferredSize(new Dimension(1000,720));
        addMouseListener(new PlayHandler());
        gameOver = false;
        repaint();
        //poker = new Poker(numPlay);
    }



    private class PlayHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            //boolean bool = cardReveal(); //calls cardReveal where the number of cards revealed is incremented
            //System.out.println("PokerTable 47");
            /*if (bool == true) {
                if (cardsRevealNum == 4) {  //once all cards are reveal, start a new game
                    gameOver = true;
                    repaint();
                } else {
                    gameOver = false;
                    repaint();
                }
            }*/

        }
    }



    public static boolean cardReveal(){
        cardsRevealNum++; // clicks to see the next reveal
        return false;
    }

    public void resetGame(){
        //shuffle cards here
        //this.poker;
        gameOver = false;
        repaint();
    }


    public void paintComponent(Graphics g){
        super.paintComponents(g);

        try {
            Image backCard = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/Card_BACK.png")));
            g.drawImage(backCard,0,0,200,278,null);
            //Image backCard2 = ImageIO.read(getClass().getResource("/resources/images/Card_BACK.png"));
            Image backCard2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/Card_BACK.png")));
            g.drawImage(backCard2,201,0,200,278,null);

            /*PokerCards r1c = PokerFrameDumb.deck.cards[22];
            Image r1 = ImageIO.read(getClass().getResource("/resources/images/" + r1c + ".png"));
            g.drawImage(r1, 402,0,200,278,null);

            PokerCards r2c = PokerFrameDumb.deck.cards[10];
            Image r2 = ImageIO.read(getClass().getResource("/resources/images/" + r2c + ".png"));
            g.drawImage(r2, 603,0,200,278,null);

            PokerCards r3c = PokerFrameDumb.deck.cards[9];
            Image r3 = ImageIO.read(getClass().getResource("/resources/images/" + r3c + ".png"));
            g.drawImage(r3, 804,0,200,278,null);

            PokerCards r4c = PokerFrameDumb.deck.cards[14];
            Image r4 = ImageIO.read(getClass().getResource("/resources/images/" + r4c + ".png"));
            g.drawImage(r4, 1005,0,200,278,null);

            PokerCards r5c = PokerFrameDumb.deck.cards[23];
            Image r5 = ImageIO.read(getClass().getResource("/resources/images/" + r5c + ".png"));
            g.drawImage(r5, 1206,0,200,278,null);*/

            PokerCards r1c = PokerFrameDumb.deck.cards[22];
            Image r1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r1c + ".png")));
            g.drawImage(r1, 402,0,200,278,this);

            PokerCards r2c = PokerFrameDumb.deck.cards[10];
            Image r2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r2c + ".png")));
            g.drawImage(r2, 603,0,200,278,this);

            PokerCards r3c = PokerFrameDumb.deck.cards[9];
            Image r3 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r3c + ".png")));
            g.drawImage(r3, 804,0,200,278,this);

            PokerCards r4c = PokerFrameDumb.deck.cards[14];
            Image r4 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r4c + ".png")));
            g.drawImage(r4, 1005,0,200,278,this);

            PokerCards r5c = PokerFrameDumb.deck.cards[23];
            Image r5 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r5c + ".png")));
            g.drawImage(r5, 1206,0,200,278,this);


            for (PokerCards c : PokerFrameDumb.deck.cards){
                if(c.toString().equals(PokerFrameDumb.card1.toString())){
                    PokerCards c1 = PokerFrameDumb.card1;
                    Image playerCard1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + c1 + ".png")));
                    g.drawImage(playerCard1,0,400,200,278,this);
                }
                if(c.toString().equals(PokerFrameDumb.card2.toString())){
                    PokerCards c2 = PokerFrameDumb.card2;
                    Image playerCard2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + c2 + ".png")));
                    g.drawImage(playerCard2,201,400,200,278,this);
                }

                /*PokerCards r1c = PokerFrameDumb.deck.cards[22]; //to 5
                PokerCards r2c = PokerFrameDumb.deck.cards[10]; // to 11
                PokerCards r3c = PokerFrameDumb.deck.cards[9]; // to 25
                PokerCards r4c = PokerFrameDumb.deck.cards[14];  // to 13
                PokerCards r5c = PokerFrameDumb.deck.cards[23];  //to 27

                if(!(r1c.equals(PokerFrameDumb.card1) || r1c.equals(PokerFrameDumb.card2))){
                    Image r1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r1c + ".png")));
                    g.drawImage(r1, 402,0,200,278,this);
                } else {
                    r1c = PokerFrameDumb.deck.cards[5];
                    Image r1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r1c + ".png")));
                    g.drawImage(r1, 402,0,200,278,this);
                }

                if(!(r2c.equals(PokerFrameDumb.card1) || r2c.equals(PokerFrameDumb.card2))){
                    Image r2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r2c + ".png")));
                    g.drawImage(r2, 603,0,200,278,this);
                } else {
                    r2c = PokerFrameDumb.deck.cards[11];
                    //Image r2 = ImageIO.read(getClass().getResource("/resources/images/" + r2c + ".png"));
                    Image r2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r2c + ".png")));
                    g.drawImage(r2, 603,0,200,278,this);
                }

                if(!(r3c.equals(PokerFrameDumb.card1) || r3c.equals(PokerFrameDumb.card2))){
                    Image r3 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r3c + ".png")));
                    g.drawImage(r3, 804,0,200,278,this);
                } else {
                    r3c = PokerFrameDumb.deck.cards[25];
                    Image r3 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r3c + ".png")));
                    g.drawImage(r3, 804,0,200,278,this);
                }

                if(!(r4c.equals(PokerFrameDumb.card1) || r4c.equals(PokerFrameDumb.card2))){
                    Image r4 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r4c + ".png")));
                    g.drawImage(r4, 1005,0,200,278,this);
                } else {
                    r4c = PokerFrameDumb.deck.cards[13];
                    Image r4 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r4c + ".png")));
                    g.drawImage(r4, 1005,0,200,278,this);
                }

                if(!(r5c.equals(PokerFrameDumb.card1) || r5c.equals(PokerFrameDumb.card2))){
                    Image r5 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r5c + ".png")));
                    g.drawImage(r5, 1206,0,200,278,this);
                } else {
                    r5c = PokerFrameDumb.deck.cards[27];
                    Image r5 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/" + r5c + ".png")));
                    g.drawImage(r5, 1206,0,200,278,this);
                }*/
            }


        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }
    }

}
