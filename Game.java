

import java.util.Vector;

public class Game {

    private RandomCardDeck deck;

    public Player player1;

    public static Vector pile = new Vector();

    public Player player2;

    Game() {
        player1 = new Player();
        player2 = new Player();

        deck = new RandomCardDeck();

        for (int i = 0; i < deck.getNumCards() / 2; i++) {
            player1.addCard(deck.getCard(i));
        }

        for (int i = deck.getNumCards() / 2; i < deck.getNumCards(); i++) {
            player2.addCard(deck.getCard(i));
        }
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public String getWinnerName() {
        if (player1.getCardsInHand() == 0)
            return "P2";
        else if (player2.getCardsInHand() == 0)
            return "P1";
        else
            return "";
    }

    public Player getWinner() {
        if (player1.getCardsInHand() == 0)
            return player2;
        else if (player2.getCardsInHand() == 0)
            return player1;
        else
            return null;
    }

    public void play() {
        Card card = new Card();
        int payCount = 0;
        while (player1.getCardsInHand() != 0 && player2.getCardsInHand() != 0) {

            if (payCount != 0) {
                payCount = player2.pay(Card.payRate(payCount));
                if (payCount == -1) break;
                if (payCount == 0) player1.appendPile();

            } else {
                card = player1.takeTurn();
                if (card == null)
                    break;
                else if (Card.isPay(card)) {
                    if (card == null) break;
                    payCount = player2.pay(Card.payRate(card.getValue()));
                    if (payCount == -1) break;
                    if (payCount == 0) player1.appendPile();
                }
            }

            if (payCount != 0) {
                payCount = player1.pay(Card.payRate(payCount));
                if (payCount == -1) break;
                if (payCount == 0) player2.appendPile();

            } else {
                card = player2.takeTurn();
                if (card == null)
                    break;
                else if (Card.isPay(card)) {
                    if (card == null) break;
                    payCount = player1.pay(card.getValue());
                    if (payCount == -1) break;
                    if (payCount == 0) player2.appendPile();
                }
            }

        } // while

    }

}