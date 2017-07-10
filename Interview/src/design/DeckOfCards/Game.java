package design.DeckOfCards;

import java.util.Scanner;

/**
 * Created by arpit on 7/9/2017.
 */
public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player 1 : ");
        String player1 =sc.next();
        System.out.println("Enter Player 2 : ");
        String player2 =sc.next();
        sc.close();
        Deck d = new Deck();
        /* Write your game logic in a different class with passing player names and the deck as parameters
           Eg. Poker pokerGame = new PokerGame(Player1,Player2,..Player n,d);
               String winner = pokerGame.play();
               BlackJack blackJack = new BlackJack(Player1, Player2, d);
               String winner = blackJack.play();
        */
    }
}
