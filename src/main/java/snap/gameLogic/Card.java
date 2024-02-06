package snap.gameLogic;

public class Card {

    private String suit;
    private String symbol;
    private int value;
    private String ansiColour;
    private static final String ANSI_RESET = "\u001B[0m";

    public Card(String suit, String symbol, int value, String ansiColour) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
        this.ansiColour = ansiColour;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns a string representation of the card in a specific visual format.
     * The card is represented as a text-based image with ANSI colours,
     * showing its value and suit.
     *
     * @return A string that visually represents the card.
     */
    @Override
    public String toString() {
        String topValue = value == 10 ? "10" : " " + symbol;
        String bottomValue = value == 10 ? "10" : symbol + " ";

        return "+---------+\n" +
                "|" + topValue + "       |\n" +
                "|         |\n" +
                "|" + ansiColour + "    " + suit + "    " + ANSI_RESET + "|\n" +
                "|         |\n" +
                "|       " + bottomValue + "|\n" +
                "+---------+";
    }

}
