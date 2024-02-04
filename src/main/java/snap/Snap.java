package snap;

import java.util.Optional;
import java.util.Scanner;

public class Snap extends CardGame {

    private Card previousCard;

    public Snap(String name) {
        super(name);
        this.shuffleDeck();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameOn = true;

        while (isGameOn) {
            System.out.println("Press 'Enter' to take your turn.");
            scanner.nextLine();

            Optional<Card> nextCard = this.dealCard();
            if (nextCard.isEmpty()) {
                System.out.println("The card deck is now empty. Game over.");
                break;
            }

            Card dealtCard = nextCard.get();
            System.out.println("You drew: \n\n" + dealtCard +"\n");

            if (previousCard != null && previousCard.getSymbol().equals(dealtCard.getSymbol())) {
                System.out.println("Snap! You win!");
                isGameOn = false;
            }

            previousCard = dealtCard;
        }

        scanner.close();
    }


}
