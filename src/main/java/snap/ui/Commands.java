package snap.ui;

import java.util.Scanner;

public class Commands {
    private Scanner scanner = new Scanner(System.in);
    private String[] commands;

    public void setCommands(String[] commands) {
        this.commands = commands;
    }

    /**
     * Displays the available commands to the player.
     * If no commands are set, it indicates that there are no current commands.
     * Otherwise, it lists all commands with their corresponding indices.
     */
    public void printCommands() {
        if (commands == null || commands.length == 0) {
            System.out.println("No current commands set.");
        } else {
            for (int i = 0; i < commands.length; i++) {
                System.out.println(i + ": " + commands[i]);
            }
        }
    }

    /**
     * Retrieves an integer input from the user within the range of available commands.
     * It continues to prompt the user until a valid integer is entered.
     *
     * @return The validated integer input within the specified range.
     */
    public Integer getIntegerInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= 0 && input < commands.length) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and " + (commands.length - 1) + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    /**
     * Reads a String input from the user.
     * Validates the input to ensure it is a word containing characters from A-Z
     * and repeats the prompt if needed. Makes the first character uppercase.
     *
     * @return The validated String input as the player's name.
     */
    public String getNameInput() {
        while (true) {
            String name = scanner.nextLine().trim();
            if (!name.isEmpty() && name.matches("[a-zA-Z]+")) {
                return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            } else {
                System.out.println("Invalid input. Please enter a valid name.");
            }
        }
    }
}
