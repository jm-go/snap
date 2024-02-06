package snap.gameLogic;

import snap.ui.Commands;
import snap.player.Player;

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

    /**
     * Starts a single-player Snap game.
     * The game runs in a loop until the deck is empty or a snap is found.
     */
    public void playAlone() {
        while (isGameOn) {
            System.out.println("Press 'Enter' to take your turn.");
            scanner.nextLine();
            takeTurn(null);
        }
    }

    /**
     * Starts a two-player Snap game.
     * Players take turns drawing cards from the deck and the game continues
     * until the deck is empty or a snap is found.
     */
    public void playDuo() {
        addPlayers();
        Player currentPlayer = playerOne;

        while (isGameOn) {
            System.out.println("\n" + currentPlayer.getName() + "'s turn. Press 'Enter' to draw a card.");
            scanner.nextLine();
            takeTurn(currentPlayer);
            currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;
        }
    }

    /**
     * Sets up the player names for a two-player game.
     */
    private void addPlayers() {
        Commands commands = new Commands();
        System.out.print("Please enter a name for Player 1: ");
        playerOne = new Player(commands.getNameInput());
        System.out.print("\nPlease enter a name for Player 2: ");
        playerTwo = new Player(commands.getNameInput());
    }

    /**
     * Manages a turn for the given player in the game of Snap.
     * It deals a card, displays it, and checks for a winning condition.
     *
     * @param currentPlayer The current player in two-player mode, or null for single-player mode.
     */
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

    /**
     * Checks if the current card matches the previous card's symbol,
     * indicating a win in Snap game.
     *
     * @param dealtCard The card drawn in the current turn.
     * @param currentPlayer The player who drew the card, or null for single-player mode.
     */
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
