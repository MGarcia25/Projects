package test.Poker2.poker.one.testing;

//import org.junit.Assert;
//import org.junit.Test;

public class PokerTest {
//    @Test
    public void testPoker(){
        PokerDeck deck = new PokerDeck();

        PokerDeck shuffle = new PokerDeck();
        shuffle.shuffle();

        //Assert.assertNotEquals(deck, shuffle);
        //Assert.assertEquals("this should fail since they are not the same", deck, shuffle);  //test effective
//        Assert.assertNotEquals("Deck failed to be shuffled", deck, shuffle);
    }


}