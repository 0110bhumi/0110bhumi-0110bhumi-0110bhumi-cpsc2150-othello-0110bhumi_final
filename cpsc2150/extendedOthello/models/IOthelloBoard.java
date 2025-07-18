package cpsc2150.extendedOthello.models;
import java.util.HashMap;

/**
 * IOthelloBoard interface defines the public behaviors required for an Othello board implementation.
 */
public interface IOthelloBoard {

    /**
     * Places a player's token at the specified position and flips the opponent's tokens accordingly.
     * 
     * @param p the player token ('X' or 'O')
     * @param pos the position to place the token
     * 
     * @pre p == 'X' or p == 'O' AND pos != null AND isPositionValid(pos)
     * @post the token is placed and the board is updated with flipped tokens
     */
    void placeToken(char p, BoardPosition pos);

    /**
     * Returns the character at a given position on the board.
     *
     * @param pos The board position to check.
     * @return The character at that position ('X', 'O', or ' ')
     * 
     * @pre pos != null
     * @post returns the value at the specified board position
     */
    char whatsAtPos(BoardPosition pos);

    /**
     * Flips tokens vertically (up and down) starting from the placed token.
     * 
     * @param startingPos the newly placed token's position
     */
    void flipVertDirections(BoardPosition startingPos);

    /**
     * Flips tokens horizontally (left and right) starting from the placed token.
     * 
     * @param startingPos the newly placed token's position
     */
    void flipHoriDirections(BoardPosition startingPos);

    /**
     * Flips tokens diagonally in all four diagonal directions.
     * 
     * @param startingPos the newly placed token's position
     */
    void flipDiagDirections(BoardPosition startingPos);

    /**
     * Checks if a position on the board is empty and valid to place a token.
     * 
     * @param pos the board position to check
     * @return true if the position is within bounds and unoccupied
     */
    boolean isPositionValid(BoardPosition pos);

    /**
     * Checks if a player occupies the specified board position.
     * 
     * @param pos the position to check
     * @param player the player token ('X' or 'O')
     * @return true if the specified player occupies that position
     */
    boolean isPlayerAtPos(BoardPosition pos, char player);

    /**
     * Checks if the given player has won the game (i.e., has more tokens when the board is full).
     * 
     * @param player the player token to check for victory
     * @return true if the player has the majority of tokens at game end
     */
    boolean checkPlayerWin(char player);

    /**
     * Gets the current score of the game.
     * 
     * @return An int array where index 0 is score of X and index 1 is score of O
     */
    int[] getScore();

    /**
     * Forcefully places a token at a position without flipping any tokens (used for setup/testing).
     * 
     * @param p the player token ('X' or 'O')
     * @param pos the position to place the token
     */
    void forcePlace(char p, BoardPosition pos);

    /**
     * Returns a deep copy of the current game board.
     * 
     * @return a 2D character array copy of the board
     */
    char[][] getBoardCopy();

    /**
     * Provides a string representation of the board and score.
     * 
     * @return A visual string of the game board including player scores
     */
    @Override
    String toString();

    /**
     * Gets the scores of the game as a HashMap.
     * 
     * @return A HashMap containing 'X' and 'O' as keys, with their respective scores as values
     */
    HashMap<Character, Integer> getScores();
}
