package snap;

import java.util.*;

public class CardGame {

    private ArrayList<Card> deckOfCards;
    private String name;

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<Card>();
        this.initialiseDeck();
    }

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    private void initialiseDeck() {
        String[] suits = {"♥", "♣", "♦", "♠"};
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                String color = (suit.equals("♦") || suit.equals("♥")) ? "\u001B[31m" : "\u001B[34m";
                this.deckOfCards.add(new Card(suit, symbols[i], values[i], color));

            }
        }
    }

    /**
     * Removes and returns the top card of the deck.
     * Returns an empty {@code Optional} if the deck is empty.
     *
     * @return Optional<Card> - the top card, or an empty Optional if the deck is empty.
     */
    public Optional<Card> dealCard() {
        return deckOfCards.isEmpty() ? Optional.empty() : Optional.of(deckOfCards.remove(0));
    }

    /**
     * Sorts the deck of cards in ascending order based on their numeric values.
     *
     * @return ArrayList<Card> - the deck sorted by number.
     */
    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, Comparator.comparingInt(Card::getValue));
        return deckOfCards;
    }

    // ArrayList<Card> sortDeckIntoSuits() Sorts the deck into suits (2,3,4,5,6,7,8,9,10,J,Q,K,A of hearts, then 2,3,4,5,6,7,8,9,10,J,Q,K,A of clubs etc.) and stores the new shuffled
    //deck back into the deckOfCards attribute.

    /**
     * Shuffles the deck of cards into a random order.
     *
     * @return ArrayList<Card> - the shuffled deck.
     */
    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

}
