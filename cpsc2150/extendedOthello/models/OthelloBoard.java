package cpsc2150.extendedOthello.models;

import java.util.HashMap;

/**
 * The `OthelloBoard` class implements the board for an Othello game. It extends the abstract class `AbsOthelloBoard`.
 * This class manages the state of the board, including placing tokens, flipping opponent's tokens, checking win conditions, and calculating scores.
 * It assumes the board is 8x8, and that the only valid tokens are 'X' and 'O'.
 */
public class OthelloBoard extends AbsOthelloBoard {

    public static final int ROWS = 8;
    public static final int COLUMNS = 8;

    public static final char EMPTY = ' ';
    public static final char PLAYER1 = 'X';
    public static final char PLAYER2 = 'O';

    private char[][] board;

    /**
     * Initializes the 8x8 board with default pieces in the middle of the board.
     * The initial setup has 'X' and 'O' in the middle four positions: (3,3), (4,4), (3,4), and (4,3).
     */
    public OthelloBoard() {
        board = new char[ROWS][COLUMNS];

        // Initialize all cells to EMPTY
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                board[r][c] = EMPTY;
            }
        }

        // Set up the 4 default middle pieces
        board[3][3] = PLAYER1;
        board[4][4] = PLAYER1;
        board[3][4] = PLAYER2;
        board[4][3] = PLAYER2;
    }

    /**
     * Places a token at the specified position and flips the opponent's tokens in valid directions.
     * The method updates the board by placing the player's token and flipping any opponent's tokens in the appropriate directions.
     * 
     * @param p The player's token ('X' or 'O') to place on the board.
     * @param pos The position on the board where the token is to be placed.
     */
    @Override
    public void placeToken(char p, BoardPosition pos) {
        board[pos.getRow()][pos.getColumn()] = p;
        flipVertDirections(pos);
        flipHoriDirections(pos);
        flipDiagDirections(pos);
    }

    /**
     * Returns the token at the specified position on the board.
     * 
     * @param pos The position on the board to check.
     * @return The token at the specified position ('X', 'O', or ' ').
     */
    @Override
    public char whatsAtPos(BoardPosition pos) {
        return board[pos.getRow()][pos.getColumn()];
    }

    /**
     * Flips the opponent's tokens vertically (up and down) starting from the placed token.
     * 
     * @param startingPos The position where the token was placed.
     */
    @Override
    public void flipVertDirections(BoardPosition startingPos) {
        char currentPlayer = whatsAtPos(startingPos);
        char opponent = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;

        int row = startingPos.getRow();
        int col = startingPos.getColumn();

        // Up direction
        int r = row - 1;
        while (r >= 0 && board[r][col] == opponent) {
            r--;
        }
        if (r >= 0 && board[r][col] == currentPlayer) {
            for (int i = r + 1; i < row; i++) {
                board[i][col] = currentPlayer;
            }
        }

        // Down direction
        r = row + 1;
        while (r < ROWS && board[r][col] == opponent) {
            r++;
        }
        if (r < ROWS && board[r][col] == currentPlayer) {
            for (int i = row + 1; i < r; i++) {
                board[i][col] = currentPlayer;
            }
        }
    }

    /**
     * Flips the opponent's tokens horizontally (left and right) starting from the placed token.
     * 
     * @param startingPos The position where the token was placed.
     */
    @Override
    public void flipHoriDirections(BoardPosition startingPos) {
        char currentPlayer = whatsAtPos(startingPos);
        char opponent = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;

        int row = startingPos.getRow();
        int col = startingPos.getColumn();

        // Left direction
        int c = col - 1;
        while (c >= 0 && board[row][c] == opponent) {
            c--;
        }
        if (c >= 0 && board[row][c] == currentPlayer) {
            for (int i = c + 1; i < col; i++) {
                board[row][i] = currentPlayer;
            }
        }

        // Right direction
        c = col + 1;
        while (c < COLUMNS && board[row][c] == opponent) {
            c++;
        }
        if (c < COLUMNS && board[row][c] == currentPlayer) {
            for (int i = col + 1; i < c; i++) {
                board[row][i] = currentPlayer;
            }
        }
    }

    /**
     * Flips the opponent's tokens diagonally in all four diagonal directions starting from the placed token.
     * 
     * @param startingPos The position where the token was placed.
     */
    @Override
    public void flipDiagDirections(BoardPosition startingPos) {
        char currentPlayer = whatsAtPos(startingPos);
        char opponent = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;

        int row = startingPos.getRow();
        int col = startingPos.getColumn();

        // Top-left
        int r = row - 1;
        int c = col - 1;
        while (r >= 0 && c >= 0 && board[r][c] == opponent) {
            r--;
            c--;
        }
        if (r >= 0 && c >= 0 && board[r][c] == currentPlayer) {
            int i = row - 1;
            int j = col - 1;
            while (i > r && j > c) {
                board[i--][j--] = currentPlayer;
            }
        }

        // Top-right
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < COLUMNS && board[r][c] == opponent) {
            r--;
            c++;
        }
        if (r >= 0 && c < COLUMNS && board[r][c] == currentPlayer) {
            int i = row - 1;
            int j = col + 1;
            while (i > r && j < c) {
                board[i--][j++] = currentPlayer;
            }
        }

        // Bottom-left
        r = row + 1;
        c = col - 1;
        while (r < ROWS && c >= 0 && board[r][c] == opponent) {
            r++;
            c--;
        }
        if (r < ROWS && c >= 0 && board[r][c] == currentPlayer) {
            int i = row + 1;
            int j = col - 1;
            while (i < r && j > c) {
                board[i++][j--] = currentPlayer;
            }
        }

        // Bottom-right
        r = row + 1;
        c = col + 1;
        while (r < ROWS && c < COLUMNS && board[r][c] == opponent) {
            r++;
            c++;
        }
        if (r < ROWS && c < COLUMNS && board[r][c] == currentPlayer) {
            int i = row + 1;
            int j = col + 1;
            while (i < r && j < c) {
                board[i++][j++] = currentPlayer;
            }
        }
    }

    /**
     * Returns a deep copy of the current game board.
     * 
     * @return A 2D array representing a copy of the current board.
     */
    @Override
    public char[][] getBoardCopy() {
        char[][] copy = new char[ROWS][COLUMNS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                copy[r][c] = board[r][c];
            }
        }
        return copy;
    }

    /**
     * Checks if the specified position is valid for placing a token (i.e., it is empty and within the board).
     * 
     * @param pos The position to check.
     * @return true if the position is valid (empty and within the bounds); false otherwise.
     */
    @Override
    public boolean isPositionValid(BoardPosition pos) {
        int r = pos.getRow();
        int c = pos.getColumn();
        return r >= 0 && r < ROWS && c >= 0 && c < COLUMNS && board[r][c] == EMPTY;
    }

    /**
     * Forcefully places a token at the specified position without flipping any opponent tokens.
     * This is used for testing or initializing the board.
     * 
     * @param p The player token ('X' or 'O') to place.
     * @param pos The position on the board to place the token.
     */
    @Override
    public void forcePlace(char p, BoardPosition pos) {
        board[pos.getRow()][pos.getColumn()] = p;
    }

    /**
     * Checks if a specified player occupies the given position on the board.
     * 
     * @param pos The position to check.
     * @param player The player token ('X' or 'O') to check.
     * @return true if the player occupies the position; false otherwise.
     */
    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        return board[pos.getRow()][pos.getColumn()] == player;
    }

    /**
     * Checks if the given player has won the game (i.e., they have more tokens than the opponent at the end of the game).
     * 
     * @param player The player token ('X' or 'O') to check for a win.
     * @return true if the player has more tokens than the opponent and the board is full; false otherwise.
     */
    @Override
    public boolean checkPlayerWin(char player) {
        int totalFilled = 0;
        int playerCount = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (board[r][c] != EMPTY) {
                    totalFilled++;
                    if (board[r][c] == player) {
                        playerCount++;
                    }
                }
            }
        }
        return totalFilled == ROWS * COLUMNS && playerCount > (ROWS * COLUMNS) / 2;
    }

    /**
     * Gets the current score of the game (the number of tokens for each player).
     * 
     * @return An array where index 0 contains the score for PLAYER1 ('X'), and index 1 contains the score for PLAYER2 ('O').
     */
    @Override
    public int[] getScore() {
        int xCount = 0, oCount = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (board[r][c] == PLAYER1) xCount++;
                else if (board[r][c] == PLAYER2) oCount++;
            }
        }
        return new int[]{xCount, oCount};
    }

    /**
     * Gets the scores of the game as a `HashMap` containing the counts of tokens for each player.
     * 
     * @return A `HashMap` with 'X' and 'O' as keys and their respective token counts as values.
     */
    @Override
    public HashMap<Character, Integer> getScores() {
        HashMap<Character, Integer> scores = new HashMap<>();
        scores.put(PLAYER1, 0); // X
        scores.put(PLAYER2, 0); // O

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (board[r][c] == PLAYER1) {
                    scores.put(PLAYER1, scores.get(PLAYER1) + 1);
                } else if (board[r][c] == PLAYER2) {
                    scores.put(PLAYER2, scores.get(PLAYER2) + 1);
                }
            }
        }

        return scores;
    }
}
