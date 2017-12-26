public class SimpleCardDeck {

    protected Card cards[];

    protected int top;

    public SimpleCardDeck() {
        top = 0;
        char suits[] = Card.getSuits();
        int range = Card.MAX - Card.MIN + 1; // 13 - 1 + 1 = 13
        cards = new Card[range * suits.length]; // 13 * 4 = 52
        for (int s = 0; s < suits.length; s++) {
            for (int v = Card.MIN; v <= Card.MAX; v++) {
                int index = (s * range + v - Card.MIN);
                cards[index] = new Card(v, suits[s]);
            }
        }

    }

    public SimpleCardDeck(String[] cards) {
        //TODO: Implement this
    }

    public Card deal() {
        return cards[top++];
    }

    public Card getCard(int which) {
        return cards[which];
    }

    public int getNumCards() {
        return cards.length;
    }

    public int getNumCardsLeft() {
        //TODO: Implement this
        return 0;
    }

    public void reset() {
        top = 0;
        char suits[] = Card.getSuits();
        int range = Card.MAX - Card.MIN + 1; // 13 - 1 + 1 = 13
        cards = new Card[range * suits.length]; // 13 * 4 = 52
        for (int s = 0; s < suits.length; s++) {
            for (int v = Card.MIN; v <= Card.MAX; v++) {
                int index = (s * range + v - Card.MIN);
                cards[index] = new Card(v, suits[s]);
            }
        }

    }

    public String toString() {
        String deckStr = "";
        for (int i = 0; i < cards.length; i++) {
            String buff = cards[i].toString();
            buff = buff + '\n';
            deckStr = deckStr + buff;

        }
        return deckStr;
    }

}