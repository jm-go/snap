package snap;

public class GameController {

    private Snap snap;
    private Commands commands = new Commands();

    public GameController() {
        this.snap = new Snap("Snap Game");
        String[] commandOptions = new String[]{"Play Alone", "Play with a Friend", "Quit"};
        commands.setCommands(commandOptions);
    }

    /**
     * Starts the Snap game, allowing the player to select game mode.
     * Manages the game flow based on the player's choice.
     * Invalid inputs prompt for a correct selection.
     */
    public void startGame() {
        System.out.println("\nWelcome to Snap!" + "\n");
        System.out.println("Please choose the game mode:");

        while (true) {
            commands.printCommands();
            int intInput = commands.getIntegerInput();

            switch (intInput) {
                case 0:
                    startAloneGame();
                    break;
                case 1:
                    //startDuoGame();
                    break;
                case 2:
                    System.out.println("\nQuitting the game. Goodbye!");
                    return;
                default:
                    System.out.println("\nInvalid input. Please select a valid option.");
                    break;
            }
        }
    }

    /**
     * Initialises and starts a single player Snap game.
     */
    private void startAloneGame() {
        System.out.println("\nSingle player mode selected.\n");
        snap.playGame();
    }


}
