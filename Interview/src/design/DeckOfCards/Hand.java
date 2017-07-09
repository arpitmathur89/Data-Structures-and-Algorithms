package design.DeckOfCards;

/**
 * Created by arpit on 7/9/2017.
 */
public class Hand {

    public Hand(){

    }

    public void clear(){


    }

    public void addCard(Card c){

    }

    public void removeCard(Card c){

    }

    public void removeCard(int position){

    }

    public int getCardCount(){

        return 0;
    }

    public Card getCard(int position){
        Card c = new Card(Suit.getSuitfromValue(0),12);
        return c;
    }
}
