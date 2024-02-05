package snap;

import java.util.Optional;
import java.util.Scanner;

public class Snap extends CardGame {

    private Card previousCard;
    private Player playerOne;
    private Player playerTwo;
    private Commands commands = new Commands();

    public Snap(String name) {
        super(name);
        this.shuffleDeck();
    }

    // Refactor and add comment
    public void playAloneGame() {
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
                System.out.println("Snap! You win!\n");
                isGameOn = false;
            }

            previousCard = dealtCard;
        }
    }

    // Refactor and add comment
    public void playDuoGame() {
        this.playerOne = new Player("");
        this.playerTwo = new Player("");

        Scanner scanner = new Scanner(System.in);
        boolean isGameOn = true;
        Player currentPlayer = playerOne;

        System.out.print("Please enter a name for Player 1: ");
        this.playerOne.setName(commands.getNameInput());
        System.out.print("\nPlease enter a name for Player 2: ");
        this.playerTwo.setName(commands.getNameInput());
        while (isGameOn) {
            System.out.println("\n" + currentPlayer.getName() + "'s turn. Press 'Enter' to draw a card.");
            scanner.nextLine();

            Optional<Card> nextCard = this.dealCard();
            if (nextCard.isEmpty()) {
                System.out.println("\nThe card deck is now empty. Game over.\n");
                break;
            }

            Card dealtCard = nextCard.get();
            System.out.println(currentPlayer.getName() + " drew: \n\n" + dealtCard);

            if (previousCard != null && previousCard.getSymbol().equals(dealtCard.getSymbol())) {
                System.out.println("\nSnap! " + currentPlayer.getName() + " wins!\n");
                isGameOn = false;
            } else {
                currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;
            }

            previousCard = dealtCard;
        }
    }
}
