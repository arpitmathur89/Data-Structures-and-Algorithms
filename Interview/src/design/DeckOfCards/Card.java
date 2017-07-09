package design.DeckOfCards;


/**
 * Created by arpit on 7/9/2017.
 */
public class Card implements Comparable {

    private final Suit suit;

    private final int facevalue;

    public Card(Suit s, int val ){
        this.suit = s;
        this.facevalue = val;
    }

    public Suit getSuit(){
        return suit;
    }

    public int getFaceValue(){
        return facevalue;
    }

    @Override
    public int compareTo(Object o){
        Card card = (Card) o;
        int rank1 = this.getFaceValue();
        int rank2 = card.getFaceValue();
        if(rank1 == 1) rank1 = 14;
        if(rank2 == 1) rank2 = 14;
        return rank1 - rank2;
    }


    public String toString(){
        String FaceValueString;
        switch(facevalue){
            case 1: FaceValueString = "Ace";
                    break;
            case 11: FaceValueString = "Jack";
                     break;
            case 12: FaceValueString = "Queen";
                break;
            case 13: FaceValueString = "King";
                break;
            default: FaceValueString = String.valueOf(facevalue);
                     break;
        }

        int suitval = suit.getValue();
        if(suitval == 0){
            return FaceValueString + "of Club";
        }
        else if(suitval == 1){
            return FaceValueString + "of Diamond";
        }
        else if(suitval == 2){
            return FaceValueString + "of Heart";
        }
        else {
            return FaceValueString + "of Spade";
        }
    }
}
