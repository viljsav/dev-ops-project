import java.util.Random;
import java.util.Scanner;

/**
 * RockPaperScissors is a simple game where players choose rock, paper, or scissors.
 *
 * The game can be played in singleplayer or in two-player mode.
 * The computer's choice is randomly generated in single-player mode.
 *
 * The game continues until the player chooses to quit.
 */

public class RockPaperScissors {

    private static final String[] options = {"rock", "paper", "scissors"};

    /**
     * Starts the Rock-Paper-Scissors game.
     *
     * Prompts the user to choose between singleplayer and two-player mode.
     * The game continues running until the user selects the quit option.
     *
     * @param scanner Scanner used for reading user input from the console
     */

    public static void runGame(Scanner scanner) {
        System.out.println("\nWelcome to Rock-Paper-Scissors Game!");
        Random r = new Random();
        boolean playing = true;

        while (playing) {
            System.out.println("\nSingleplayer (1) or two-players (2)? Enter 1 or 2");
            System.out.println("Press 0 to quit");
            System.out.print("Your choice: ");
            String mode = scanner.nextLine().trim();

            switch (mode) {
                case "1":
                    singlePlayer(scanner, r);
                    break;
                case "2":
                    twoPlayer(scanner);
                    break;
                case "0":
                    playing = false;
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    /**
     * Handles singleplayer round of the game.
     *
     * The user enters their choice, and the computer generates a random
     * choice. The method validates the input, prints both choices,
     * and displays the result of the round.
     *
     * @param scanner Scanner used for reading user input
     * @param r Random instance used to generate the computer's choice
     */

    private static void singlePlayer(Scanner scanner, Random r) {
        System.out.print("Enter rock, paper, or scissors: ");
        String choice = scanner.nextLine().toLowerCase();
        String computerChoice = options[r.nextInt(options.length)];

        if (!isValid(choice)) {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("Your choice: " + choice);
        System.out.println("Computer choice: " + computerChoice);

        String gameResult = result(choice, computerChoice, true);
        System.out.println(gameResult);
    }

    private static void twoPlayer(Scanner scanner) {
        System.out.print("Player 1, enter rock, paper, or scissors: ");
        String player1 = scanner.nextLine().toLowerCase();

        if (!isValid(player1)) {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.print("Player 2, enter rock, paper, or scissors: ");
        String player2 = scanner.nextLine().toLowerCase();

        if (!isValid(player2)) {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("Player 1 chose: " + player1);
        System.out.println("Player 2 chose: " + player2);

        String gameResult = result(player1, player2, false);
        System.out.println(gameResult);
    }

    private static boolean isValid(String choice) {
        for (String option : options) {
            if (option.equals(choice)) return true;
        }
        return false;
    }

    private static String result(String user, String opponent, boolean isSinglePlayer) {
        if (user.equals(opponent)) {
            return "Draw";
        } else if ((user.equals("rock") && opponent.equals("scissors")) ||
                   (user.equals("paper") && opponent.equals("rock")) ||
                   (user.equals("scissors") && opponent.equals("paper"))) {
            return isSinglePlayer ? "You win!" : "Player 1 wins!";
        } else {
            return isSinglePlayer ? "You lose!" : "Player 2 wins!";
        }
    }
}
