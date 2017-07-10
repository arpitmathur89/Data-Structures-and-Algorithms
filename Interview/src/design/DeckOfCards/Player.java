package design.DeckOfCards;

import java.util.ArrayList;

/**
 * Created by arpit on 7/9/2017.
 */
public class Player {

    private String name;
    private ArrayList<Card> hand;
    public Player(String name){
        this.name = name;
        hand = new ArrayList<Card>();
    }

    public void clear(){
        hand.clear();
    }

    public String getName(){
        return name;
    }

    public void addCard(Card c){
        hand.add(c);
    }

    public void removeCard(Card c){
        hand.remove(c);
    }

    public void removeCard(int position){
        hand.remove(position);
    }

    public int getCardCount(){
        return hand.size();
    }

    public Card getCard(int position){
        Card c = new Card(Suit.getSuitfromValue(0),12);
        return c;
    }
}
