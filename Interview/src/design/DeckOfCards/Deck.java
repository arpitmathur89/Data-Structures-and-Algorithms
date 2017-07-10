package design.DeckOfCards;

/**
 * Created by arpit on 7/9/2017.
 */
public class Deck {

    private Card[] deck;
    private int cardsUsed;

    public Deck(){
        deck = new Card[52];
        int cardcount = 0;
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                Suit s = Suit.getSuitfromValue(i);
                deck[cardcount++] = new Card(s,j);
            }
        }
        cardsUsed = 0;
    }

    public void Shuffle(){
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;

    }

    public int cardsLeft(){
        return deck.length - cardsUsed;
    }

    public Card dealCard(){
            cardsUsed++;
            return deck[cardsUsed-1];
    }




}
