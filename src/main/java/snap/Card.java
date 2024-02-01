package snap;

public class Card {

    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        String topValue = value == 10 ? "10" : " " + symbol;
        String bottomValue = value == 10 ? "10" : symbol + " ";

        return "+---------+\n" +
                "|" + topValue + "       |\n" +
                "|         |\n" +
                "|    " + suit + "    |\n" +
                "|         |\n" +
                "|       " + bottomValue + "|\n" +
                "+---------+";
    }

}
