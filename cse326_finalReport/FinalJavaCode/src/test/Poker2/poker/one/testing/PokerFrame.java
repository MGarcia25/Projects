package test.Poker2.poker.one.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import test.Poker2.poker.one.testing.*;

public class PokerFrame extends JFrame {
    private PokerTable table;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JPanel buttonPanel;
    public JFrame playerSel;
    public JFrame pokerTableFrame;
    private JButton newGame;

    ArrayList<JButton> cardButtons = new ArrayList<JButton>();
    ArrayList<String> cardIDs;
    //Poker poker;

    public PokerFrame(){
        playerSel = new JFrame();
        //playerSel.setTitle("Choose a Player");
        playerSel.setSize(700,300);
        playerSel.setLocationRelativeTo(null);
        String selectGame = "How Many Players are Playing";
        JLabel text = new JLabel(selectGame, SwingConstants.CENTER);
        text.setFont(new Font("Serif", Font.PLAIN, 44));
        playerSel.add(text, BorderLayout.NORTH);

        twoButton = new JButton("Two");
        threeButton = new JButton("Three");
        fourButton = new JButton("Four");
        fiveButton = new JButton("Five");
        sixButton = new JButton("Six");
        sevenButton = new JButton("Seven");
        eightButton = new JButton("Eight");
        nineButton = new JButton("Nine");

        twoButton.setBounds(900,900,300,300);
        GridLayout gl = new GridLayout(4,2);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(gl);
        buttonPanel.setSize(new Dimension(900, 700));

        playerOption pOp = new playerOption();

        buttonPanel.add(twoButton);
        buttonPanel.add(threeButton);
        buttonPanel.add(fourButton);
        buttonPanel.add(fiveButton);
        buttonPanel.add(sixButton);
        buttonPanel.add(sevenButton);
        buttonPanel.add(eightButton);
        buttonPanel.add(nineButton);

        twoButton.addActionListener(pOp);
        threeButton.addActionListener(pOp);
        fourButton.addActionListener(pOp);
        fiveButton.addActionListener(pOp);
        sixButton.addActionListener(pOp);
        sevenButton.addActionListener(pOp);
        eightButton.addActionListener(pOp);
        nineButton.addActionListener(pOp);

        playerSel.add(buttonPanel, BorderLayout.SOUTH);
        playerSel.setVisible(true);
        //playerSel.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(table);

        pack();
        //System.out.println("Line 72");
    }

    private class playerOption implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Object source = event.getSource();
            JButton button = (JButton) event.getSource();
            Container buttonParent = button.getParent();
            if(source == twoButton){
                System.out.println("Two Players Selected");
                buttonParent.remove(button);
                buttonParent.revalidate();
                buttonParent.repaint();
                playerSel.setVisible(false);
                playerSel.setDefaultCloseOperation(0);
                callPokerTable(2);
            } else if (source == threeButton){
                System.out.println("Three Players Selected");
                buttonParent.remove(button);
                buttonParent.revalidate();
                buttonParent.repaint();
                playerSel.setVisible(false);
                playerSel.setDefaultCloseOperation(0);
                callPokerTable(3);
                //pokerTableFrame();
            } else if (source == fourButton){
                System.out.println("Four Players Selected\n");
                buttonParent.remove(button);
                buttonParent.revalidate();
                buttonParent.repaint();
                playerSel.setVisible(false);
                playerSel.setDefaultCloseOperation(0);
                callPokerTable(4);
            } else if (source == fiveButton){
                System.out.println("Five Players Selected");
                buttonParent.remove(button);
                buttonParent.revalidate();
                buttonParent.repaint();
                playerSel.setVisible(false);
                playerSel.setDefaultCloseOperation(0);
                callPokerTable(5);
            } else if (source == sixButton){
                System.out.println("Six Players Selected");
                buttonParent.remove(button);
                buttonParent.revalidate();
                buttonParent.repaint();
                playerSel.setVisible(false);
                playerSel.setDefaultCloseOperation(0);
                callPokerTable(6);
            } else if (source == sevenButton){
                System.out.println("Seven Players Selected");
                buttonParent.remove(button);
                buttonParent.revalidate();
                buttonParent.repaint();
                playerSel.setVisible(false);
                playerSel.setDefaultCloseOperation(0);
                callPokerTable(7);
            } else if (source == eightButton){
                System.out.println("Eight Players Selected");
                buttonParent.remove(button);
                buttonParent.revalidate();
                buttonParent.repaint();
                playerSel.setVisible(false);
                playerSel.setDefaultCloseOperation(0);
                callPokerTable(8);
            } else if (source == nineButton){
                System.out.println("Nine Players Selected");
            }
        }
    }

    public void callPokerTable(int n) {
        //System.out.println("109 PokerFrame");
        //new PokerTable(n);                                   /////////////need to uncomment later
        /*while(true){
            System.out.println("Number of players: " + n);
            //wait();
        }*/
        pokerTableFrame();
    }



    public void pokerTableFrame() {
        pokerTableFrame = new JFrame();
        pokerTableFrame.setSize(1500,900);
        pokerTableFrame.setLocationRelativeTo(null);

        newGame = new JButton("New Game");
        newGame.setBounds(70,70,70,70);
        JPanel buttonNG = new JPanel();
        buttonNG.setSize(new Dimension(500, 500));
        buttonNG.add(newGame);
        pokerTableFrame.add(buttonNG, BorderLayout.SOUTH);

        //lambda expression
        newGame.addActionListener(event -> table.poker.startPoker());

        //add(table);

        //System.out.println("Poker Frame 179");
        //String icon1s = Poker.flop1.toString();
        ImageIcon iconf1 = new ImageIcon("Poker2/poker/one/images" + Poker.flop1.toString() + ".png");
        //ImageIcon iconf1 = new ImageIcon(Poker.flop1.toString() + ".png");
        //getContentPane().add((Component) icon);
        JLabel icon1s = new JLabel();
        //icon1s.setIcon(icon);
        pokerTableFrame.add(new JLabel(iconf1), BorderLayout.NORTH);


        //pokerTableFrame.add(new JLabel(new ImageIcon("/poker/one/images/" + Poker.flop1.toString() + ".png")));
        //pokerTableFrame.add(new JLabel((Icon) ImageIO.read(Objects.requireNonNull(getClass().getResource("\\poker\\one\\images\\" + Poker.flop1.toString() + ".png")))));
        //BufferedImage f1 = ImageIO.read((getClass().getResource("/poker/one/images" + Poker.flop1.toString() + ".png")));
        //Image img = ImageIO.read(new File(String.valueOf(getClass().getResource("/poker/one/images/" + Poker.flop1.toString() + ".png"))));
        //Image imag = new ImageIcon("/poker/one/images/" + Poker.flop1.toString() + ".png").getImage();
        //setIconImage(imag);
        //pokerTableFrame.add(new JLabel((Icon) ImageIO.read(getClass().getResource("/poker/one/images" + Poker.flop1.toString() + ".png"))));
        //pokerTableFrame.add(ImageIO.read(new File("\\poker\\one\\images" + Poker.flop1.toString() + ".png")));
        //add((Component) f1);

        pack();
        pokerTableFrame.setTitle("Poker Hands Calculator");
        pokerTableFrame.setVisible(true);
        pokerTableFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



    public static void main(String[] args) throws NullPointerException{
        new PokerFrame();
    }

}
