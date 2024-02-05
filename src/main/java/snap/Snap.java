package snap;

import java.util.Optional;
import java.util.Scanner;

public class Snap extends CardGame {

    private Card previousCard;
    private Player playerOne;
    private Player playerTwo;
    private Scanner scanner = new Scanner(System.in);
    private boolean isGameOn = true;

    public Snap(String name) {
        super(name);
        this.shuffleDeck();
    }

    // Refactor and add comment
    public void playAloneGame() {
        while (isGameOn) {
            System.out.println("Press 'Enter' to take your turn.");
            scanner.nextLine();
            takeTurn(null);
        }
    }

    // Refactor and add comment
    public void playDuoGame() {
        setupPlayers();
        Player currentPlayer = playerOne;

        while (isGameOn) {
            System.out.println("\n" + currentPlayer.getName() + "'s turn. Press 'Enter' to draw a card.");
            scanner.nextLine();
            takeTurn(currentPlayer);
            currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;
        }
    }

    private void setupPlayers() {
        Commands commands = new Commands();
        System.out.print("Please enter a name for Player 1: ");
        playerOne = new Player(commands.getNameInput());
        System.out.print("\nPlease enter a name for Player 2: ");
        playerTwo = new Player(commands.getNameInput());
    }

    private void takeTurn(Player currentPlayer) {
        Optional<Card> nextCard = this.dealCard();
        if (nextCard.isEmpty()) {
            System.out.println("\nThe card deck is now empty. Game over.\n");
            isGameOn = false;
            return;
        }

        Card dealtCard = nextCard.get();
        if (currentPlayer == null) {
            System.out.println("You drew: \n\n" + dealtCard + "\n");
        } else {
            System.out.println(currentPlayer.getName() + " drew: \n\n" + dealtCard);
        }

        checkWin(dealtCard, currentPlayer);
        previousCard = dealtCard;
    }

    private void checkWin(Card dealtCard, Player currentPlayer) {
        if (previousCard != null && previousCard.getSymbol().equals(dealtCard.getSymbol())) {
            if (currentPlayer == null) {
                System.out.println("Snap! You win!\n");
            } else {
                System.out.println("\nSnap! " + currentPlayer.getName() + " wins!\n");
            }
            isGameOn = false;
        }
    }
}
