

import java.util.Random;

public class RandomCardDeck extends SimpleCardDeck {

    public RandomCardDeck() {
        super();
        shuffle();
    }

    public void reset() {
        super.reset();
        shuffle();
    }

    public void shuffle() {
        Card[] shuffled = new Card[cards.length];
        Random rand = new Random();
        int cardIndex;
        boolean placed;
        for (int c = 0; c < cards.length; c++) {
            do {
                placed = false;
                cardIndex = rand.nextInt(cards.length);
                if (shuffled[cardIndex] == null) {
                    shuffled[cardIndex] = cards[c];
                    placed = true;
                }
            } while (!placed);
        }
        cards = shuffled;
        top = 0;
    }

}