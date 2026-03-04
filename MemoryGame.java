import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * MemoryGame is a simple console-based memory card game.
 *
 * The game board is 4x4 and contains 8 pairs of matching cards.
 * The player selects two cards per turn and tries to find matching pairs.
 *
 * The game continues until all pairs are found or the player quits.
 */

public class MemoryGame {

    private static final String[][] board = new String[4][4];
    private static final boolean[][] revealed = new boolean[4][4];

    /**
     * Starts and runs the Memory Game.
     *
     * Initializes the board and controls the main game loop.
     * The player selects two cards per turn. If the cards match,
     * the pair is counted as found. The game ends when all pairs
     * are found or when the player chooses to quit.
     *
     * @param scanner Scanner used for reading user input
     */

    public static void runMG(Scanner scanner) {
        int found = 0;
        int pairs = 8;

        fillBoard();

        while (found < pairs) {
            printBoard();

            System.out.println("Select first card (enter 0 to quit):");
            int[] first = select(scanner);
            if (first[0] == -1) break;
            revealed[first[0]][first[1]] = true;
            printBoard();

            System.out.println("Select second card");
            int[] second = select(scanner);
            if (second[0] == -1) break;
            revealed[second[0]][second[1]] = true;
            printBoard();

            if (board[first[0]][first[1]].equals(board[second[0]][second[1]])) {
                System.out.println("You found a match!");
                found++;
            } else {
                System.out.println("Not a match.");
                revealed[first[0]][first[1]] = false;
                revealed[second[0]][second[1]] = false;
            }
        }

        if (found == pairs) {
            System.out.println("You found all pairs!");
        } else {
            System.out.println("Game terminated by user.");
        }
    }

    /**
     * Fills the game board with shuffled card pairs.
     *
     * Creates 8 pairs of numbered cards (1–8), shuffles them,
     * and assigns them to the 4x4 board.
     */

    private static void fillBoard() {
        List<String> cards = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            cards.add(String.valueOf(i));
            cards.add(String.valueOf(i));
        }

        Collections.shuffle(cards);

        int cardIndex = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = cards.get(cardIndex);
                revealed[i][j] = false;
                cardIndex++;
            }
        }
    }

    /**
     * Prints the current state of the game board to the console.
     *
     * Revealed cards display their value, while hidden cards
     * are shown as empty brackets.
     */

    private static void printBoard() {
        System.out.println("\nMemory Game\n");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (revealed[i][j]) {
                    System.out.print(" [" + board[i][j] + "] ");
                } else {
                    System.out.print(" [ ] ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Prompts the player to select a card by entering row and column.
     *
     * Validates user input to ensure coordinates are within bounds
     * and the selected card is not already revealed.
     *
     * Entering 0 for row or column will terminate the game.
     *
     * @param scanner Scanner used for reading user input
     * @return an integer array containing the selected row and column,
     *         or {-1, -1} if the user chooses to quit
     */

    private static int[] select(Scanner scanner) {
        int row = -1;
        int col = -1;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Enter row number (1-4): ");
                row = Integer.parseInt(scanner.nextLine()) - 1;
                if (row == -1) return new int[]{-1, -1};

                System.out.print("Enter column number (1-4): ");
                col = Integer.parseInt(scanner.nextLine()) - 1;
                if (col == -1) return new int[]{-1, -1};

                if (row >= 0 && row < 4 && col >= 0 && col < 4) {
                    if (!revealed[row][col]) {
                        valid = true;
                    } else {
                        System.out.println("Card already revealed. Choose another.");
                    }
                } else {
                    System.out.println("Invalid coordinates.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter numbers");
            }
        }

        return new int[]{row, col};
    }
}
