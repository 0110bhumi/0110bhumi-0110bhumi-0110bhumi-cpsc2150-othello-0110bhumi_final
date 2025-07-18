package cpsc2150.extendedOthello.tests;

import cpsc2150.extendedOthello.models.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for verifying the functionality of the OthelloBoard class.
 * It ensures that the methods of OthelloBoard work correctly through various test cases.
 */
public class TestOthelloBoard {

    /**
     * Converts the given board into a string representation for easier comparison in tests.
     * 
     * @param board 2D array representing the Othello board.
     * @return String representation of the board.
     */
    private String convertBoardToString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char cell : row) {
                sb.append(cell);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Tests the initial state of the Othello board to ensure the pieces are correctly placed.
     * The expected initial state places 'X' and 'O' in the middle.
     */
    @Test
    public void testInitialBoardState() {
        IOthelloBoard board = new OthelloBoard();

        char[][] expected = new char[8][8];
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                expected[r][c] = ' ';
            }
        }
        expected[3][3] = 'X';
        expected[3][4] = 'O';
        expected[4][3] = 'O';
        expected[4][4] = 'X';

        assertEquals("Initial board state is incorrect.",
                convertBoardToString(expected), convertBoardToString(board.getBoardCopy()));
    }

    /**
     * Tests the functionality of the `whatsAtPos` method by checking if the token at position (3, 3) is 'X'.
     */
    @Test
    public void testWhatsAtPos_Initial_X_at_3_3() {
        IOthelloBoard board = new OthelloBoard();
        assertEquals('X', board.whatsAtPos(new BoardPosition(3, 3)));
    }

    /**
     * Tests the functionality of the `whatsAtPos` method by checking if the token at position (4, 4) is 'X'.
     */
    @Test
    public void testWhatsAtPos_Initial_X_at_4_4() {
        IOthelloBoard board = new OthelloBoard();
        assertEquals('X', board.whatsAtPos(new BoardPosition(4, 4)));
    }

    /**
     * Tests the functionality of the `whatsAtPos` method by checking if the token at position (3, 4) is 'O'.
     */
    @Test
    public void testWhatsAtPos_Initial_O_at_3_4() {
        IOthelloBoard board = new OthelloBoard();
        assertEquals('O', board.whatsAtPos(new BoardPosition(3, 4)));
    }

    /**
     * Tests the functionality of the `whatsAtPos` method by checking if the position (0, 0) is empty.
     */
    @Test
    public void testWhatsAtPos_Empty_TopLeft() {
        IOthelloBoard board = new OthelloBoard();
        assertEquals(' ', board.whatsAtPos(new BoardPosition(0, 0)));
    }

    /**
     * Tests the validity of an empty position (0, 0) to ensure it's a valid move.
     */
    @Test
    public void testIsPositionValid_EmptyTrue() {
        IOthelloBoard board = new OthelloBoard();
        assertTrue(board.isPositionValid(new BoardPosition(0, 0)));
    }

    /**
     * Tests the validity of a filled position (3, 3) to ensure it's not a valid move.
     */
    @Test
    public void testIsPositionValid_FilledFalse() {
        IOthelloBoard board = new OthelloBoard();
        assertFalse(board.isPositionValid(new BoardPosition(3, 3)));
    }

    /**
     * Tests that placing a token at position (2, 3) correctly flips a token vertically at position (3, 3).
     */
    @Test
    public void testPlaceToken_FlipsVertically() {
        IOthelloBoard board = new OthelloBoard();
        board.placeToken('X', new BoardPosition(2, 3));

        assertEquals('X', board.whatsAtPos(new BoardPosition(2, 3)));
        assertEquals("Token at (3,3) should flip to X", 'X', board.whatsAtPos(new BoardPosition(3, 3)));
    }

    /**
     * Tests the `isPlayerAtPos` method to ensure that player 'X' occupies position (3, 3).
     */
    @Test
    public void testIsPlayerAtPos_ReturnsTrue() {
        IOthelloBoard board = new OthelloBoard();
        assertTrue(board.isPlayerAtPos(new BoardPosition(3, 3), 'X'));
    }

    /**
     * Tests the `isPlayerAtPos` method to ensure that position (0, 0) does not contain player 'O'.
     */
    @Test
    public void testIsPlayerAtPos_ReturnsFalse() {
        IOthelloBoard board = new OthelloBoard();
        assertFalse(board.isPlayerAtPos(new BoardPosition(0, 0), 'O'));
    }

    /**
     * Tests that when the board is fully filled with 'X', player 'X' wins the game.
     */
    @Test
    public void testCheckPlayerWin_AllXTrue() {
        IOthelloBoard board = new OthelloBoard();

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board.forcePlace('X', new BoardPosition(r, c));
            }
        }

        assertTrue(board.checkPlayerWin('X'));
        assertFalse(board.checkPlayerWin('O'));
    }

    /**
     * Tests the `getScore` method to verify the initial scores for players 'X' and 'O'.
     */
    @Test
    public void testGetScore_Initial() {
        IOthelloBoard board = new OthelloBoard();
        int[] scores = board.getScore();
        assertEquals("Score for X should be 2", 2, scores[0]);
        assertEquals("Score for O should be 2", 2, scores[1]);
    }

    /**
     * Tests the `toString` method to ensure that the output contains the correct score summary for players.
     */
    @Test
    public void testToString_ContainsScoreSummary() {
        IOthelloBoard board = new OthelloBoard();
        String output = board.toString();
        assertTrue("toString should contain score for X", output.contains("X -"));
        assertTrue("toString should contain score for O", output.contains("O -"));
    }
}
