package design.DeckOfCards;

/**
 * Created by arpit on 7/9/2017.
 */
public class Deck {

    private Card[] deck;

    public Deck(){
        deck = new Card[52];
        int cardcount = 0;
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                Suit s = Suit.getSuitfromValue(i);
                deck[cardcount++] = new Card(s,j);
            }
        }

    }

    public void Shuffle(){


    }

    public int cardsLeft(){
        return 0;
    }

    public Card dealCard(){
            return deck[0];
    }




}
