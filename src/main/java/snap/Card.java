package snap;

public class Card {

    private String suit;
    private String symbol;
    private int value;
    private String ansiColour;

    // ANSI escape code for colour reset
    private static final String ANSI_RESET = "\u001B[0m";

    public Card(String suit, String symbol, int value, String ansiColour) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
        this.ansiColour = ansiColour;
    }

    public int getValue() {
        return value;
    }

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
