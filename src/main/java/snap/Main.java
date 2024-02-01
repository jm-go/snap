package snap;

public class Main {
    public static void main(String[] args) {

        CardGame game = new CardGame("Snap");

        for (int i = 0; i < 11; i++) {
            System.out.println(game.getDeck().get(i));
        }

        // Print for testing purposes
        Card spadeCard = new Card("♠", "A", 14, "\u001B[34m");
        System.out.println(spadeCard);
    }


}