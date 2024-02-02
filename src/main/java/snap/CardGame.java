package snap;

import java.util.ArrayList;
import java.util.Optional;

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

    // Takes the card from the top of the deck and returns it - does it need to be optional? Double check.
    public Optional<Card> dealCard() {
        return deckOfCards.stream().findFirst();
    }

    // ArrayList<Card> sortDeckInNumberOrder() Sorts the deck in number order (e.g. 2222333344445555 etc) and stores the new shuffled deck back into the deckOfCards attribute

    // ArrayList<Card> sortDeckIntoSuits() Sorts the deck into suits (2,3,4,5,6,7,8,9,10,J,Q,K,A of hearts, then 2,3,4,5,6,7,8,9,10,J,Q,K,A of clubs etc.) and stores the new shuffled
    //deck back into the deckOfCards attribute.

    // ArrayList<Card> shuffleDeck()
    //Shuffles the deck into a random order and stores the new shuffled deck back into the deckOfCards attribute.

}
