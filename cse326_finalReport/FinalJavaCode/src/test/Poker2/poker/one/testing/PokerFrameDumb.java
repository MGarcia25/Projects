package test.Poker2.poker.one.testing;

//import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Locale;

public class PokerFrameDumb extends JFrame implements ActionListener {

    public double percent;
    /**
     * Back ground/ table of the program
     * @invariant newGame button is not clicked
     */
    private PokerTable table;

    /**
     * Button used to begin calculations
     * @invariant calcButton is not clicked
     */
    public final JButton calcButton;

    /**
     * Page that asks user for input
     * @invariant askPage is available
     */
    public JFrame askPage;

    public JFrame helpFrame;


    /**
     * next page after user has inputted their selections
     * @invariant askPage has been completed and accepted
     */
    public JFrame pokerTableFrame;

    /**
     * Button generate a new game
     * @invariant newGame is not clicked
     */
    private JButton newGame;

    /**
     * Button that re asks the user to input new hand
     * @invariant newHand is not clicked
     */
    private JButton newHand;

    /**
     * Button that describes the hands to the user
     * @invariant helpButton is not clicked
     */
    private JButton helpButton;

    /**
     * Text field for user to input how many players
     * @invariant field is empty and incorrect
     */
    public JTextField textFieldPlayers = new JTextField();

    /**
     * Text field for user's first card suit
     * @invariant field is empty and incorrect
     */
    public JTextField card1TextFieldSuit = new JTextField();

    /**
     * Text field for user's second card suit
     * @invariant field is empty and incorrect
     */
    public JTextField card2TextFieldSuit = new JTextField();

    /**
     * Text field for user's first card number
     * @invariant field is empty and incorrect
     */
    public JTextField card1TextFieldNum = new JTextField();

    /**
     * Text field for user's second card number
     * @invariant field is empty and incorrect
     */
    public JTextField card2TextFieldNum = new JTextField();

    /**
     * input of users input of how many players
     * @invariant input is wrong
     */
    public static String numSelect;

    /**
     * input for user's first card number
     * @invariant field is empty and incorrect
     */
    public String card1Suit;

    /**
     * input for user's first card number
     * @invariant field is empty and incorrect
     */
    public String card1Num;

    /**
     * input for user's second card suit
     * @invariant field is empty and incorrect
     */
    public String card2Suit;


    public String card2Num;

    public static PokerCards card1;

    public static PokerCards card2;

    public static boolean card1Good;

    public static boolean card2Good;


    //Initializing the deck and shuffling it

    public static String getNumSelect(){
        return numSelect;
    }

    Player user = new Player();

    public static PokerDeck deck;

    /**
     *  Constructor of PokerFrameDumb
     */
    public PokerFrameDumb(){
        //table = new PokerTable(n);
        //pokerTableFrame.setVisible(false);
        deck = new PokerDeck();
        askPage = new JFrame();
        askPage.setSize(1200,500);
        askPage.setLocationRelativeTo(null);
        String phcTitle = "Poker Hands Calculator";
        JLabel text = new JLabel(phcTitle, SwingConstants.CENTER);
        text.setFont(new Font("Serif", Font.BOLD, 44));
        askPage.add(text,BorderLayout.NORTH);
        askPage.setBackground(Color.pink);
        GridLayout gl = new GridLayout(10,2);

        calcButton = new JButton("Calculate");

        askPage.setLayout(gl);
        //JLabel title = new JLabel("Poker Hands Calculator");
        //askPage.add(title, BorderLayout.CENTER);
        JLabel blank = new JLabel();
        askPage.add(blank);
        JLabel askPlayers = new JLabel("How many Players? (2-9)");
        askPage.add(askPlayers);
        askPage.add(textFieldPlayers);
        textFieldPlayers.setFont(new Font("Cracked", Font.PLAIN,25));
        JLabel askcard1Suit = new JLabel("Please enter your first card's SUIT");
        askPage.add(askcard1Suit);
        askPage.add(card1TextFieldSuit);
        card1TextFieldSuit.setFont(new Font("Cracked", Font.PLAIN, 25));
        JLabel askcard1Num = new JLabel("Please enter your first card's NUMBER (in TEXT) with the first letter capitalized");
        askPage.add(askcard1Num);
        askPage.add(card1TextFieldNum);
        card1TextFieldNum.setFont(new Font("Cracked", Font.PLAIN, 25));
        JLabel askcard2Suit = new JLabel("Please enter your second card's SUIT");
        askPage.add(askcard2Suit);
        askPage.add(card2TextFieldSuit);
        card2TextFieldSuit.setFont(new Font("Cracked", Font.PLAIN, 25));
        JLabel askcard2Num = new JLabel("Please enter your second card's NUMBER (in TEXT) with the first letter capitalized");
        askPage.add(askcard2Num);
        askPage.add(card2TextFieldNum);
        card2TextFieldNum.setFont(new Font("Cracked", Font.PLAIN, 25));

        JLabel blank2 = new JLabel();


        askPage.add(blank2);
        calcButton.addActionListener(this);
        askPage.add(calcButton, BorderLayout.SOUTH);


        askPage.setVisible(true);
        askPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }


    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == calcButton){
            numSelect = textFieldPlayers.getText();
            card1Num = card1TextFieldNum.getText();
            card1Suit = card1TextFieldSuit.getText();
            card2Num = card2TextFieldNum.getText();
            card2Suit = card2TextFieldSuit.getText();
            /*System.out.println(card1Num);
            System.out.println(card1Suit);
            System.out.println(card2Num);
            System.out.println(card2Suit);*/

            if(!(numSelect.equals("2") || numSelect.equals("3")||numSelect.equals("4")||numSelect.equals("5")||numSelect.equals("6")||numSelect.equals("7")||numSelect.equals("8")||numSelect.equals("9"))){
                JFrame popUpError = new JFrame();
                JOptionPane.showMessageDialog(popUpError, "Incorrect Input, Range of Players: 2-9", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (card1Suit.equalsIgnoreCase("Diamonds")) {
                    try {
                        card1 = new PokerCards(PokerCards.Suit.Diamonds, PokerCards.Number.valueOf(card1Num));
                        System.out.println("Card 1 good to GO");
                        card1Good = true;
                    } catch (IllegalArgumentException e) {
                        JFrame popUpError2 = new JFrame();
                        JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Number Input for First Card is incorrect! Please double check" +
                                " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (card1Suit.equalsIgnoreCase("Hearts")) {
                    try {
                        card1 = new PokerCards(PokerCards.Suit.Hearts, PokerCards.Number.valueOf(card1Num));
                        System.out.println("Card 1 good to GO");
                        card1Good = true;
                    } catch (IllegalArgumentException e) {
                        JFrame popUpError2 = new JFrame();
                        JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Number Input for First Card is incorrect! Please double check" +
                                " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (card1Suit.equalsIgnoreCase("Spades")) {
                    try {
                        card1 = new PokerCards(PokerCards.Suit.Spades, PokerCards.Number.valueOf(card1Num));
                        System.out.println("Card 1 good to GO");
                        card1Good = true;
                    } catch (IllegalArgumentException e) {
                        JFrame popUpError2 = new JFrame();
                        JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Number Input for First Card is incorrect! Please double check" +
                                " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (card1Suit.equalsIgnoreCase("Clubs")) {
                    try {
                        card1 = new PokerCards(PokerCards.Suit.Clubs, PokerCards.Number.valueOf(card1Num));
                        System.out.println("Card 1 good to GO");
                        card1Good = true;
                    } catch (IllegalArgumentException e) {
                        JFrame popUpError2 = new JFrame();
                        JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Number Input for First Card is incorrect! Please double check" +
                                " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JFrame popUpError2 = new JFrame();
                    JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, First Card's suit is incorrect! Please double check" +
                            " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //askPage.repaint();
                }
                if (card2Suit.equalsIgnoreCase("Diamonds")) {
                    try {
                        card2 = new PokerCards(PokerCards.Suit.Diamonds, PokerCards.Number.valueOf(card2Num));
                        System.out.println("Card 2 good to GO");
                        card2Good = true;
                    } catch (IllegalArgumentException e) {
                        JFrame popUpError2 = new JFrame();
                        JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Number Input for Second Card is incorrect! Please double check" +
                                " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (card2Suit.equalsIgnoreCase("Hearts")) {
                    try {
                        card2 = new PokerCards(PokerCards.Suit.Hearts, PokerCards.Number.valueOf(card2Num));
                        System.out.println("Card 2 good to GO");
                        card2Good = true;
                    } catch (IllegalArgumentException e) {
                        JFrame popUpError2 = new JFrame();
                        JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Number Input for Second Card is incorrect! Please double check" +
                                " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (card2Suit.equalsIgnoreCase("Spades")) {
                    try {
                        card2 = new PokerCards(PokerCards.Suit.Spades, PokerCards.Number.valueOf(card2Num));
                        System.out.println("Card 2 good to GO");
                        card2Good = true;
                    } catch (IllegalArgumentException e) {
                        JFrame popUpError2 = new JFrame();
                        JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Number Input for Second Card is incorrect! Please double check" +
                                " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (card2Suit.equalsIgnoreCase("Clubs")) {
                    try {
                        card2 = new PokerCards(PokerCards.Suit.Clubs, PokerCards.Number.valueOf(card2Num));
                        System.out.println("Card 2 good to GO");
                        card2Good = true;
                    } catch (IllegalArgumentException e) {
                        JFrame popUpError2 = new JFrame();
                        JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Number Input for Second Card is incorrect! Please double check" +
                                " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JFrame popUpError2 = new JFrame();
                    JOptionPane.showMessageDialog(popUpError2, "Incorrect Input, Second Card's suit is incorrect! Please double check" +
                            " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
            /*deck.shuffle();
            deck.shuffle();
            deck.shuffle();
            for (int i = 0; i < 52; i++){
                if (deck.cards[i].toString().equals(card1.toString())){
                    PokerDeck swapCards = new PokerDeck();
                    swapCards.cards[51] = deck.cards[i];
                    deck.cards[i] = deck.cards[0];
                    deck.cards[0] = swapCards.cards[51];


                }
            }
            for (int i = 0; i < 52; i++){
                if (deck.cards[i].toString().equals(card2.toString())){
                    PokerDeck swapCards = new PokerDeck();
                    swapCards.cards[50] = deck.cards[i];
                    deck.cards[i] = deck.cards[1];
                    deck.cards[1] = swapCards.cards[50];


                }
            }
            System.out.println("After swapping:");
            deck.printDeck(deck);
            System.out.println("User Player");
//            user.setCard2(card1);
//            user.setCard2(card2);
//            user.PrintHand();

            user.setCard1(card1);
            user.setCard2(card2);
            System.out.println(user.getCard1());
            System.out.println(user.getCard2());*/
            /*if(!(card1.toString().equals(card2.toString()))){
                try {
                    booleanCheck(numSelect, card1Good, card2Good);
                } catch (NullPointerException exception){
                    JFrame popUpError2 = new JFrame();
                    JOptionPane.showMessageDialog(popUpError2, "Your cares are the same! Please double check" +
                            " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }*/
            booleanCheck(numSelect, card1Good, card2Good);

        }

        if (a.getSource() == helpButton){
            helpFrame = new JFrame();
            //JFrame helpFrame = new JFrame();
            JPanel helpPanel = new JPanel();
            //helpPanel.setSize(800,1500);
            helpFrame.setSize(getWidth(),getHeight());
            helpFrame.setTitle("About the Hands");
            //helpFrame.setLocationRelativeTo(null);
            helpFrame.setLocation(400,500);
            //helpPanel.setLocationRelativeTo(null);

            JTextPane helptextPane = new JTextPane();
            helptextPane.setText("Royal Flush: Best hand in poker and is very rare. Same suit of the cards 10 to Ace\n" +
                    "Straight Flush: Second best hand, Just like a straight, but the cards are all the same suit.\n" +
                    "Four of a Kind: Four of the same cards. Hand is completed with the highest card on the table or in your hand\n" +
                    "Full House: A combination of three of a kind with a pair. The full house hand that has the highest three of a kind cards wins from other full houses\n" +
                    "Flush: Five cards that are all the same suit. These don't need to be in any order. If two players have a flush, the player with the highest card in the flush wins\n" +
                    "Straight: A series of five cards that follow each other, but that are not the same suit. Aces can follow a king, or start a straight followed by a two\n" +
                    "Three of a Kind: Three cards of the same kind, for example three aces. The hand is completed with the two highest cards that are available\n" +
                    "Two Pair: Two sets of two cards of the same kind. For example two kings and two queens, the last card to complete the hand is the highest card that is left available\n" +
                    "Pair: Two cards of the same kind, for example two aces. The hand is filled up with the three highest cards that are left available\n" +
                    "High card: You have none of the above hand patterns. Choose the highest card available rather in your hand or on the table");
            //helptextPane.setText(String.valueOf(new Font("Serif",Font.PLAIN,22)));
            helptextPane.setFont(new Font("Serif", Font.PLAIN, 20));
            helptextPane.setEditable(false);
            helpPanel.add(helptextPane);
            helpFrame.add(helpPanel);
            helpFrame.pack();
            helpFrame.setVisible(true);

        }
    }



    public void booleanCheck(String numbSelect, Boolean card1G, Boolean card2G){
        int count = 0;
        if((card1G && card2G)){
            if(card1.toString().equals(card2.toString())){
                //System.out.println("line 215");
                JFrame popUpError2 = new JFrame();
                JOptionPane.showMessageDialog(popUpError2, "Your cards are the same! Please double check" +
                        " your input", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                deck.shuffle();
                deck.shuffle();
                deck.shuffle();
                for (int i = 0; i < 52; i++){
                    if (deck.cards[i].toString().equals(card1.toString())){
                        PokerDeck swapCards = new PokerDeck();
                        swapCards.cards[51] = deck.cards[i];
                        deck.cards[i] = deck.cards[0];
                        deck.cards[0] = swapCards.cards[51];


                    }
                }
                for (int i = 0; i < 52; i++){
                    if (deck.cards[i].toString().equals(card2.toString())){
                        PokerDeck swapCards = new PokerDeck();
                        swapCards.cards[50] = deck.cards[i];
                        deck.cards[i] = deck.cards[1];
                        deck.cards[1] = swapCards.cards[50];


                    }
                }
                System.out.println("After swapping:");
                deck.printDeck(deck);
                System.out.println("User Player");
    //            user.setCard2(card1);
    //            user.setCard2(card2);
    //            user.PrintHand();

                user.setCard1(card1);
                user.setCard2(card2);
                System.out.println(user.getCard1());
                System.out.println(user.getCard2());
                numSelect = textFieldPlayers.getText();
                int x = Integer.parseInt(String.valueOf(numSelect));

                Player[] bots = new Player[x];
                while(count < x - 1){
                    bots[count] = new Player();
                    count++;
                }

                PokerDeck swapCards = new PokerDeck();

                Card playercard1 = new Card(translate(user.getCard1()), suit_translate(String.valueOf(user.getCard1().getSuit())));
                Card playercard2 = new Card(translate(user.getCard2()),suit_translate(String.valueOf(user.getCard2().getSuit())));
                Hand playerhand = new Hand();
                playerhand.addCard(playercard1);
                playerhand.addCard(playercard2);
                PokerCards flop1 = new PokerCards(PokerCards.Suit.Spades, PokerCards.Number.Ace);
                PokerCards flop2 = new PokerCards(PokerCards.Suit.Spades, PokerCards.Number.Ace);
                PokerCards flop3 = new PokerCards(PokerCards.Suit.Spades, PokerCards.Number.Ace);
                PokerCards Turn = new PokerCards(PokerCards.Suit.Spades, PokerCards.Number.Ace);
                PokerCards River = new PokerCards(PokerCards.Suit.Spades, PokerCards.Number.Ace);
                x = Integer.parseInt(String.valueOf(numSelect));
                Hand[] players = new Hand[9];
                for(int t = 0; t < 9; t++){
                    players[t] = new Hand();
                }
                for(int t = 0; t < x; t++){
                    bots[t] = new Player();
                }
                int maxnum;
                int losscount = 0;
                for(x=0; x < 100000; x++){
                    for(int t = 0; t < 9; t++){
                        players[t] = new Hand();
                    }
                    maxnum = 0;
                    PokerDeck deckyboi = new PokerDeck();
                    deckyboi.shuffle();
                    deckyboi.shuffle();
                    deckyboi.shuffle();
                    for (int i = 0; i < 52; i++){
                        if (deckyboi.cards[i].toString().equals(card1.toString())){
                            swapCards = new PokerDeck();
                            swapCards.cards[51] = deckyboi.cards[i];
                            deckyboi.cards[i] = deckyboi.cards[0];
                            deckyboi.cards[0] = swapCards.cards[51];
                        }
                    }
                    for (int i = 0; i < 52; i++)  {
                        if (deckyboi.cards[i].toString().equals(card2.toString())){
                            swapCards = new PokerDeck();
                            swapCards.cards[50] = deckyboi.cards[i];
                            deckyboi.cards[i] = deckyboi.cards[1];
                            deckyboi.cards[1] = swapCards.cards[50];
                        }
                    }
                    for (int i = 0; i < bots.length; i++){
                        bots[i] = new Player(deckyboi.drawCard(), deckyboi.drawCard());
                    }
                    flop1 = deckyboi.drawCard();
                    Card f1 = new Card();
                    f1.setCard(this.translate(flop1), this.suit_translate(String.valueOf(flop1.getSuit())));
                    flop2 = deckyboi.drawCard();
                    Card f2 = new Card();
                    f2.setCard(this.translate(flop2), this.suit_translate(String.valueOf(flop2.getSuit())));
                    flop3 = deckyboi.drawCard();
                    Card f3 = new Card();
                    f3.setCard(this.translate(flop3), this.suit_translate(String.valueOf(flop3.getSuit())));
                    Turn  = deckyboi.drawCard();
                    Card turn = new Card();
                    turn.setCard(this.translate(Turn), this.suit_translate(String.valueOf(Turn.getSuit())));
                    River = deckyboi.drawCard();
                    Card river = new Card();
                    river.setCard(this.translate(River), this.suit_translate(String.valueOf(River.getSuit())));
                    Hand board = new Hand();
                    board.addCard(f1);
                    board.addCard(f2);
                    board.addCard(f3);
                    board.addCard(turn);
                    board.addCard(river);
                    /*System.out.print("Board #" + (x + 1));
                    System.out.println(board);
                    System.out.println("Player Hand:");
                    System.out.println(playerhand.toString());*/
                    for(int j = 0; j < Integer.parseInt(String.valueOf(numSelect)); j++){
                        players[j].addCard(f1);
                        players[j].addCard(f2);
                        players[j].addCard(f3);
                        players[j].addCard(turn);
                        players[j].addCard(river);
                        if(j == 0) {
                            players[j].addCard(playercard1);
                            players[j].addCard(playercard2);
                        }else {
                            Card botcard1 = new Card(this.translate(bots[j].getCard1()), this.suit_translate(String.valueOf(bots[j].getCard1().getSuit())));
                            players[j].addCard(botcard1);
                            Card botcard2 = new Card(this.translate(bots[j].getCard2()), this.suit_translate(String.valueOf(bots[j].getCard2().getSuit())));
                            players[j].addCard(botcard2);
                        }
                        //System.out.println(players[j].toString());
                        //System.out.println(HandEvaluator.rankHand(players[j]));
                        if(j == 0){
                            maxnum = HandEvaluator.rankHand(players[j]);
                        }
                        if(HandEvaluator.rankHand(players[j]) > (maxnum + 1)){
                            losscount++;
                            j = 10;
                        }
                        //System.out.println("Current Losses:" + losscount);
                    }
                }
                System.out.println("LossCount:" + losscount);
                System.out.println("Precent of Player Winning: ");
                DecimalFormat df = new DecimalFormat("##.####");

                //double percent = Double.valueOf(100)*(Double.valueOf(1)-(Double.valueOf(losscount)/Double.valueOf(100000)));
                percent = Double.valueOf(100)*(Double.valueOf(1)-(Double.valueOf(losscount)/Double.valueOf(100000)));
                System.out.println(percent);
                callPokerTable(x);
            }
        }
    }

    public void callPokerTable(int n) {
        //table = new PokerTable(n);
        //pokerTableFrame();
        pokerTableFrame(n);
    }


    /**
     * The main page of the program/software
     * @pre callPokerTable() was called
     * @post no changes
     */
    //public void pokerTableFrame() {
    public void pokerTableFrame(int x){
        table = new PokerTable(x);
        askPage.setVisible(false);
        pokerTableFrame = new JFrame();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();


        //pokerTableFrame.setLayout(new BorderLayout());
        pokerTableFrame.setLayout(new BorderLayout());
        GridLayout gl = new GridLayout(1,4);
        JPanel oddPanel = new JPanel();
        oddPanel.setLayout(gl);


        JTextPane textPane = new JTextPane();
        /*textPane.setText("Royal Flush %: \n" + "Straight Flush %: \n" + "Four of a Kind %: \n" +
                "Full House %: \n" + "Flush %: \n" + "Straight %: \n" + "Three of a Kind %: \n" +
                "Two Pair %: \n" + "Pair %: \n" + "High Card %: ");*/
        DecimalFormat df = new DecimalFormat("##.###");
        percent = Double.parseDouble(df.format(percent));
        textPane.setText("Total Percent of Winning: " + percent + "\n");
        textPane.setFont(new Font("Serif", Font.PLAIN, 32));
        textPane.setEditable(false);
        oddPanel.add(textPane);

        //buttons new game and try a new hand (lower right)
        //JPanel buttonPane = new JPanel();
        //JPanel helpPane = new JPanel();
        //buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        helpButton = new JButton("About the Hands");
        helpButton.setFont(new Font("Arial", Font.PLAIN, 40));
        helpButton.setPreferredSize(new Dimension(200,200));
        //helpButton.setSize(200,200);
        //buttonPane.add(helpButton);
        oddPanel.add(helpButton);
        newGame = new JButton("Exit");
        newGame.setFont(new Font("Arial", Font.PLAIN, 40));
        newGame.setPreferredSize(new Dimension(200,200));
        //buttonPane.add(newGame);
        oddPanel.add(newGame);
        newHand = new JButton("Try a New Hand");
        newHand.setFont(new Font("Arial", Font.PLAIN,40));
        newHand.setPreferredSize(new Dimension(200,200));
        //buttonPane.add(newHand);
        oddPanel.add(newHand);
        //pokerTableFrame.add(buttonPane, BorderLayout.SOUTH);
        pokerTableFrame.add(oddPanel, BorderLayout.SOUTH);



        //lambda expression
        //newGame.addActionListener(event -> pokerTableFrame.dispose());
        newGame.addActionListener(event -> System.exit(0));
        newHand.addActionListener(event -> new PokerFrameDumb());
        newHand.addActionListener(event -> pokerTableFrame.setVisible(false));   //closes the table page
        helpButton.addActionListener(this);
        //helpButton.addActionListener(hb);
        //helpButton.addActionListener(event -> PokerFrameDumb.help);
        //helpFrame.setLocationRelativeTo(null);
        //helpFrame.setSize(800, 1500);

        /*System.out.println("TEST------------------------TEST");
        //translate(card1);
        System.out.println("Translate test: " + translate(card1));*/


        pokerTableFrame.add(table);
        pack();
        pokerTableFrame.setSize(screensize.width, screensize.height - 50);
        pokerTableFrame.setTitle("Poker Hands Calculator");
        pokerTableFrame.setVisible(true);
        pokerTableFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



    /*public int translate(PokerCards x){
        //translate Two = int 0;
        int enumNumTranslate = -1;
        if (x.getNumber().toString().equalsIgnoreCase("Two")){
            enumNumTranslate = 0;
        }
        if (x.getNumber().toString().equalsIgnoreCase("Three")){
            enumNumTranslate = 1;
        }
        if(x.getNumber().toString().equalsIgnoreCase("Four")){
            enumNumTranslate = 2;
        }
        if (x.getNumber().toString().equalsIgnoreCase("Five")){
            enumNumTranslate = 3;
        }
        if(x.getNumber().toString().equalsIgnoreCase("Six")){
            enumNumTranslate = 4;
        }
        if(x.getNumber().toString().equalsIgnoreCase("Seven")){
            enumNumTranslate = 5;
        }
        if (x.getNumber().toString().equalsIgnoreCase("Eight")){
            enumNumTranslate = 6;
        }
        if(x.getNumber().toString().equalsIgnoreCase("Nine")){
            enumNumTranslate = 7;
        }
        if (x.getNumber().toString().equalsIgnoreCase("Ten")){
            enumNumTranslate = 8;
        }
        if(x.getNumber().toString().equalsIgnoreCase("Jack")){
            enumNumTranslate = 9;
        }
        if(x.getNumber().toString().equalsIgnoreCase("Queen")){
            enumNumTranslate = 10;
        }
        if(x.getNumber().toString().equalsIgnoreCase("King")){
            enumNumTranslate = 11;
        }
        if(x.getNumber().toString().equalsIgnoreCase("Ace")){
            enumNumTranslate = 12;
        }


        return enumNumTranslate;
    }*/

    public static int suit_translate(String s) {
        if(s == "Clubs") return 0;
        if(s == "Diamonds") return 1;
        if(s == "Hearts") return 2;
        if(s == "Spades") return 3;
        return 0;
    }

    public int translate(PokerCards card){
        //translate Two = int 0;
        int enumNumTranslate = -1;
        if (card.getNumber().toString().equals("Two")){
            enumNumTranslate = 0;
        }
        if (card.getNumber().toString().equals("Three")){
            enumNumTranslate = 1;
        }
        if(card.getNumber().toString().equals("Four")){
            enumNumTranslate = 2;
        }
        if (card.getNumber().toString().equals("Five")){
            enumNumTranslate = 3;
        }
        if(card.getNumber().toString().equals("Six")){
            enumNumTranslate = 4;
        }
        if(card.getNumber().toString().equals("Seven")){
            enumNumTranslate = 5;
        }
        if (card.getNumber().toString().equals("Eight")){
            enumNumTranslate = 6;
        }
        if(card.getNumber().toString().equals("Nine")){
            enumNumTranslate = 7;
        }
        if (card.getNumber().toString().equals("Ten")){
            enumNumTranslate = 8;
        }
        if(card.getNumber().toString().equals("Jack")){
            enumNumTranslate = 9;
        }
        if(card.getNumber().toString().equals("Queen")){
            enumNumTranslate = 10;
        }
        if(card.getNumber().toString().equals("King")){
            enumNumTranslate = 11;
        }
        if(card.getNumber().toString().equals("Ace")){
            enumNumTranslate = 12;
        }
        return enumNumTranslate;
    }

    public static void main(String[] args) throws NullPointerException{
        new PokerFrameDumb();
    }
}
