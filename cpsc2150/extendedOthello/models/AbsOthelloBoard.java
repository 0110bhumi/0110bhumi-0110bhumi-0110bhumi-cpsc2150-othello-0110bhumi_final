package cpsc2150.extendedOthello.models;

import java.util.HashMap;

/**
 * AbsOthelloBoard provides a common toString implementation
 * for any Othello board by accessing interface methods.
 *
 * This class assumes the board is 8x8 and that
 * 'X' and 'O' are the only valid tokens.
 */
public abstract class AbsOthelloBoard implements IOthelloBoard {

    /**
     * Creates a visual representation of the board along with the current score.
     *
     * @return a string displaying the 8x8 board and the score of each player
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Header row with column numbers
        sb.append("  ");
        for (int c = 0; c < 8; c++) {
            sb.append(c).append(" ");
        }
        sb.append("\n");

        // Each row with row number and cell values
        for (int r = 0; r < 8; r++) {
            sb.append(r).append(" ");
            for (int c = 0; c < 8; c++) {
                sb.append(whatsAtPos(new BoardPosition(r, c))).append(" ");
            }
            sb.append("\n");
        }

        // Score section
        HashMap<Character, Integer> scores = getScores();
        sb.append("Score: X - ").append(scores.getOrDefault('X', 0));
        sb.append(" | O - ").append(scores.getOrDefault('O', 0));

        return sb.toString();
    }
}
