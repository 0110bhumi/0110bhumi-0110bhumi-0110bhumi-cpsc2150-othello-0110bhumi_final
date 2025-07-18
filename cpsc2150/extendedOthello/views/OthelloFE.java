package cpsc2150.extendedOthello.views;

import cpsc2150.extendedOthello.models.*;

import java.util.Scanner;

/**
 * The `OthelloFE` (front-end) class handles the user interaction and controls the flow of the game.
 * It manages the game loop, player turns, input validation, and updates the board after each move.
 * The game alternates between two players and ends when both players have no valid moves left.
 */
public class OthelloFE {

    /**
     * Main method that runs the Othello game. It initializes the game board, manages player turns,
     * validates moves, and checks for the game over condition.
     * 
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IOthelloBoard gameBoard = new OthelloBoard();
        char currentPlayer = 'X';

        System.out.println("Welcome to Othello!");

        // Main game loop
        while (true) {
            System.out.println("\nCurrent Board:");
            System.out.println(gameBoard.toString());

            // Check if current player has any valid moves left
            if (!hasAnyValidMoves(gameBoard, currentPlayer)) {
                System.out.println("No valid moves left for player " + currentPlayer + ".");
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

                // Check if the opponent also has no valid moves (game over condition)
                if (!hasAnyValidMoves(gameBoard, currentPlayer)) {
                    System.out.println("No valid moves left for both players. Game Over!");
                    break;
                } else {
                    System.out.println("Turn skipped.");
                    continue;
                }
            }

            // Prompt current player for their move
            System.out.println("Player " + currentPlayer + ", it's your turn.");
            BoardPosition move;

            while (true) {
                // Get valid row and column from user
                System.out.print("Enter row (0–7): ");
                int row = getValidInt(sc);

                System.out.print("Enter column (0–7): ");
                int col = getValidInt(sc);

                if (!BoardPosition.isInBounds(row, col)) {
                    System.out.println("Position out of bounds. Try again.");
                    continue;
                }

                move = new BoardPosition(row, col);

                // Check if position is valid
                if (!gameBoard.isPositionValid(move)) {
                    System.out.println("Position is invalid or already occupied. Try again.");
                    continue;
                }

                // Ensure move is adjacent to an opponent token
                if (!hasAdjacentOpponent(gameBoard, move, currentPlayer)) {
                    System.out.println("Invalid move. Must be adjacent to opponent token. Try again.");
                    continue;
                }

                break;
            }

            // Place the token and flip the opponent's tokens
            gameBoard.placeToken(currentPlayer, move);
            gameBoard.flipVertDirections(move);
            gameBoard.flipHoriDirections(move);
            gameBoard.flipDiagDirections(move);

            // Check for win condition
            if (gameBoard.checkPlayerWin(currentPlayer)) {
                System.out.println(gameBoard.toString());
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Switch player for next turn
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        // Close the scanner object to avoid memory leaks
        sc.close();
    }

    /**
     * Prompts the user for a valid integer input and ensures the input is an integer.
     * If the input is not a valid integer, the user is asked to enter a valid integer.
     * 
     * @param sc The scanner object to read input.
     * @return The valid integer input from the user.
     */
    private static int getValidInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid integer: ");
            sc.next(); // Discard invalid input
        }
        return sc.nextInt();
    }

    /**
     * Checks if a given move is adjacent to at least one opponent's token.
     * This is required for the move to be valid in Othello.
     * 
     * @param board The current Othello game board.
     * @param pos The position to check for an adjacent opponent token.
     * @param player The current player ('X' or 'O').
     * @return true if the position is adjacent to at least one opponent's token; false otherwise.
     */
    private static boolean hasAdjacentOpponent(IOthelloBoard board, BoardPosition pos, char player) {
        char opponent = (player == 'X') ? 'O' : 'X';
        int[] directions = {-1, 0, 1};

        // Check all 8 possible directions for an opponent token
        for (int dr : directions) {
            for (int dc : directions) {
                if (dr == 0 && dc == 0) continue; // Skip checking the current position

                int newRow = pos.getRow() + dr;
                int newCol = pos.getColumn() + dc;

                if (BoardPosition.isInBounds(newRow, newCol)) {
                    BoardPosition adjPos = new BoardPosition(newRow, newCol);
                    if (board.whatsAtPos(adjPos) == opponent) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Checks if the current player has any valid moves left on the board.
     * This ensures that the game doesn't continue if the player cannot make a valid move.
     * 
     * @param board The current Othello game board.
     * @param player The current player ('X' or 'O').
     * @return true if the player has at least one valid move left; false otherwise.
     */
    private static boolean hasAnyValidMoves(IOthelloBoard board, char player) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                BoardPosition pos = new BoardPosition(r, c);
                if (board.isPositionValid(pos) && hasAdjacentOpponent(board, pos, player)) {
                    return true;
                }
            }
        }
        return false;
    }
}
