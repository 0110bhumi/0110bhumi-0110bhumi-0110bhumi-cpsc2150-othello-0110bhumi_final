package cpsc2150.extendedOthello.models;

/**
 * The `BoardPosition` class represents a position on the Othello game board.
 * It holds the row and column of the board, providing methods to access 
 * the position and check its validity within the bounds of the game.
 * This class is essential for determining where tokens are placed and how
 * they are manipulated on the board.
 */
public class BoardPosition {
    private int row;
    private int col;

    /**
     * Constructs a new `BoardPosition` with the specified row and column.
     * 
     * @param r The row of the board position (0-7).
     * @param c The column of the board position (0-7).
     */
    public BoardPosition(int r, int c) {
        this.row = r;
        this.col = c;
    }

    /**
     * Returns the row of the board position.
     * 
     * @return The row index (0-7) of the board position.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of the board position.
     * 
     * @return The column index (0-7) of the board position.
     */
    public int getColumn() {
        return col;
    }

    /**
     * Checks if the given row and column values are within the valid bounds of the board.
     * The valid indices for row and column are 0 through 7 (inclusive).
     * 
     * @param row The row index to check.
     * @param col The column index to check.
     * @return true if the position is within the 8x8 board; false otherwise.
     */
    public static boolean isInBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    /**
     * Compares this `BoardPosition` to another object for equality.
     * Two `BoardPosition` objects are considered equal if they have the same row and column values.
     * 
     * @param obj The object to compare this `BoardPosition` to.
     * @return true if the object is a `BoardPosition` and has the same row and column; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BoardPosition)) return false;
        BoardPosition other = (BoardPosition) obj;
        return this.row == other.row && this.col == other.col;
    }

    /**
     * Returns a hash code for this `BoardPosition`.
     * The hash code is computed based on the row and column values.
     * 
     * @return A hash code for this `BoardPosition`.
     */
    @Override
    public int hashCode() {
        return 31 * row + col;
    }

    /**
     * Returns a string representation of the `BoardPosition`.
     * The string is formatted as "row,column".
     * 
     * @return A string representing the row and column of the position.
     */
    @Override
    public String toString() {
        return row + "," + col;
    }
}
