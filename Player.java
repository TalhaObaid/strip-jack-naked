

import java.util.*;

public class Player {

    private Vector cards;

    private int payCount;

    private int cardsPayed = 0;

    private int turns;

    Player() {
        cards = new Vector();

        payCount = 0;
        turns = 0;
    }

    /**
     * @return Returns the payCount.
     */
    public int getPayCount() {
        return payCount;
    }

    public void incPayCount() {
        this.payCount++;
    }

    public Card takeTurn() {
        turns++;
        Card card = (Card) cards.firstElement();
        cards.removeElement(cards.firstElement());
        Game.pile.add(card);
        if (cards.size() == 0)
            return null;
        else
            return card;
    }

    public String toString() {
        String deckStr = "";
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) != null) {
                String buff = cards.get(i).toString();
                buff = buff + '\n';
                deckStr = deckStr + buff;
            }

        }
        return deckStr;
    }

    public int pay(int payRate) {
        payCount++;
        int counter = payRate;
        while (counter > 0) {
            Card newCard = takeTurn();
            cardsPayed++;
            if (newCard == null) return -1;
            if (Card.isPay(newCard)) return newCard.getValue();
            counter--;
        }
        return 0;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void appendPile() {
        Vector temp = new Vector(cards);
        cards.removeAllElements();
        cards.clear();
        cards = null;
        cards = new Vector();

        cards.addAll(Game.pile);
        cards.addAll(temp);
        Game.pile.removeAllElements();
        Game.pile.clear();
        Game.pile = null;
        Game.pile = new Vector();

    }

    public int getCardsInHand() {
        return cards.size();
    }

    /**
     * @return Returns the turns.
     */
    public int getTurns() {
        return turns;
    }

    /**
     * @param turns
     *            The turns to set.
     */
    public void setTurns(int turns) {
        this.turns = turns;
    }
    /**
     * @return Returns the cardsPayed.
     */
    public int getCardsPayed() {
        return cardsPayed;
    }
    /**
     * @param cardsPayed The cardsPayed to set.
     */
    public void setCardsPayed(int cardsPayed) {
        this.cardsPayed = cardsPayed;
    }
}