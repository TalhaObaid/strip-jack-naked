public class Card {

    public static final int MAX = 13;

    public static final int MIN = 1;

    public static char[] getSuits() {
        return (new char[] { 'S', 'H', 'D', 'C'});
    }

    public static boolean isPay(Card card) {
        boolean pay = false;
        switch (card.value) {
        case 1:
        case 11:
        case 12:
        case 13:
            pay = true;
            break;

        default:
            pay = false;

        }
        return pay;
    }

    public static int payRate(int val) {
        int payRate = 0;
        switch (val) {
        case 1:
            payRate = 4;
            break;
        case 11:
            payRate = 1;
            break;
        case 12:
            payRate = 2;
            break;
        case 13:
            payRate = 3;
            break;
        }
        return payRate;
    }

    private char suit;

    private int value;

    public Card() {
        value = 0;
        suit = '\0';

    }

    public Card(Card card) {
        suit = card.getSuit();
        value = card.getValue();
    }

    public Card(int value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    public char getSuit() {
        return suit;
    }

    public String getSuitAsString() {
        String suitStr = "";
        switch (suit) {
        case 'S':
            suitStr = "Spades";
            break;
        case 'H':
            suitStr = "Hearts";
            break;
        case 'D':
            suitStr = "Diamonds";
            break;
        case 'C':
            suitStr = "Clubs";
            break;

        }
        return suitStr;
    }

    public int getValue() {
        return value;
    }

    public String getValueAsString() {
        String valueStr = "";
        switch (value) {
        case 1:
            valueStr = value + " Ace";
            break;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            valueStr = Integer.toString(value);
            break;
        case 10:
            valueStr = value + " Ten";
            break;
        case 11:
            valueStr = value + " Jack";
            break;
        case 12:
            valueStr = value + " Queen";
            break;
        case 13:
            valueStr = value + " King";
            break;
        }

        return valueStr;
    }

    public boolean isEqual(Card card) {
        boolean equal = false;
        if (card.getSuit() == suit && card.getValue() == value) equal = true;

        return equal;
    }

    public boolean isPictureCard() {
        return true;
    }

    public String toString() {
        return getSuitAsString() + '\t' + getValueAsString();
    }
}